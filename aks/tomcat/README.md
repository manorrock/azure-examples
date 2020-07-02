
# Deploy a Tomcat web application to AKS

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Container Registry](../../acr/create/)
1. [Create settings.xml for your Azure Container Registry (using admin access keys)](../../acr/create-access-keys-settings-xml/)
1. [Deploy an AKS cluster (Azure Kubernetes Service)](../create/)
1. [Update your AKS cluster to use your Azure Container Registry](../use-your-acr/)

## Build the example

To build the WAR file use the following Maven command line.

````shell
  mvn package
````

## Push the Docker image to your Azure Container Registry

````shell
 az acr build --registry $ACR --image example-tomcat:latest .
````

## Deploying to the AKS cluster

First open the `deployment.yml` file in an editor and replace `ACR` with the
name of your Azure Container Registry OR execute the command line below:

```shell
  sed -i "" "s/ACR/$ACR/g" deployment.yml
```

Then execute the command below to deploy to the AKS cluster:

```shell
kubectl apply -f deployment.yml
```

> Note in a production environment you should use an Ingress controller instead
> of directly exposing the IP address

To get the public IP address use the following command.

```
kubectl get service/tomcat
```

If the `EXTERNAL-IP` column has no IP address yet keep repeating the command as
it might take a while before AKS has assigned a public IP.

Once the `EXTERNAL-IP` shows up open your browser to `http://EXTERNAL-IP`.

It should tell you:

```shell
And this is served by Tomcat deployed on Azure Kubernetes Service using
a Docker image coming from our own Azure Container Registry
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.