
# Create a Spring Boot application and deploy it to Azure App Service (using JavaSE)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../../appserviceplan-create/README.md)

## Build the example

To build the JAR file use the following Maven command line.

````shell
  mvn package
````

## Run example locally

To run the example locally use the following Maven command line.

````shell
  mvn spring-boot:run
````

You can see the application in action at http://localhost:8080/

## Deploy the example

To deploy the example use the following Maven command line:

````shell
  export JAVASE_SPRINGBOOT_WEBAPP=javase-springboot-$RANDOM

  mvn azure-webapp:deploy \
    -DappName=$JAVASE_SPRINGBOOT_WEBAPP \
    -DappServicePlan=$APP_SERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
````

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
| resourceGroup          | the Resource Group to use    |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
