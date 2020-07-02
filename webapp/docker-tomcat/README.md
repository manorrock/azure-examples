
# Tomcat on Azure App Service (using a Docker image)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../../appservice/plan/create/)

## Deploy the example

To deploy the example use the following Maven command line.

````shell
  export DOCKER_TOMCAT_WEBAPP=docker-tomcat-$RANDOM

  mvn azure-webapp:deploy \
    -DappName=$DOCKER_TOMCAT_WEBAPP \
    -DappServicePlan=$APP_SERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
````

### Properties supported by the example

The example supports the following properties that you can pass in as
-Dname=value to the Maven command line to customize your deployment.

| name                   | description                  |
|------------------------|------------------------------|
| appName                | the application name         |
| appServicePlan         | the App Service plan to use  |
| imageName              | the Docker image name        |
| resourceGroup          | the Azure Resource Group     |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
