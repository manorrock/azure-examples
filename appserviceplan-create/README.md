
# Create an Azure App Service Plan

## Prerequisites

This example assume you have created the resource group, if you have NOT done so,
please go to [Create an Azure Resource Group](../resourcegroup-create/README.md)

## Create the Azure App Service Plan

To create the Azure App Service Plan use the following Maven command line.

````shell
  mvn package
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                         |
|------------------------|-------------------------------------|
| example.appServicePlan | the App Service Plan name to create |
| example.region         | the region to create in             |
| example.resourceGroup  | the Resource Group to use           |

## Cleanup

Do NOT forget to remove the App Service Plan Group once you are done running the example.
