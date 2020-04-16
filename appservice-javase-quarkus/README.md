
# Create a Quarkus application and deploy it to Azure App Service (using JavaSE)

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Create an Azure App Service Plan](../appserviceplan-create/README.md)

## Build the example

To build the JAR file use the following Maven command line.

```shell
  mvn package
```

## Run example locally

To run the example locally use the following Maven command line.

```shell
  mvn quarkus:dev
```

You can see the application in action at http://localhost:8080/hello

## Deploy the example

To deploy the example use the following Maven command line.

```shell
  mvn azure-webapp:deploy
```

Once the command completes you will be able to see the example by using your web
browser and going to the ```xxxxx.azurewebsites.net``` address the command echoes.

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                   | description                      |
|------------------------|----------------------------------|
| example.appName        | the application name             |
| example.appServicePlan | the App Service plan to use      |
| example.resourceGroup  | the Azure Resource Group name    |

## Cleanup

Do NOT forget to remove the App Service and its associated resources once you are
done running the example.
