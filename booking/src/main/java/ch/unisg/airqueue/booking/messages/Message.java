package ch.unisg.airqueue.booking.messages;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.UUID;

public class Message<T> {
    private String type;
    private String id;
    private String source = "Booking";
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant time;
    private T data;
    private String datacontettype = "application/json";
    private String specversion = "1.0";

    private String traceId;
    private String correlationid;
    private String group = "flowing-retail";


    public Message(String type, T payload) {
        this.type = type;
        this.data = payload;
        id = UUID.randomUUID().toString();
        time = Instant.now();
        traceId = UUID.randomUUID().toString();
    }

    public Message(String type, String traceId, T payload) {
        this.type = type;
        this.traceId = traceId;
        this.data = payload;
        id = UUID.randomUUID().toString();
        time = Instant.now();
    }

    @Override
    public String toString() {
        return "Message [type=" + type + ", id=" + id + ", time=" + time + ", data=" + data + ", correlationid=" + correlationid + ", traceid=" + traceId + "]";
    }

    public String getType() {
        return type;
    }

    public String getTraceId() {
        return traceId;
    }


}
