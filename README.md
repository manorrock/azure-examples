
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

## The examples

1. [Deploy a web application on Azure App Service (managed Tomcat)](appservice-tomcat-helloworld/README.md)

## Coming soon!

1. Create a Resource Group
1. Create an App Service plan
1. Delete a Resource Group
1. Deploy Tomcat 9 on a Azure App Service (Docker)
1. Deploy Jetty 9 on a Azure App Service (Docker)
1. Deploy Payara 5 on a Azure App Service (Docker)
1. Deploy Glassfish 5 on a Azure App Service (Docker)
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
1. Delete a App Service plan
1. Delete an App Service
1. Scale your App Service plan manually
1. Deploy an Java Azure Function
