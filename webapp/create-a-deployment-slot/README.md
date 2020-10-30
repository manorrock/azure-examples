
# Create a deployment slot

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../../appservice/plan/create/)
1. [Deploy a Web application on Azure App Service (managed Tomcat)](../tomcat-helloworld/)

## Create a deployment slot

To create deployment slot use the following command line:

```shell
  az webapp deployment slot create \
    --resource-group $RESOURCE_GROUP \
    --name $TOMCAT_HELLOWORLD_WEBAPP \
    --slot staging
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m