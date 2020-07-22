
# Create a GraalVM application and deploy it to Azure App Service (using a Docker image)

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Container Registry](../../acr/create/)
1. [Create settings.xml for your Azure Container Registry (using admin access keys)](../../acr/create-access-keys-settings-xml/)
1. [Create an Azure App Service Plan](../../appservice/plan/create/)

## Build the example

To build the JAR file use the following command line:

```shell
  mvn package
```

## Build the builder image

In order to build the Linux native image we need a GraalVM version that is 
executed on Linux. The command below will generate a Docker image with what we
need.

```shell
  docker build -t builder -f Dockerfile.builder .
```

## Execute the builder image to build the Linux binary

The next step is to use the builder image to generate the Linux binary. Execute
the command line below. Note if you are on Windows please replace $PWD with the
path of the current directory.

```shell
  docker run --rm -it -v $PWD/../..:/mnt builder mvn -P graalvm -pl \
    webapp/docker-graalvm clean install  
```

## Push the Docker image to your Azure Container Registry

```shell
  export IMAGE=graalvm:latest

  az acr build --registry $ACR_NAME --image $IMAGE .
```

## Deploy the example

To deploy the example use the following Maven command line.

````shell
  export GRAALVM_NAME=graalvm-$RANDOM

  mvn azure-webapp:deploy --settings=$SETTINGS_XML -DappName=$GRAALVM_NAME
````

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
