
# Create a deployment slot

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../group/create/)
1. [Create an Azure App Service Plan](../create-plan/)
1. [Deploy a Web application on Azure App Service (managed Tomcat)](../tomcat-helloworld/)

## Create a deployment slot

<!-- workflow.include(../tomcat-helloworld/README.md) -->

To create a deployment slot use the following command line:

```shell
  az webapp deployment slot create \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_TOMCAT_HELLOWORLD \
    --slot staging
```

## Cleanup

<!-- workflow.directOnly()

export RESULT=$(az webapp deployment slot list --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD --query [0].state)
if [[ "$RESULT" != Running ]]; then
  echo 'Deployment slot is NOT running'
  az group delete --name $RESOURCE_GROUP --yes || true
  exit 1
fi
  -->

Do NOT forget to remove the resources once you are done running the example.

1m