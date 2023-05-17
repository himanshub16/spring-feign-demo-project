package com.example.feignapi.commons.dto;

public class Message {
    private String senderName;
    private String receiverName;
    private String content;

    public Message() {}

    public Message(String senderName, String receiverName, String content) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Message(sender=%s, receiver=%s, content=%s", senderName, receiverName, content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
