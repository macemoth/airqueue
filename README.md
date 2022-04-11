# airqueue
```
              .------,
              =\      \
 .---.         =\      \
 | C~ \         =\      \
 |     `----------'------'----------,
.'     LI.-.LI LI LI LI LI LI LI.-.LI`-.
\ _/.____|_|______.------,______|_|_____)
                 /      /
               =/      /
              =/      /
             =/      /
      jgs    /_____,'
```

## Patterns and suggestions from exercises

### Exercise 2 (at least one)
- Event notification: add a notification service for the flowing retail example which sends emails to inform customers about relevant progress in the process.
- Event-carried state transfer: extend the checkout service such that the checkout service is aware of the available stock. This requires to keep a copy of the data at the checkout and to keep this data updated (e.g., using one of the eventually consistency pattern like event-based synchronization).

### Exercise 3

No explicit indication.  Suggestion to use Camunda BPM.

### Exercise 4

Look at for a pure choreography approach. Suggestion do balance commands and events. No explicit indication of patterns.

### Exercise 5

Stateful resilience patterns ([Netflix Hystrix](https://github.com/Netflix/Hystrix)), suggestion to use one or several of:
- Stateful retry
- Human intervention
- Outbox and Saga patterns

No transactions required, eventual consistency and events are ok.