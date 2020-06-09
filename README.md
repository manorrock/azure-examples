
# Azure Maven Examples

This GitHub repository contains a set of Azure examples specifically for Maven users to quickly get started with Azure. Please use the issue tracker to leave feedback or to propose other examples.

## Getting started

To work with these examples it is assumed you have the Azure CLI installed, and you have logged in and set your default subscription. If you haven't done so follow the steps below.

_Note logging in and setting your default subscription needs to be done once per terminal session._

### Install Azure CLI

To setup the Azure CLI, please visit [Install the Azure CLI](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli). And once you are done come back to this README.

### Login into Azure

````shell
  az login
````

### Set your default subscription

Get a list of your subscriptions

````shell
  az account list --output table
````

Set your default subscription for this session using the subscription id from the previous output

````shell
  az account set --subscription "subscription-id"
````

### Install the master POM

To make sure each example knows about the parent POM you have to invoke the following command from the top level once per session.

````shell
  mvn -N install
````

## Azure App Service examples

1. [List your Azure App Services](appservice-list/README.md)
1. [Delete an Azure App Service](appservice-delete/README.md)
1. [Deploy a web application on Azure App Service (managed Tomcat)](appservice-tomcat-helloworld/README.md)
1. [Deploy Tomcat on Azure App Service (using a Docker image)](appservice-docker-tomcat/README.md)
1. [Deploy Jetty on Azure App Service (using a Docker image)](appservice-docker-jetty/README.md)
1. [Deploy Payara on Azure App Service (using a Docker image)](appservice-docker-payara/README.md)
1. [Deploy Glassfish on Azure App Service (using a Docker image)](appservice-docker-glassfish/README.md)
1. [Create a custom Tomcat and deploy it on Azure App Service (using a Docker image)](appservice-docker-custom/README.md)
1. [Deploy a Spring Boot application on Azure App Service (using JavaSE)](appservice-javase-springboot/README.md)
1. [Create a custom WildFly on deploy it on Azure App Service (using a Docker image)](appservice-docker-wildfly/README.md)
1. [Deploy a Quarkus application on Azure App Service (using JavaSE)](appservice-javase-quarkus/README.md)
1. [Deploy a GraalVM application on Azure App Service (using Docker)](appservice-docker-graalvm/README.md)

## Azure App Service plan examples

1. [Create an Azure App Service Plan](appserviceplan-create/README.md)
1. [Delete an Azure App Service Plan](appserviceplan-delete/README.md)
1. [Scale your Azure App Service Plan manually](appserviceplan-scale-manually/README.md)

## Azure Container Registry examples

1. [Deploy an Azure Container registry](acr/create/)
1. [Create Maven settings.xml for Azure Container Registry (using admin access keys)](acr/create-access-keys-settings-xml/)

## Azure Cosmos DB examples

1. [Create an Azure Cosmos DB](cosmosdb-create/README.md)

## Azure Functions examples

1. [Deploy a Java Azure Function](function-java/README.md)

## Azure Key Vault examples

1. [Create an Azure Key Vault](keyvault/create/)
1. [Add a Secret to an Azure Key Vault](keyvault/add-secret/)

## Azure Kubernetes Service examples

1. [Deploy an AKS cluster (Azure Kubernetes Service)](aks/create/)
1. [Create a Kube config file for an Azure Kubernetes Cluster (using admin access)](aks/create-kube-config/)
1. [Install Tiller on your Azure Kubernetes Service cluster (using Helm 2)](aks/install-tiller/)
1. [Deploy an NGINX Ingress Controller on your Azure Kubernetes Service cluster (using Helm 2)](aks/deploy-nginx-ingress-controller/)
1. [Update your AKS cluster to use your Azure Container Registry](aks/use-your-acr/)
1. [Deploy a Spring Boot application to AKS](aks/springboot/)
1. [Deploy a Tomcat web application to AKS](aks/tomcat/)
1. [Deploy a WildFly application to AKS](aks/wildfly/)

## Azure Resource Group examples

1. [Create an Azure Resource Group](group/create/)
1. [Delete an Azure Resource Group](resourcegroup-delete/README.md)

## Azure Spring Cloud examples

1. [Create an Azure Spring Cloud](spring-cloud/create/)
1. [Deploy a Spring Boot application to Azure Spring Cloud](spring-cloud/helloworld/)
1. [Configure the Azure Spring Cloud Config Server](spring-cloud/config-server/)

## Azure Storage Account examples

1. [Create an Azure Storage Account](storageaccount-create/README.md)

## Maven properties supported by most examples

Most of the examples support the following properties that you can pass in as -Dname=value to the Maven command line to customize your experience.

| name                   | description                                             |
|------------------------|---------------------------------------------------------|
| example.prefix         | a prefix used in resource names                         |
| example.postfix        | a timestamped postfix to generate unique resource names |
