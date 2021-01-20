
# Create an Event Hub

![eventhubs/create/README.md](https://github.com/manorrock/azure-examples/workflows/eventhubs/create/README.md/badge.svg)

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Event Hubs namespace](../create-namespace/)

## Create an Event Hub

<!-- workflow.cron(0 2 * * 5) -->
<!-- workflow.include(../create-namespace/README.md) -->

First, create the environment variable used for our event hub
using the command line below:

```shell
  export EVENT_HUB=event-hub-$RANDOM
```

Then, create the event hub using the following command line:

```shell
  az eventhubs eventhub create \
    --resource-group $RESOURCE_GROUP \
    --name $EVENT_HUB \
    --namespace-name $EVENT_HUB_NAMESPACE \
    --message-retention 1
```

<!-- workflow.directOnly() 

export RESULT=$(az eventhubs eventhub show --resource-group $RESOURCE_GROUP --namespace-name $EVENT_HUB_NAMESPACE --name $EVENT_HUB --query status --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Active ]]; then
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
