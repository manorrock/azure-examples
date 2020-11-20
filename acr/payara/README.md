
# Create a custom Payara Docker image and push it to Azure Container Registry

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Container Registry](../create/)

## Build the WAR file

To build the WAR file use the following command line:

```shell
  mvn package
```

## Build and push the Docker image to your Azure Container Registry

To build and push the Docker image to your ACR use the command line below:

```shell
  export ACR_PAYARA_IMAGE=acr-payara:latest

  az acr build --registry $ACR --image $ACR_PAYARA_IMAGE .
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

3m
