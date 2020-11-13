# GitHub Workflow Generator

## Cron

To set the cron schedule for a given workflow use

<!-- workflow.skip() -->
```
\<!-- workflow.cron(* * * * *) -->
```

## (Always) Run

To always run a specific set of comments one can use the following:

<!-- workflow.skip() -->
```
\<!-- workflow.run()

script commands

\  -->
```