
# Create an Azure App Service Plan

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../../group/create/)

## Create the Azure App Service Plan

To create the Azure App Service Plan use the following command line:

```shell
  export APP_SERVICE_PLAN=appservice-plan

  az appservice plan create \
    --resource-group $RESOURCE_GROUP \
    --location westus2 \
    --name $APP_SERVICE_PLAN \
    --is-linux \
    --sku P1V2
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
