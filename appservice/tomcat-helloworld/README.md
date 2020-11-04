
# Deploy a Web application on Azure App Service (managed Tomcat)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../create-plan/)

<!-- workflow.include(../create-plan/README.md) -->

## Build the example

<!-- workflow.run() 

cd appservice/tomcat-helloworld

  -->

````shell
  mvn clean install
````

## Deploy the example

To deploy the example use the following Maven command line.

````shell
  export TOMCAT_HELLOWORLD_WEBAPP=helloworld-$RANDOM

  mvn azure-webapp:deploy \
    -DappName=$TOMCAT_HELLOWORLD_WEBAPP \
    -DappServicePlan=$APP_SERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
````

<!-- workflow.run()

cd ../..

  -->

<!-- workflow.directOnly() 

export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $TOMCAT_HELLOWORLD_WEBAPP --output tsv --query state)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Running ]]; then
  exit 1
fi

  -->

Once the command completes you will be able to see the example by using your 
web browser and going to the ```xxxxx.azurewebsites.net``` address the command
echoes.

### Properties supported by the example

The example supports the following properties that you can pass in as
-Dname=value to the Maven command line to customize your deployment.

| name                   | description                  |
|------------------------|------------------------------|
| appName                | the Application Name         |
| appServicePlan         | the App Service plan to use  |
| javaVersion            | the Java version to use      |
| region                 | the Region to use            |
| resourceGroup          | the Resource Group to use    |
| webContainer           | the Web Container to use     |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
