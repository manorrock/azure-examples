
# Delete an Azure Resource Group

## Prerequisites

This example assume you are logged into Azure CLI and have set your default
subscription, if you have NOT done so please go to our top-level
[README](../README.md)

## Delete the Resource Group

To delete the Resource Group use the following command line:

<!-- GitHub workflow - include ../create/README.md -->

````shell
 az group delete --name $RESOURCE_GROUP --yes
````

<!-- GitHub workflow - direct-only
export RESULT=$(az group show --name $RESOURCE_GROUP --output tsv --query name)
if [[ "$RESULT" == $RESOURCE_GROUP ]]; then
  exit 1
fi
  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

1. [Manage resource groups and template deployments](https://docs.microsoft.com/en-us/cli/azure/group)

1m
