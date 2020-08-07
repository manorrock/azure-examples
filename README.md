
# Azure Java Examples

This GitHub repository contains a set of Azure examples specifically for Java 
users to quickly get started with Azure. Please use the issue tracker to leave
feedback or to propose other examples.

## Getting started

To work with these examples it is assumed you have the Azure CLI installed, and
you have logged in and set your default subscription. If you haven't done so
follow the steps below.

_Note logging in and setting your default subscription needs to be done once per
 terminal session._

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

## Hosting platforms

### Azure App Service examples

1. [Create an Azure App Service Plan](appservice/plan/create/)
1. [Delete an Azure App Service Plan](appservice/plan/delete/)
1. [Scale your Azure App Service Plan manually](appservice/plan/scale-manually/)
1. [List your Azure App Services](webapp/list/)
1. [Delete an Azure App Service](webapp/delete/)
1. [Deploy a web application on Azure App Service (managed Tomcat)](webapp/tomcat-helloworld/)
1. [Deploy Tomcat on Azure App Service (using a Docker image)](webapp/docker-tomcat/)
1. [Deploy Jetty on Azure App Service (using a Docker image)](webapp/docker-jetty/)
1. [Deploy Payara on Azure App Service (using a Docker image)](webapp/docker-payara/)
1. [Deploy Glassfish on Azure App Service (using a Docker image)](webapp/docker-glassfish/)
1. [Deploy a Spring Boot application on Azure App Service (using JavaSE)](webapp/javase-springboot/)
1. [Create a custom WildFly on deploy it on Azure App Service (using a Docker image)](webapp/docker-wildfly/)
1. [Deploy a Quarkus application on Azure App Service (using JavaSE)](webapp/javase-quarkus/)
1. [Deploy a GraalVM application on Azure App Service (using Docker)](webapp/docker-graalvm/)

### Azure Container Instances examples

1. [Deploy a custom Tomcat on Azure Container Instances](container/tomcat/)
1. [Deploy a custom WildFly on Azure Container Instances](container/wildfly/)

### Azure Functions examples

1. [Deploy a Java Azure Function](functionapp/java/)

### Azure Kubernetes Service examples

1. [Deploy an AKS cluster (Azure Kubernetes Service)](aks/create/)
1. [Create a Kube config file for an Azure Kubernetes Cluster (using admin access)](aks/create-kube-config/)
1. [Install Tiller on your Azure Kubernetes Service cluster (using Helm 2)](aks/install-tiller/)
1. [Deploy an NGINX Ingress Controller on your Azure Kubernetes Service cluster (using Helm 2)](aks/deploy-nginx-ingress-controller/)
1. [Update your AKS cluster to use your Azure Container Registry](aks/use-your-acr/)
1. [Deploy a Spring Boot application to AKS](aks/springboot/)
1. [Deploy a Tomcat web application to AKS](aks/tomcat/)
1. [Deploy a WildFly application to AKS](aks/wildfly/)

### Azure Red Hat OpenShift examples

1. [Deploy an Azure Red Hat OpenShift cluster](aro/create/)

### Azure Spring Cloud examples

1. [Create an Azure Spring Cloud](spring-cloud/create/)
1. [Deploy a Spring Boot application to Azure Spring Cloud](spring-cloud/helloworld/)
1. [Configure the Azure Spring Cloud Config Server](spring-cloud/config-server/)

## Databases

### Azure Database for MySQL examples

1. [Deploy an Azure Database for MySQL](mysql/create/)
1. [Open MySQL server firewall to your IP address](mysql/open-firewall-to-your-ip/)
1. [Load your MySQL database with data](mysql/load-your-mysql-database-with-data/)

### Azure Cosmos DB examples

1. [Create an Azure Cosmos DB](cosmosdb/create/)

## Supporting services / examples

### Azure Container Registry examples

1. [Deploy an Azure Container registry](acr/create/)
1. [Create Maven settings.xml for Azure Container Registry (using admin access keys)](acr/create-access-keys-settings-xml/)
1. [Create an 'acrpull' Service Principal](acr/create-acrpull-service-principal/)
1. [Create a custom Glassfish Docker image and push it to Azure Container Registry](acr/glassfish/)
1. [Create a GraalVM application packaged as a Docker image and push it to Azure Container Registry](acr/graalvm/)
1. [Create a custom Jetty Docker image and push it to Azure Container Registry](acr/jetty/)
1. [Create a custom Payara Docker image and push it to Azure Container Registry](acr/payara/)
1. [Create a Quarkus application packaged as a Docker image and push it to Azure Container Registry](acr/quarkus/)
1. [Create a custom Tomcat Docker image and push it to Azure Container Registry](acr/tomcat/)
1. [Create a custom WildFly Docker image and push it to Azure Container Registry](acr/wildfly/)

### Azure Key Vault examples

1. [Create an Azure Key Vault](keyvault/create/)
1. [Add a Secret to an Azure Key Vault](keyvault/add-secret/)

### Azure Resource Group examples

1. [Create an Azure Resource Group](group/create/)
1. [Delete an Azure Resource Group](group/delete/)

### Azure Storage examples

1. [Create an Azure Storage Account](storage/create/)
1. [Enabled static website hosting on Azure Storage](storage/blob/enable-static-website-hosting/)
1. [Upload files to static website](storage/blob/upload-files-to-static-website/)
