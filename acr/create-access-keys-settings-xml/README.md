
# Create settings.xml for your Azure Container Registry (using admin access keys)

```text
Note for production environments we recommend you setup
a service principal instead of using admin access keys
```

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Container Registry](../create/)

## Create the settings.xml

Copy the settings.xml template

```shell
  cp settings.template settings.xml
```

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

Fill in the settings.xml file

````shell
  sed -i '' "s/REGISTRY/$ACR/" settings.xml
  sed -i '' "s/USERNAME/$ACR_USERNAME/" settings.xml
  sed -i '' "s/PASSWORD/$ACR_PASSWORD/" settings.xml
````

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
