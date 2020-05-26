
# Delete an Azure App Service

## Prerequisites

This example assume you have created an Azure App Service before. If you
have not done so please go to [Deploy a Web application on Azure App Service 
(managed Tomcat)](../appservice-tomcat-helloworld/README.md)

## Delete the Azure App Service

To delete the Azure App Service use the following Maven command line.

````shell
  mvn package -Dexample.name=YOU_HAVE_TO_FILL_THIS_IN
````

Note if you do not know what the value of `example.name` should be, you can
determine which App Services you have by following the guidance in
[List your Azure App Services](../appservice-list/README.md)

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                     | description                  |
|--------------------------|------------------------------|
| example.resourceGroup    | the Azure Resource Group     |
| example.name             | the name of the App Service  |

## Cleanup

Do NOT forget to remove the resources you have created once you are done running
the example.
