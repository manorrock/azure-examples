
# Glassfish on Azure App Service (using a Docker image)

## Prerequisites

This example assume you have created the appropriate App Service Plan, if you
have not done so please [Create an Azure App Service Plan](../appserviceplan-create/README.md)

## Deploy the example

To deploy the example use the following Maven command line.

````shell
  mvn azure-webapp:deploy
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                  |
|------------------------|------------------------------|
| example.appName        | the application name         |
| example.appServicePlan | the App Service plan to use  |
| example.imageName      | the Docker image name        |
| example.resourceGroup  | the Azure Resource Group     |

## Cleanup

Do NOT forget to remove the App Service and its associated resources once you are done running the example.
