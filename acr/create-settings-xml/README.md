
# Create settings.xml using admin access keys

```text
Note for production environments we recommend you setup
a service principal instead of using admin access keys
```

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Container Registry](../create/)

<!-- workflow.cron(0 2 * * 2) -->
<!-- workflow.include(../create/README.md) -->

## Create the settings.xml

Get the ACR username

```shell
  export ACR_USERNAME=`az acr credential show --name $ACR \
    --resource-group $RESOURCE_GROUP --query username --output tsv`
```

Get the ACR password

```shell
  export ACR_PASSWORD=`az acr credential show --name $ACR \
    --resource-group $RESOURCE_GROUP --query passwords[0].value --output tsv`
```

Set the SETTINGS_XML variable

```shell
  export SETTINGS_XML=$PWD/settings.xml
```

<!-- workflow.directOnly()
az group delete --name $RESOURCE_GROUP --yes || true

if [[ -z $ACR_USERNAME ]]; then
  echo "ACR Admin username was not found"
  exit 1
fi

if [[ -z $ACR_PASSWORD" ]]; then
  echo "ACR Admin passsword was not found"
  exit 1
fi
  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
