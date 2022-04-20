package ch.unisg.airqueue.notification.messages;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.UUID;

public class Message<T> {
    private String type;
    private String id;
    private String source = "Notification";
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant time;
    private T data;
    private String datacontettype = "application/json";
    private String specversion = "1.0";

    private String traceId;
    private String correlationid;
    private String group = "airqueue";


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

    public Message() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDatacontettype() {
        return datacontettype;
    }

    public void setDatacontettype(String datacontettype) {
        this.datacontettype = datacontettype;
    }

    public String getSpecversion() {
        return specversion;
    }

    public void setSpecversion(String specversion) {
        this.specversion = specversion;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getCorrelationid() {
        return correlationid;
    }

    public void setCorrelationid(String correlationid) {
        this.correlationid = correlationid;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Message [type=" + type + ", id=" + id + ", time=" + time + ", data=" + data + ", correlationid=" + correlationid + ", traceid=" + traceId + "]";
    }

}
