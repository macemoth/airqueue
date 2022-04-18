package ch.unisg.airqueue.flight;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class ReserveSeatOnFlight implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String ticketType = "Economy";

        String budget = (String) delegateExecution.getVariable("budget");
        double budgetDouble = Double.parseDouble(budget);

        if (budgetDouble >= 5000) {
            ticketType = "First Class";
        } else if (budgetDouble >= 1000) {
            ticketType = "Business Class";
        } else if (budgetDouble < 50) {
            ticketType = "Poor";
            throw new BpmnError("TooPoor", "A too low budget has led to the inability of booking a flight.");
        }

        delegateExecution.setVariable("ticketType", ticketType);
    }
}
