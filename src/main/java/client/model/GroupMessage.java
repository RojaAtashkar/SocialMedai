package client.model;

import java.time.LocalDateTime;

public class GroupMessage {
    private  int id;
    private int senderId;
    private int groupId;
    private String mediaAddress;
    private LocalDateTime createDate;
    private String type;
    private int forwardedFrom;
    private int replyTo;

    public GroupMessage(int id, int senderId, int groupId,
                        String mediaAddress, LocalDateTime createDate,
                        String type, int forwardedFrom, int replyTo) {
        this.id = id;
        this.senderId = senderId;
        this.groupId = groupId;
        this.mediaAddress = mediaAddress;
        this.createDate = createDate;
        this.type = type;
        this.forwardedFrom = forwardedFrom;
        this.replyTo = replyTo;
    }

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getMediaAddress() {
        return mediaAddress;
    }

    public void setMediaAddress(String mediaAddress) {
        this.mediaAddress = mediaAddress;
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
}
