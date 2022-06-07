# 3. Orchestrator

Date: 2022-06-07

## Status

Accepted

## Context

In order to mitigate the risks of things going wrong in the booking and payment process, we need to handle the possible errors. Orchestration becomes particularly important to handle ’non-happy-paths’, often involving external services.

## Decision

We decided to use an orchestrator to handle the booking, payment and notification processes.

## Consequences

We now create a system that can handle more than just the “happy path” of the processes and that we believe can be enhanced easily, as new services can just be added with their additional error handling. The system probably isn’t as highly scalable and elastic for new bookings as it would be with a choreography. 

Furthermore, orchestration is useful for changing event chains: consider the integration of a background security check after the customer has booked a flight in the booking microservice and before the payment is done in the payment microservice. We simply write the new microservice, triggered by a JavaDelegate, insert a new step in the Camunda process and link it to the Java code. All other services remain untouched.
