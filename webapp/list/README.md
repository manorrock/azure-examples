
# List your Azure App Services

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../../appserviceplan-create/README.md)
1. [Deploy a Web application on Azure App Service (managed Tomcat)](../tomcat-helloworld/)

## List your web applications on Azure App Service

To list the web applications on Azure App Service use the following command line:

```shell
  az webapp list --resource-group $RESOURCE_GROUP
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
