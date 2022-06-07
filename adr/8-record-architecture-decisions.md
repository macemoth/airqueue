# 8. Simple BMPN-based Process for Customer Information

Date: 2022-06-07

## Status

Accepted

## Context

In order for our customers to give us additional information (such as ticket budget, preferences for meal-options on the flight, etc.) we want a simple UI where they can fill out this information. 

## Decision

We decided to create a separate Camunda-based system with a simple HTML user interface to extend the input we receive from customers so far (just the start and destination airports). However, as binding this into the other microservices involved errors that we couldn’t fix so far, we decided to keep this as a separate external microservice at the moment.

## Consequences

This microservice is currently not embedded with the booking platform and therefore doesn’t provide the desired additional value. 
