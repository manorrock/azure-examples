
# Create an Azure Resource Group

## Prerequisites

This example assume you are logged into Azure CLI and have set your default
subscription, if you have NOT done so please go to our top-level
[README](../README.md)

## Create the Resource Group

To create the Resource Group use the following Maven command line.

````shell
  mvn package
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                  |
|------------------------|------------------------------|
| example.resourceGroup  | the Resource Group to use    |
| example.region         | the Region to use            |

## Cleanup

Do NOT forget to remove the Resource Group once you are done running the example.
