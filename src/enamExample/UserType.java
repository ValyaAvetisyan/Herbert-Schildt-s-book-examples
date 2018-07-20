package enamExample;

public enum UserType {
    ADMIN(1),
    MANAGER(2),
    OPERATOR(3) ;

    private int id;
    UserType(int id) {
       this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    UserType() {
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + id +
                '}';
    }
}

