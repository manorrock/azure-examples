
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

## The list of examples

1. [Create an Azure Resource Group](resourcegroup-create/README.md)
1. [Delete an Azure Resource Group](resourcegroup-delete/README.md)
1. [Create an Azure App Service Plan](appserviceplan-create/README.md)
1. [Delete an Azure App Service Plan](appserviceplan-delete/README.md)
1. [Deploy a web application on Azure App Service (managed Tomcat)](appservice-tomcat-helloworld/README.md)
1. [Deploy Tomcat on Azure App Service (using a Docker image)](appservice-docker-tomcat/README.md)
1. [Deploy Jetty on Azure App Service (using a Docker image)](appservice-docker-jetty/README.md)
1. [Deploy Payara on a Azure App Service (using a Docker image)](appservice-docker-payara/README.md)
1. [Deploy Glassfish on a Azure App Service (using a Docker image)](appservice-docker-glassfish/README.md)
1. [Create an Azure Key Vault](keyvault-create/README.md)

## Maven properties supported by all examples

All the examples support the following properties that you can pass in as -Dname=value to the Maven command line to customize your experience.

| name                   | description                                             |
|------------------------|---------------------------------------------------------|
| example.prefix         | a prefix used in resource names                         |
| example.postfix        | a timestamped postfix to generate unique resource names |

## Coming soon!

1. Deploy an Azure Docker registry.
1. Create a custom dockerized Tomcat and deploy it to Azure App Service (Docker)
1. Deploy a Spring Boot to Azure App Service (JavaSE)
1. Deploy an AKS cluster (Azure Kubernetes Service)
1. Deploy a Spring Boot application to AKS
1. Deploy a Tomcat web application to AKS
1. Deploy OpenLiberty 5 on a Azure App Service (Docker)
1. Deploy Azure Spring Cloud
1. Deploy a Spring Boot appliction to Azure Spring Cloud
1. Serve static content using Azure Blog Storage
1. Delete an App Service
1. Scale your App Service plan manually
1. Deploy an Java Azure Function
1. Deploy WildFly on Azure App Service (using a Docker image)
1. Deploy a Quarkus application on Azure App Service (JavaSE)
1. Deploy a Quarkus GraalVM application on Azure App Service (Docker)
