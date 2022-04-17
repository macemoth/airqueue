package ch.unisg.airqueue.test.controller;

import ch.unisg.airqueue.test.message.Message;
import ch.unisg.airqueue.test.message.MessageSender;
import ch.unisg.airqueue.test.domain.NotificationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHttpController {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private MessageSender sender;


    @RequestMapping(path = "/notification", method = RequestMethod.GET)
    public ResponseEntity<String> sendMessage() {
        LOGGER.info("Received message request with NotificationEvent type");
        NotificationEvent notification = new NotificationEvent("You Are On This Council, But We Do Not Grant You The Rank Of Master.",
                "Test Source", "marcesoler@sns.network");
        Message<NotificationEvent> message = new Message<>("NotificationEvent", notification);
        sender.send(message);
        LOGGER.info("Sent NotificationEvent");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
