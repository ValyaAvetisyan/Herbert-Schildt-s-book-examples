package genericsCollectionsExamples;

public class Generic<T> {
    T obj;

    public Generic(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    void showType() {
        System.out.println("Type of T is " +obj.getClass().getName());
    }
}