# 4. Choreography Evaluation for Happy Path

Date: 2022-06-07

## Status

Accepted

## Context

The current approach is heavily oriented around the orchestrator. Although it structures the flow and simplifies error handling, typical advantages of event-driven architectures are less revealed.

## Decision

We decided to implement a choreographed airqueue variant covering the happy path to evaluate a choreographed approach.

## Consequences

* To not break the orchestrator approach, no code of the choreography evaluation is taken into the old codebase.
* We recognise that error handling with choreography is more difficult and introduces new dependencies.
