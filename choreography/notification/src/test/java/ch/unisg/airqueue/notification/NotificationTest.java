package ch.unisg.airqueue.notification;

import ch.unisg.airqueue.notification.email.EmailSender;
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

}
