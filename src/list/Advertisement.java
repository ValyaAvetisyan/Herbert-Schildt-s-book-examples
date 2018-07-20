package list;

import java.util.Date;

public class Advertisement {
    private String title;
    private String type;
    private String address;
    private Date createDate;
    private User user;

    public Advertisement(String title, String type, String address, Date creatDate, User user) {
        this.title = title;
        this.type = type;
        this.address = address;
        this.createDate = creatDate;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public Date getCreatData() {
        return createDate;
    }

    public User getUser() {
        return user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreatData(Date creatData) {
        this.createDate = creatData;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", creatData=" + createDate +
                ", user=" + user +
                '}';
    }
}
