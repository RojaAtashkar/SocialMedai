package client.model;

import java.time.LocalDateTime;

public class Message {
    private String id;
    private String address;
    private String createDate;
    private String type;
    private String forwardedFrom;
    private String replyTo;
    private User senderUser;
    public Message(String id, User senderUser ,String address, String createDate, String type, String forwardedFrom, String replyTo) {
        this.id = id;
        this.senderUser = senderUser;
        this.address = address;
        this.createDate = createDate;
        this.type = type;
        this.forwardedFrom = forwardedFrom;
        this.replyTo = replyTo;
    }
    public Message(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getImageAddress() {
        return address;
    }

    public String getAddress() {
        return address;
    }

    public User getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImageAddress(String imageAddress) {
        this.address = imageAddress;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {

        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForwardedFrom() {
        return forwardedFrom;
    }

    public void setForwardedFrom(String forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

}
