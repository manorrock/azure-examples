
# Delete an Azure Resource Group

## Prerequisites

This example assumes you are logged into Azure CLI and have set your default
subscription, if you have NOT done so please go to our top-level
[README](../..)

## Delete the Resource Group

To delete the Resource Group use the following command line:

<!-- workflow.cron(0 2 * * 0) -->
<!-- workflow.pushPath(true) -->
<!-- workflow.include(../create/README.md) -->

```shell
 az group delete --name $RESOURCE_GROUP --yes
```

<!-- workflow.directOnly()
export RESULT=$(az group show --name $RESOURCE_GROUP --output tsv --query name)
if [[ "$RESULT" == $RESOURCE_GROUP ]]; then
  exit 1
fi
  -->

## Next steps

1. [Manage resource groups and template deployments](https://docs.microsoft.com/en-us/cli/azure/group)

1m
