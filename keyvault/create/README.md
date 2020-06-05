
# Create an Azure Key Vault

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../resourcegroup-create/README.md)

## Create the Azure Key Vault

To create the Azure Key Vault use the following command lines:

```shell
  KEYVAULT_NAME="keyvault-$RANDOM"

  az keyvault create \
    --resource-group $RESOURCE_GROUP_NAME \
    --name $KEYVAULT_NAME
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
