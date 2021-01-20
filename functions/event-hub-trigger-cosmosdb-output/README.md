
# Deploy a Cosmos DB output Function

## Prerequisites

This example assumes you have previously completed the following.

1. [Create an Azure Resource Group](../../group/create/)
1. [Install Azure Functions Core Tools](../install-tools/)
1. [Create an Azure Cosmos DB](../../cosmosdb/create/)
1. [Create an Namespace](../../eventhubs/create-namespace/)
1. [Create an Event Hub](../../eventhubs/create/)
1. [Create an Authorization Rule](../../eventhubs/create-authorization-rule/)
1. [Create an Azure Storage Account](../../storage/account/create/)

<!-- workflow.cron(0 4 * * 2) -->
<!-- workflow.include(../install-tools/README.md) -->
<!-- workflow.include(../../cosmosdb/create/README.md) -->
<!-- workflow.include(../../eventhubs/create-authorization-rule/README.md) -->
<!-- workflow.include(../../storage/account/create/README.md) -->

<!-- workflow.run() 

  cd functions/event-hub-trigger-cosmosdb-output

  -->

## Set up the Java function app name environment variable

```shell
  export FUNCTIONS_EVENTHUB_COSMOSDB=functions-eventhub-cosmosdb-$RANDOM
```

## Set the Event Hub connection string environment variable

```shell
  export FUNCTIONS_EVENTHUB_COSMOSDB_EVENT_HUB_CONNECTION_STRING="$(az \
        eventhubs eventhub authorization-rule keys list \
        --resource-group $RESOURCE_GROUP \
        --name $EVENT_HUB_AUTHORIZATION_RULE \
        --eventhub-name $EVENT_HUB \
        --namespace-name $EVENT_HUB_NAMESPACE \
        --query primaryConnectionString \
        --output tsv)"
```

## Set the Cosmos DB connection string environment variable

```shell
  export FUNCTIONS_EVENTHUB_COSMOSDB_COSMOSDB_CONNECTION_STRING="$(az \
        cosmosdb keys list \
        --resource-group $RESOURCE_GROUP \
        --name $COSMOSDB_NAME \
        --type connection-strings \
        --query connectionStrings[0].connectionString \
        --output tsv)"
```

## Set the Storage Account connection string environment variable

```shell
  export STORAGE_ACCOUNT_CONNECTION_STRING=$( \
    az storage account show-connection-string \
    --name $STORAGE_ACCOUNT_NAME \
    --query connectionString \
    --output tsv)
```

## Setup the local environment

```shell
  mvn -P local validate
```

## Build the example

To build the JAR file use the following Maven command line.

```shell
  mvn -DresourceGroup=$RESOURCE_GROUP -DappName=$FUNCTIONS_EVENTHUB_COSMOSDB package
```

## Run the example locally

To run the example locally use the following Maven command line.

<!-- workflow.skip() -->
```shell
  mvn -DappName=$FUNCTIONS_EVENTHUB_COSMOSDB -DresourceGroup=$RESOURCE_GROUP \
    clean package azure-functions:run
```

You can verify the function works by using your browser and going to 
http://localhost:7071/api/send

## Deploy the example to Azure

```shell
  mvn -DappName=$FUNCTIONS_EVENTHUB_COSMOSDB -DresourceGroup=$RESOURCE_GROUP \
    -DcosmosDBConnectionString="$FUNCTIONS_EVENTHUB_COSMOSDB_COSMOSDB_CONNECTION_STRING" \
    -DeventHubConnectionString="$FUNCTIONS_EVENTHUB_COSMOSDB_EVENT_HUB_CONNECTION_STRING" \
    -DstorageConnectionString="$STORAGE_ACCOUNT_CONNECTION_STRING" \
    clean package azure-functions:deploy
```

To verify the function works open your browser to the URL echoed by the 
following command line:

<!-- workflow.skip() -->
```shell
  echo `az functionapp show \
    --resource-group $RESOURCE_GROUP \
    --name $FUNCTIONS_EVENTHUB_COSMOSDB \
    --query hostNames \
    --output tsv`/api/send
```

<!-- workflow.run() 

  cd ../..

  -->

<!-- workflow.directOnly() 

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

* [Azure Functions documentation](https://docs.microsoft.com/en-us/azure/azure-functions/)
* [Manage function apps](https://docs.microsoft.com/cli/azure/functionapp)

5m
