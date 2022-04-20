package ch.unisg.airqueue.notification.email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailSender {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private JavaMailSenderImpl mailSender;

    private final static String SENDER_ADDRESS = "airqueue@sns.network";
    private final static String REPLY_ADDRESS = "noreply@sns.network";

    public EmailSender() {
        mailSender = new JavaMailSenderImpl();
        // Need to configure the server here because Spring testing is such an abomination
        mailSender.setHost("victorinus.metanet.ch");
        mailSender.setPort(587);
        mailSender.setUsername("airqueue@sns.network");
        mailSender.setPassword("Uuw92k2&");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
    }


    public void sendEmail(String recipient, String subject, String content) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipient);
        email.setSubject(subject);
        email.setText(content);
        email.setFrom(SENDER_ADDRESS);
        email.setReplyTo(REPLY_ADDRESS);
        mailSender.send(email);
        LOGGER.info("Email successfully sent to " + recipient);
    }


}
