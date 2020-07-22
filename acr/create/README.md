
# Deploy an Azure Container Registry

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)

## Deploy a basic Azure Container Registry

To deploy the basic Azure Container Registry use the following command line:

```shell
  export ACR_NAME=acr$RANDOM

  az acr create \
    --name $ACR_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku Basic \
    --admin-enabled true
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m