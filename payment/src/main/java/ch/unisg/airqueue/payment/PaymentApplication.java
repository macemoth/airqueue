package ch.unisg.airqueue.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;

@SpringBootApplication
@EnableProcessApplication
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

}
