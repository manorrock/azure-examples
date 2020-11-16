
# Create a Quarkus application packaged as a Docker image and push it to Azure Container Registry

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Container Registry](../create/)

## Build the example

To build the JAR file use the following Maven command line:

```shell
  mvn package
```

## Run the example locally

To run the example locally use the following Maven command line:

```shell
  mvn quarkus:dev
```

You can see the application in action at http://localhost:8080/hello

## Build and push the Docker image to your Azure Container Registry

To build and push the Docker image to your ACR use the command lines below:

```shell
  export ACR_QUARKUS_IMAGE=acr-quarkus:latest

  az acr build --registry $ACR_NAME --image $ACR_QUARKUS_IMAGE .
```

## Cleanup

Do NOT forget to remove the App Service and its associated resources once you are
done running the example.

4m