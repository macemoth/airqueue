package ch.unisg.airqueue.orchestrator.adapters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("PaymentApprovalAdapter")
public class PaymentApprovalAdapter implements JavaDelegate {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // generate a randomised payment acceptal status
        boolean paymentStatus;
        Random rand = new Random();
        if (rand.nextDouble() > 0.6) {
            paymentStatus = false;
        } else {
            paymentStatus = true;
        }

        // set global expression variable for paymentapproval status
        delegateExecution.setVariable("paymentApproval", (boolean)paymentStatus);
        LOGGER.info("Updated payment status to " + paymentStatus);
    }
}
