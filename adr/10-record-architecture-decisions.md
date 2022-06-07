# 10. Zeebe (not implemented) 

Date: 2022-06-07

## Status

Accepted

## Context

For our application we use Kafka in conjunction with Zookeeper and Camunda. In that configuration there is somewhat of a redundancy of data, as it is represented in the events as well as persisted in the orchestrator. Zeebe would unify this by only using the event log (with RocksDB). 

## Decision

We decided to not involve Zeebe in our project, as it would be more intertwined with our code, and for our scope we want to stick to the “brick and mortar” code. 

## Consequences

Zeebe is reported to be orders of magnitude faster than ”pure” Camunda. However, we do not need this speed at the moment.

Without Zeebe, for debugging purposes, we can still inspect the relational database relatively easily. 
