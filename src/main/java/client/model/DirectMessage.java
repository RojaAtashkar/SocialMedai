package client.model;

import java.time.LocalDateTime;
import java.util.Date;

public class DirectMessage {
    private int id;
    private int senderId;
    private int receiverId;
    private String imageAddress;
    private LocalDateTime createDate;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getForwardedFrom() {
        return forwardedFrom;
    }

    public void setForwardedFrom(int forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
    }

    public int getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(int replyTo) {
        this.replyTo = replyTo;
    }

    private int forwardedFrom;
    private int replyTo;

    public DirectMessage(int id, int senderId, int receiverId, String imageAddress, LocalDateTime createDate, String type, int forwardedFrom, int replyTo) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.imageAddress = imageAddress;
        this.createDate = createDate;
        this.type = type;
        this.forwardedFrom = forwardedFrom;
        this.replyTo = replyTo;
    }
}
