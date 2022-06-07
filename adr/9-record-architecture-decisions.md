# 9. Stateful Retry for Camunda Workflow

Date: 2022-06-07

## Status

Accepted

## Context

The payment microservice is governed by a Camunda workflow, and could be expanded to support the stateful retry pattern by responsibly handling payment errors itself. For example, if a credit card is declined, instead of cancelling the Booking (as it is the case with the current implementation of the orchestrator), the microservice could retry the payment with another payment method.

## Decision

The implementation of this went above our time limit for this project so we decided to leave this out and focus on other workflow issues instead.

## Consequences

A failure in the payment leads to the cancellation of the booking and deletion of that data instead of a retry, which also means that the customer is more inconvenienced by this.
