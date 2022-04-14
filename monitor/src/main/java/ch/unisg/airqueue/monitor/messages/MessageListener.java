package ch.unisg.airqueue.monitor.messages;

import ch.unisg.airqueue.monitor.domain.PastEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.unisg.airqueue.monitor.persistence.LogRepository;

@Component
@EnableBinding(Sink.class)
public class MessageListener {

  @Autowired
  private SimpMessagingTemplate simpMessageTemplate;
  
  @Autowired
  private ObjectMapper objectMapper;

  @StreamListener(target = Sink.INPUT)
  @Transactional
  public void messageReceived(byte[] messageJsonBytes) throws Exception {
	String messageJson = new String(messageJsonBytes, "UTF-8");  
    Message<JsonNode> message = objectMapper.readValue( //
        messageJson, //
        new TypeReference<Message<JsonNode>>() {});
    
    String type = "Event";
    if (message.getType().endsWith("Command")) {
      type = "Command";
    }
    
    PastEvent event = new PastEvent( //
        type, //
        message.getType(), //
        message.getTraceid(), //
        message.getSource(), //
        message.getData().toString());
    event.setSourceJson(messageJson);
    
    // save
    LogRepository.instance.addEvent(event);
    
    // and probably send to connected websocket (TODO: Not a good place for the code here!)
    simpMessageTemplate.convertAndSend("/topic/events", event);
  }

}
