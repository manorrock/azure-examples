
# Create an Azure Key Vault

## Prerequisites

This example assumes you have previously created the Azure Resource Group, if you
have NOT done so please go to [Create an Azure Resource Group](../resourcegroup-create/README.md)

## Create the Azure Key Vault

To create the Azure Key Vault use the following Maven command line.

````shell
  mvn package
````

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                  |
|------------------------|------------------------------|
| example.keyvault       | the name of the keyvault     |
| example.resourceGroup  | the Resource Group to use    |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
