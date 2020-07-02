
# Create a custom WildFly and deploy it to Azure App Service (using a Docker image)

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Container Registry](../../acr/create/)
1. [Create a custom WildFly Docker image and push it to Azure Container Registry](../../acr/wildfly/)
1. [Create settings.xml for your Azure Container Registry (using admin access keys)](../acr/create-access-keys-settings-xml/)
1. [Create an Azure App Service Plan](../appservice/plan/create/)

## Deploy the example

To deploy the example use the following command lines:

```shell
  export APPSERVICE_DOCKER_WILDFLY_NAME=appservice-docker-wildfly-$RANDOM

  mvn azure-webapp:deploy \
    --settings=$SETTINGS_XML \
    -DappName=$APPSERVICE_DOCKER_WILDFLY_NAME \
    -DimageName=acr-wildfly:latest \
    -DappServicePlan=$APP_SERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP \
    -DserverId=$ACR
```

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
