# 11. Saga Pattern for Rollback & Human Intervention

Date: 2022-06-07

## Status

Accepted

## Context

After a customer has booked a flight, but the payment has failed, they are notified and can apply for reapproval.

## Decision

If the customer does not apply for the reapproval within 24 hours after the notification, the booking and the customer records should be deleted (rollback).

## Consequences

By considering the customer and booking creation as a Saga, we can roll back the process in case a failure occurs (such as the failed application for reapproval). The rollback handles the local tasks of deletion.
