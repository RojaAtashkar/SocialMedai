package client.model;

import java.util.Date;

public class Group {
    private int id;
    private String groupId;
    private String groupName;
    private int adminId;
    private Date createDate;
    private String description;
    private String imageAddress;

    public Group(int id, String groupId, String groupName,
                 int adminId, Date createDate,
                 String description, String imageAddress) {
        this.id = id;
        this.groupId = groupId;
        this.groupName = groupName;
        this.adminId = adminId;
        this.createDate = createDate;
        this.description = description;
        this.imageAddress = imageAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

}
