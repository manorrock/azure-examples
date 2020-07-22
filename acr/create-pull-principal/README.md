
# Create an 'acrpull' Service Principal

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Container Registry](../create/)

## Create an 'acrpull' Service Principal

Execute the following command lines to create the 'acrpull' Service Principal:

```shell
  export ACR_PULL_SERVICE_PRINCIPAL_NAME=acr-pull-$RANDOM
  export ACR_ID=`az acr show --name $ACR_NAME --query id --output tsv`
  export ACR_PULL_SERVICE_PRINCIPAL_PASSWORD=`az ad sp create-for-rbac \
    --name http://$ACR_PULL_SERVICE_PRINCIPAL_NAME \
    --scopes $ACR_ID \
    --role acrpull \
    --query password \
    --output tsv`
  export ACR_PULL_SERVICE_PRINCIPAL_ID=`az ad sp show \
    --id http://$ACR_PULL_SERVICE_PRINCIPAL_NAME \
    --query appId \
    --output tsv`
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
