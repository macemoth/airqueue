# 7. Process Orchestration with Camunda 

Date: 2022-06-07

## Status

Accepted

## Context

Without using Kafka as a message broker, we wanted to have an independently running user service based on the Camunda bpmn processes to understand the Camunda workflow with the user dashboard. This service is based on user tasks and includes a service to handle the seat booking based on the user’s budget.

## Decision

We decide to use Camunda as a central orchestrator.

## Consequences
* New orchestrator microservice
* BPMN process (see dedicated ADR)
* Easier error handling, but less scalability
