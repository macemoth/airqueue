# 2. Service Granularity (Architecture)

Date: 2022-06-07

## Status

Accepted

## Context

The AIRQUEUE project will allow customers to book flights offered by various airlines using an external payment service, display information about the booked flights such as delays or change of airplane and notify the customer of anything important via email notifications. These requirements to our platform all differ in their non-functional requirements, e.g. the payment must be atomic and resilient to failures, the UI must display accurate and the latest state of data, while the notifications must eventually reach the customers. 

## Decision

We decided to split the AIRQUEUE platform into the following microservices: 
* Booking: Delivers the frontend UI and lets customers book a flight from a start to destination airport. Furthermore, keeps track of customer flight bookings.
* Payment: Handles the booking payment (processes customer payment approval)
* Notification: Notifies customers about payment updates via e-mail

## Consequences

We decided to keep the frontend in the booking microservice, but as the platform grows it would be worth considering a separate microservice for the UI. With the split into these microservices, the system is more resilient as if one service fails the others can still continue to function. This also means that our platform can more easily be extended and we can add new services without having to change the existing ones. 
