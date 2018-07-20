package listClass.model;

import java.util.Date;

public class Ad {
    private String title;
    private String desc;
    private String type;
    private double price;
    private Date createdDate;
    private User user;
    private Date lastUpdatedDate;

    public Ad(String title, String desc, String type, double price, Date createdDate, User user) {
        this.title = title;
        this.desc = desc;
        this.type = type;
        this.price = price;
        this.createdDate = createdDate;
        this.user = user;
    }

    public Ad() {
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", createdDate=" + createdDate +
                ", user=" + user +
                '}';
    }
}
