
# Deploy to a deployment slot

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../../appservice/create-plan/)
1. [Deploy a Web application on Azure App Service (managed Tomcat)](../tomcat-helloworld/)
1. [Create a deployment slot](../create-deployment-slot/)

## Build the example

````shell
  mvn clean install
````

## Deploy to a deployment slot

````shell
  mvn azure-webapp:deploy \
    -DappName=$TOMCAT_HELLOWORLD_WEBAPP \
    -DappServicePlan=$APP_SERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP \
    -DdeploymentSlotName=staging
````

Once the command completes you will be able to see the example by using your 
web browser and going to the ```xxxxx.azurewebsites.net``` address the command
echoes.

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
