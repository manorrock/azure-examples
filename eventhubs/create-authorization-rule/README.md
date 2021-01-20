
# Create an Authorization Rule

![eventhubs/create-authorization-rule/README.md](https://github.com/manorrock/azure-examples/workflows/eventhubs/create-authorization-rule/README.md/badge.svg)

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Event Hubs namespace](../create-namespace/)
1. [Create an Event Hub](../create/)

## Create an Authorization Rule

<!-- workflow.cron(0 3 * * 5) -->
<!-- workflow.include(../../create/README.md) -->

First, create the environment variable used for our authorization rule
using the command line below:

```shell
  export EVENT_HUB_AUTHORIZATION_RULE=event-hub-auth-rule-$RANDOM
```

Then, create the authorization rule using the following command line:

```shell
  az eventhubs eventhub authorization-rule create \
    --resource-group $RESOURCE_GROUP \
    --name $EVENT_HUB_AUTHORIZATION_RULE \
    --eventhub-name $EVENT_HUB \
    --namespace-name $EVENT_HUB_NAMESPACE \
    --rights Listen Send
```

<!-- workflow.directOnly() 

export RESULT=$(az eventhubs eventhub authorization-rule show --resource-group $RESOURCE_GROUP --namespace-name $EVENT_HUB_NAMESPACE --eventhub-name $EVENT_HUB --name $EVENT_HUB_AUTHORIZATION_RULE --query name --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != "$EVENT_HUB_AUTHORIZATION_RULE" ]]; then
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
