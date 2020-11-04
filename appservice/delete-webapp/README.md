
# Delete your web application from Azure App Service

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../group/create/)
1. [Deploy a Web application on Azure App Service (managed Tomcat)](../tomcat-helloworld/)

## Delete the web application

<!-- workflow.include(../tomcat-helloworld/README.md) -->

To delete the web application from Azure App Service use the following command
line:

```shell
  az webapp delete --resource-group $RESOURCE_GROUP --name $TOMCAT_HELLOWORLD_WEBAPP
```

Or change the value of $TOMCAT_HELLOWORLD_WEBAPP to the name of the web
application you want to delete.

<!-- workflow.directOnly() 

export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $TOMCAT_HELLOWORLD_WEBAPP --output tsv --query state)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" == Running ]]; then
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
