package ch.unisg.airqueue.payment.messages;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.UUID;

public class Message<T> {
    private String type;
    private String id = UUID.randomUUID().toString();
    private String source = "Payment";
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant time = Instant.now();
    private T data;
    private String datacontettype = "application/json";
    private String specversion = "1.0";

    private String traceId = UUID.randomUUID().toString();;
    private String correlationid;
    private String group = "airqueue";

    public Message() {
    }

    public Message(String type, T payload) {
        this.type = type;
        this.data = payload;
    }

    public Message(String type, String traceId, T payload) {
        this.type = type;
        this.traceId = traceId;
        this.data = payload;
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

    public T getData() {
        return data;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getCorrelationid() {
        return correlationid;
    }

    public void setSpecversion(String specversion) {
        this.specversion = specversion;
    }
}
