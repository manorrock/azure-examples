
# Scale your App Service Plan manually

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an App Service plan](../create-plan/)
1. [Deploy a Web application on Azure App Service (managed Tomcat)](../tomcat-helloworld/)

## Scale the Azure App Service Plan

To scale the Azure App Service Plan use the following command line:

<!-- workflow.include(../tomcat-helloworld/README.md) -->

```shell
  az appservice plan update \
    --verbose \
    --name $APP_SERVICE_PLAN \
    --resource-group $RESOURCE_GROUP \
    --number-of-workers 2
```

Adjust the number to the desired number of workers.

## Cleanup

Do NOT forget to remove resources once you are done running the example.
