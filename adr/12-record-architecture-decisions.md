# 12. Event-carried state transfer (not implemented)

Date: 2022-06-07

## Status

Accepted

## Context

Currently, the booking UI does not offer any suggestions for possible flight bookings.

## Decision

We implement a store for frequent flights in the booking microservice, which is updated from time to time.

## Consequences

* Consistency becomes more eventual
* Higher storage requirements by the booking microservice
