# GitHub Workflow Generator

## Cron

To set the cron schedule for a given workflow use

<!-- workflow.skip() -->
```
<!-- workflow.cron(* * * * *) -->
```

## Direct only

To only run a snippet when it is in the original Markdown and not coming in 
through workflow.include use the following:

```
<!-- workflow.directOnly()

script commands

  -->
```

## (Always) Run

To always run a specific set of comments one can use the following:

<!-- workflow.skip() -->
```
<!-- workflow.run()

script commands

  -->
```

## Skip

To skip a snippet for inclusion use the following:

<!-- workflow.skip() -->
```
<!-- workflow.skip() -->
```
