
# Delete your web application from Azure App Service

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy a Web application on Azure App Service (managed Tomcat)](../tomcat-helloworld/)

## Delete the web application

To delete the web application from Azure App Service use the following command
line:

```shell
  az webapp delete --resource-group $RESOURCE_GROUP' --name FILL_THIS_IN
```

Note if you do not know what the value of `FILL_THIS_IN` should be, you can
determine which applications you have running on Azure App Service by 
following the guidance in [List your Azure App Services](../list/)

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
