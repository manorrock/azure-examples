
# Scale your App Service plan manually

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Create an App Service plan](../appserviceplan-create/README.md)
1. [Deploy a Web application on Azure App Service 
(managed Tomcat)](../appservice-tomcat-helloworld/README.md)

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                   | description                      |
|------------------------|----------------------------------|
| example.appServicePlan | the App Service plan to use      |
| example.resourceGroup  | the Azure Resource Group name    |
| example.workerCount    | the number of workers            |

## Cleanup

Do NOT forget to remove the App Service plan and its associated resources once you
are done running the example.
