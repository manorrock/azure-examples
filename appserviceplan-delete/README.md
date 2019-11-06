
# Delete an Azure App Service Plan

## Prerequisites

This example assume you have previously created the App Service Plan, if you have
NOT done so, please go to [Create an Azure Service Plan](../appserviceplan-create/README.md)

## Delete the Azure App Service Plan

To delete the Azure App Service Plan use the following Maven command line.

````shell
  mvn package
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                         |
|------------------------|-------------------------------------|
| example.resourceGroup  | the Resource Group to use           |
| example.appServicePlan | the App Service Plan name to delete |

## Cleanup

Do NOT forget to remove the Resource Group once you are done running the example.
