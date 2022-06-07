# 6. Persistence in Choreography

Date: 2022-06-07

## Status

Accepted

## Context

Our booking system needs to persist the data since the reliability of the data is very important for real-life platforms.  

## Decision

We’ve decided to centralise the persistence of the data and use the store microservice for that, as we want to keep it as simple as possible for the beginning. 

## Consequences

It would have been a completely viable alternative to decentralise the persistence, perhaps even using event-carried state transfer among the services. This decision would make consistency more eventual, but probably increase performance. 
