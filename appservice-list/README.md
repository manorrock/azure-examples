
# List your Azure App Services

## Prerequisites

This example assume you have created an Azure App Service before. If you
have not done so please go to [Deploy a Web application on Azure App Service 
(managed Tomcat)](../appservice-tomcat-helloworld/README.md)

## List your Azure App Services

To list the Azure App Services use the following Maven command line.

````shell
  mvn package
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                  |
|------------------------|------------------------------|
| example.resourceGroup  | the Azure Resource Group     |

## Cleanup

Do NOT forget to remove the resources you might have created once you are done running the example.
