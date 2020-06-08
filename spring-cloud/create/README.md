
# Create an Azure Spring Cloud

## Prerequisites

This example assume you have created the resource group, if you have NOT done so,
please go to [Create an Azure Resource Group](../../group/create/)

## Create the Azure Spring Cloud

To create the Azure Spring Cloud use the following Maven command line.

````shell
  mvn package
````

### Properties supported by the example

The example supports the following properties that you can pass in as 
-Dname=value to the Maven command line to customize your deployment.

| name                   | description                            |
|------------------------|----------------------------------------|
| example.resourceGroup  | the Resource Group to use              |
| example.springCloudName| the name of the Spring Cloud to create |

## Cleanup

Do NOT forget to remove the Azure Spring Cloud once you are done running the example.
