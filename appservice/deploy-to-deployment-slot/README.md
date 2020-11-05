
# Deploy to a deployment slot

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../create-plan/)
1. [Deploy a Web application on a managed Tomcat](../tomcat-helloworld/)
1. [Create a deployment slot](../create-deployment-slot/)

## Build the example

<!-- workflow.include(../create-deployment-slot/README.md) -->

````shell
  mvn clean install
````

## Deploy to a deployment slot

````shell
  mvn azure-webapp:deploy \
    -DappName=$APPSERVICE_TOMCAT_HELLOWORLD \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP \
    -DdeploymentSlotName=staging
````

<!-- workflow.directOnly() 

export RESULT=$(az webapp deployment slot list --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD --output tsv --query [0].state)
if [[ "$RESULT" != Running ]]; then
  echo 'Deployment slot is NOT running'
  az group delete --name $RESOURCE_GROUP --yes || true
  exit 1
fi

export URL=https://$(az webapp deployment slot list --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD --output tsv --query [0].defaultHostName)
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"Hello World"* ]]; then
  echo "Response did not contain 'Hello World'"
  exit 1
fi

  -->

Once the command completes you will be able to see the example by using your 
web browser and going to the ```xxxxx.azurewebsites.net``` address the command
echoes.

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
