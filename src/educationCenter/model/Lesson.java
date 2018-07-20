package educationCenter.model;

public class Lesson {
    private String name;
    private String lecturerName;
    private int duration;
    private double price;

    public Lesson(String name, String lecturerName, int duration, double price) {
        this.name = name;
        this.lecturerName = lecturerName;
        this.duration = duration;
        this.price = price;
    }

    public Lesson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", lecturerName='" + lecturerName + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }
}
