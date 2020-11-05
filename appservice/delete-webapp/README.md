
# Delete a Web Application

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../group/create/)
1. [Deploy a Web application on a managed Tomcat](../tomcat-helloworld/)

## Delete a Web Application

<!-- workflow.include(../tomcat-helloworld/README.md) -->

To delete the web application from Azure App Service use the following command
line:

```shell
  az webapp delete --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD
```

Note you can substitute $APPSERVICE_TOMCAT_HELLOWORLD with the name of any web 
application you want to delete in your resource group.

<!-- workflow.directOnly() 

export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD --output tsv --query state)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" == Running ]]; then
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
