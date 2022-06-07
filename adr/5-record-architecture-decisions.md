# 5. EDA Patterns for Event Notification:

Date: 2022-06-07

## Status

Accepted

## Context

When a payment gets rejected the customer needs to be informed by email with instructions for further actions. If the payment gets accepted, the customer also needs to be informed about it. Furthermore, in the future any important updates about the booking need to be communicated to the customer via the e-mail service.

## Decision

We decided to add a notification service which sends emails to inform customers about the above discussed topics in the process.

## Consequences

Internally, we use events to decouple microservices. For example, the booking microservice may have a high throughput and the payment microservice might be slower. With events, the booking microservice does not have to synchronously wait until the payment procedure of one customer is done, but can immediately serve new customers.
For the future a push notification service could be implemented to offer quicker notifications to the customer. 

