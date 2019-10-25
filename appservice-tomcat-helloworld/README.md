
# Web application on Azure App Service (managed Tomcat)

## Prerequisites

This example assume you are logged into Azure CLI and have set your default subscription, if you have NOT done so please go to our top-level [README](../README.md)

If also assumes you have created the appropriate Resource Group and App Service Plan.

## Build the example

````shell
  mvn clean install
````

## Deploy the example

To deploy the example use the following Maven command line.

````shell
  mvn azure-webapp:deploy
````

Once the command completes you will be able to see the example by using your web browser and going to the ```xxxxx.azurewebsites.net``` address the command echoes.

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                  |
|------------------------|------------------------------|
| example.appName        | the application name         |
| example.appServicePlan | the App Service plan to use  |
| example.javaVersion    | the Java version to use      |
| example.resourceGroup  | the Resource Group to use    |
| example.webContainer   | the web container to use     |

## Cleanup

Do NOT forget to remove the App Service and its associated resources once you are done running the example.
