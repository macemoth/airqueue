package ch.unisg.airqueue.notification;

import ch.unisg.notification.Messages.Message;
import ch.unisg.notification.Messages.NotificationEvent;
import ch.unisg.notification.email.EmailSender;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificationTest {


    @Autowired
    EmailSender sender;

    @Test
    public void testEmailSender() {
        sender = new EmailSender();/**/
        sender.sendEmail("marcesoler@sns.network", "airqueue test e-mail",
                "You Are On This Council, But We Do Not Grant You The Rank Of Master.");
    }

    @Test
    @Ignore
    public void testNotificationEvent() {
        NotificationEvent notification = new NotificationEvent("You Are On This Council, But We Do Not Grant You The Rank Of Master.",
                "Test Source", "marcesoler@sns.network");
        Message<NotificationEvent> message = new Message<>("NotificationEvent", notification);
        MessageSender sender = new MessageSender();
        sender.send(message);
    }

}
