package client.model;

public class DirectMessage extends Message {

    private String receiverId;

    public DirectMessage(String id, User senderUser, String receiverId, String address, String createDate, String type, String forwardedFrom, String replyTo) {
        super(id, senderUser, address, createDate,type, forwardedFrom, replyTo);
        this.receiverId = receiverId;
    }
    public DirectMessage(){

    }
    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }



}
