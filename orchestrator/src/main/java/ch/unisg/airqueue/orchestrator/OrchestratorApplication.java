package ch.unisg.airqueue.orchestrator;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class OrchestratorApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(OrchestratorApplication.class, args);
  }
}