
# Deploy a Spring Boot Application using managed JavaSE

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../../appservice/create-plan/)

<!-- workflow.include(0 4 * * 1) -->
<!-- workflow.include(../create-plan/README.md) -->

## Build the example

To build the JAR file use the following Maven command line.

<!-- workflow.run() 

cd appservice/javase-springboot

  -->


````shell
  mvn package
````

## Run example locally

To run the example locally use the following Maven command line.

<!-- workflow.skip() -->
````shell
  mvn spring-boot:run
````

You can see the application in action at http://localhost:8080/

## Deploy the Spring Boot Application

To deploy the example use the following Maven command line:

````shell
  export JAVASE_SPRINGBOOT_WEBAPP=appservice-javase-springboot-$RANDOM

  mvn azure-webapp:deploy \
    -DappName=$JAVASE_SPRINGBOOT_WEBAPP \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
````

<!-- workflow.run()

cd ../..

  -->

Once the command completes you will be able to see the example by using your 
web browser and going to the ```xxxxx.azurewebsites.net``` address the command
echoes.

<!-- workflow.directOnly() 

export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $JAVASE_SPRINGBOOT_WEBAPP --output tsv --query state)
if [[ "$RESULT" != Running ]]; then
  echo 'Web application is NOT running'
  az group delete --name $RESOURCE_GROUP --yes || true
  exit 1
fi

export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $JAVASE_SPRINGBOOT_WEBAPP --output tsv --query defaultHostName)
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"Hello World"* ]]; then
  echo "Response did not contain 'Hello World'"
  exit 1
fi

  -->

### Properties supported by the example

The example supports the following properties that you can pass in as
-Dname=value to the Maven command line to customize your deployment.

| name                   | description                  |
|------------------------|------------------------------|
| appName                | the Application Name         |
| appServicePlan         | the App Service plan to use  |
| resourceGroup          | the Resource Group to use    |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
