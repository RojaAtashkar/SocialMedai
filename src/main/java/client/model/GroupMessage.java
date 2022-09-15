package client.model;

import java.time.LocalDateTime;

public class GroupMessage extends Message {

    private String groupId;

    public GroupMessage(String id, String senderId, String groupId, String address, String createDate, String type, String forwardedFrom, String replyTo) {
        super(id,senderId, address, createDate,type, forwardedFrom, replyTo);
        this.groupId = groupId;
    }
    public GroupMessage(){

    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

}
