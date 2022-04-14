//package ch.unisg.airqueue.booking.messages;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.camunda.bpm.engine.ProcessEngine;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import ch.unisg.airqueue.payment.domain.Transaction;
//
//@Component
//@EnableBinding(Sink.class)
//public class MessageListener {
//    @Autowired
//    private ProcessEngine camunda;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @StreamListener(target = Sink.INPUT,
//            condition="(headers['type']?:'')=='PaymentAcceptedEvent'")
//    @Transactional
//    public void paymentAccepted(Message<Transaction> message) {
//        Transaction transaction = message.getData();
//
//        if(transaction != null ) {
//            System.out.println("New transaction placed, start flow. " + transaction);
//            camunda.getRuntimeService().createMessageCorrelation(message.getType()) //
//                    .processInstanceBusinessKey(message.getTraceId())
//                    .setVariable("bookingId", transaction.getBookingId()) //
//                    .setVariable("amount", transaction.getAmount()) //
//                    .setVariable("correlationId", message.getCorrelationid()) //
//                    .correlateWithResult();
//        } else {
//            System.out.println("No transaction");
//        }
//
//    }
//}
