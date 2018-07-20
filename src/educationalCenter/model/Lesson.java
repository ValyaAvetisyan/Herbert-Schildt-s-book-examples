package educationalCenter.model;

public class Lesson {
    private String name;
    private int duration;
    private double price;
    private String lecturerName;

    public Lesson(String name, int duration, double price, String lectureName) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.lecturerName = lectureName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", lecturerName='" + lecturerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lessons = (Lesson) o;

        if (duration != lessons.duration) return false;
        if (Double.compare(lessons.price, price) != 0) return false;
        if (name != null ? !name.equals(lessons.name) : lessons.name != null) return false;
        return lecturerName != null ? lecturerName.equals(lessons.lecturerName) : lessons.lecturerName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + duration;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (lecturerName != null ? lecturerName.hashCode() : 0);
        return result;
    }
}
