package ch.unisg.airqueue.payment.adapter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
public class PaymentAdapter implements JavaDelegate {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void execute(DelegateExecution delegateExecution) throws Exception {
        String paymentStatus = "undefined";

        Random rand = new Random();
        if (rand.nextDouble() > 0.9) {
            paymentStatus = "declined";
        } else {
            paymentStatus = "accepted";
        }

        delegateExecution.setVariable("payment", paymentStatus);
        LOGGER.info("Updated payment status to " + paymentStatus);
    }
}