
# Deploy a WildFly web application to AKS

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Deploy an Azure Container Registry](../acr-create/README.md)
1. [Create settings.xml for your Azure Container Registry (using admin access keys)](../acr-create-access-keys-settings-xml/README.md)
1. [Deploy an AKS cluster (Azure Kubernetes Service)](../aks-create/README.md)
1. [Update your AKS cluster to use your Azure Container Registry](../aks-use-your-acr/README.md)

## Build the example

To build the WAR file use the following Maven command line.

````shell
  mvn package
````

## Push the Docker image to your Azure Container Registry

````shell
  mvn antrun:run@push -Dexample.registry=REGISTRY
````

Where ```REGISTRY``` is the name of your Azure Container Registry.

## Deploying to the AKS cluster

First open `src/main/aks/deployment.yaml` in your favorite editor and replace
`REGISTRY` with the name of your registry. Then execute the command below to
deploy to the AKS cluster.

```shell
kubectl apply -f src/main/aks/deployment.yaml
```

> Note in a production environment you should use an Ingress controller instead
> of directly exposing the IP address

To get the public IP address use the following command.

```
kubectl get service/wildfly
```

If the `EXTERNAL-IP` column has no IP address yet keep repeating the command as it
might take a while before AKS has assigned a public IP.

Once the `EXTERNAL-IP` shows up go to `http://EXTERNAL-IP:8080`.

It should tell you:

```shell
And this is served by WildFly deployed on Azure Kubernetes Service using
a Docker image coming from our own Azure Container Registry
```

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                   | description                      |
|------------------------|----------------------------------|
| example.appName        | the application name             |
| example.imageName      | the Docker image name            |
| example.resourceGroup  | the resource group               |
| example.registryUrl    | the registry URL                 |
| example.registry       | the name of your Docker registry |
| example.serverId       | the Maven server id              |
| example.appServicePlan | the App Service plan to use      |
| example.resourceGroup  | the Azure Resource Group name    |

## Cleanup

Do NOT forget to remove the resources you created once you are done running the
example.
