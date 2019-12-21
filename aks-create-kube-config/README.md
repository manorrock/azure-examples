
# Create Kube config file for your Azure Kubernetes Service (using admin access)

```text
Note for production environments we recommend you configure RBAC to limit access to your Kubernetes cluster based on roles.
```

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../resourcegroup-create/README.md)
1. [Deploy an Azure Kubernetes Cluster](../aks-create/README.md)

## Create the Kube config file

To create the Kube config file use the following Maven command line.

````shell
  mvn package -Dexample.clusterName=CLUSTERNAME
````

Where ```CLUSTERNAME``` is the name of your Azure Kubernetes Service cluster.

Note once the command completes the Kube config file is stored at ```target/config```

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value to the Maven command line to customize your deployment.

| name                   | description                                      |
|------------------------|--------------------------------------------------|
| example.clusterName    | the name of the Azure Kubernetes Service cluster |
| example.resourceGroup  | the Azure Resource Group                         |

## Cleanup

Do NOT forget to remove the resources you might have created once you are done running the example.
