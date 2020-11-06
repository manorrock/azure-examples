
# Swap a deployment slot

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../../create-plan/)
1. [Deploy a Web application on a managed Tomcat](../tomcat-helloworld/)
1. [Create a deployment slot](../create-deployment-slot/)
1. [Deploy to a deployment slot](../deploy-to-deployment-slot/)

## Swap a deployment slot

<!-- workflow.include(../deploy-to-deployment-slot/README.md) -->

To swap deployment slot use the following command line:

```shell
  az webapp deployment slot swap \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_TOMCAT_HELLOWORLD \
    --slot staging
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

2m
