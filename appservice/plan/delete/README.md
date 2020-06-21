
# Delete an Azure App Service Plan

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure App Service Plan](../create/)

## Delete the Azure App Service Plan

To delete the Azure App Service Plan use the following command line:

```shell
  az appservice plan delete \
    --resource-group $RESOURCE_GROUP \
    --name $APP_SERVICE_PLAN \
    --yes
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
