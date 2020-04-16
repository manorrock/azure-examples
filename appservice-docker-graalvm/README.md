
# Create a custom WildFly and deploy it to Azure App Service (using a Docker image)

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Deploy an Azure Container Registry](../acr-create/README.md)
1. [Create settings.xml for your Azure Container Registry (using admin access keys)](../acr-create-access-keys-settings-xml/README.md)
1. [Create an Azure App Service Plan](../appserviceplan-create/README.md)

## Build the example

To build the JAR file use the following Maven command line.

````shell
  mvn package
````

## Build the builder image

In order to build the Linux native image we need a GraalVM version that is 
executed on Linux. The command below will generate a Docker image with what we
need

```shell
  mvn antrun:run@builder
```

## Execute the builder image to build the Linux binary

The next step is to use the builder image to generate the Linux binary. Execute
the command line below. Note if you are on Windows please replace $PWD with the
path of the current directory.

```shell
  docker run --rm -it -v $PWD/..:/mnt builder mvn -P safeguard,graalvm -pl appservice-docker-graalvm clean install  
```

## Push the Docker image to your Azure Container Registry

````shell
  mvn antrun:run@push -Dexample.registry=REGISTRY
````

Where ```REGISTRY``` is the name of your Azure Container Registry.

## Deploy the example

To deploy the example use the following Maven command line.

````shell
  mvn azure-webapp:deploy --settings=SETTINGS_XML -Dexample.serverId=SERVER_ID
````

Where ```SETTINGS_XML``` points to the settings.xml you will use for deployment and ```SERVER_ID``` refers to the ```<server>``` block in the settings.xml used by the plugin to communicate what credentials are to be used to pull the image from the Azure Container Registry when deploying the App Service.

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                   | description                      |
|------------------------|----------------------------------|
| example.appName        | the application name             |
| example.appServicePlan | the App Service plan to use      |
| example.imageName      | the Docker image name            |
| example.serverId       | the Maven server id              |
| example.registry       | the Azure Container Registry name|
| example.registryUrl    | the Azure Container Registry url |
| example.resourceGroup  | the Azure Resource Group name    |

## Cleanup

Do NOT forget to remove the App Service and its associated resources once you are
done running the example.
