
# Create an Azure Storage Account

## Prerequisites

This example assumes you have previously created the Azure Resource Group, if you
have NOT done so please go to [Create an Azure Resource Group](../resourcegroup-create/README.md)

## Create the Azure Storage Account

To create the Azure Storage Account use the following Maven command line.

````shell
  mvn package
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                     |
|------------------------|---------------------------------|
| example.resourceGroup  | the Resource Group to use       |
| example.sku            | the SKU of the storage account  |
| example.storageAccount | the name of the storage account |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
