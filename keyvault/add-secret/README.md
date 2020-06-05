
# Adding a Secret to Azure Key Vault

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../resourcegroup-create/README.md)
1. [Create an Azure Key Vault](../create/)

## Add a Secret to Azure Key Vault

To add a Secret to the Azure Key Vault use the command line below:

```shell
  az keyvault secret set \
    --name mySecret
    --value mySecretValue
    --vault-name $KEYVAULT_NAME
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
