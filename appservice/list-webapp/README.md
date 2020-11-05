
# List your Web applications on Azure App Service

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../group/create/)
1. [Create an Azure App Service Plan](../create-plan/)
1. [Deploy a Web application on a managed Tomcat](../tomcat-helloworld/)

## List your Web applications on Azure App Service

<!-- workflow.include(../tomcat-helloworld/README.md) -->

To list the Web applications on Azure App Service use the following command line:

```shell
  az webapp list --resource-group $RESOURCE_GROUP
```

<!-- workflow.directOnly

export RESULT=$(az webapp list --resource-group $RESOURCE_GROUP --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != "" ]]; then
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
