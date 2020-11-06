
# Deploy Tomcat using a Docker image

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Container Registry](../../acr/create/)
1. [Create a custom Tomcat Docker image and push it to Azure Container Registry](../../acr/tomcat/)
1. [Create settings.xml for your Azure Container Registry (using admin access keys)](../../acr/create-access-keys-settings-xml/)
1. [Create an Azure App Service Plan](../create-plan/)

## Deploy Tomcat using a Docker image

<!-- workflow.include(../create-plan/README.md) -->

To deploy Tomcat use the following command lines:

```shell
  export APPSERVICE_DOCKER_TOMCAT=appservice-docker-tomcat-$RANDOM

  mvn azure-webapp:deploy \
    --settings=$SETTINGS_XML \
    -DappName=$APPSERVICE_DOCKER_TOMCAT \
    -DimageName=acr-tomcat:latest \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP \
    -DserverId=$ACR_NAME

  az webapp show \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_DOCKER_TOMCAT \
    --query hostNames[0] \
    --output tsv
```

Then open your browser to the URL shown as output and you should see:

<!-- workflow.skip() -->
```text
And this is served by a custom Tomcat using a Docker image coming from our 
own Azure Container Registry.
```

<!-- workflow.directOnly()

export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_TOMCAT --output tsv --query state)
if [[ "$RESULT" != Running ]]; then
  echo 'Web application is NOT running'
  az group delete --name $RESOURCE_GROUP --yes || true
  exit 1
fi

export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_TOMCAT --output tsv --query defaultHostName)
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"custom Tomcat"* ]]; then
  echo "Response did not contain 'custom Tomcat'"
  exit 1
fi

  -->

## Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                   | description                       |
|------------------------|-----------------------------------|
| appName                | the application name              |
| appServicePlan         | the App Service plan to use       |
| imageName              | the Docker image name             |
| serverId               | the Maven server id               |
| registry               | the Azure Container Registry name |
| registryUrl            | the Azure Container Registry url  |
| resourceGroup          | the Azure Resource Group name     |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

3m