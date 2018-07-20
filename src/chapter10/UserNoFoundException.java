package chapter10;

public class UserNoFoundException extends Exception{
    public UserNoFoundException() {
    }

    public UserNoFoundException(String message) {
        super(message);
    }

    public UserNoFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNoFoundException(Throwable cause) {
        super(cause);
    }

    public UserNoFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
//ete exception@ cheked exception e apa petq e throws anel
//ete exception@ uncheked e apa da partadir che
//compile time error -->>  .java -->> .class file i jamanak
// RuntimeException ev Error uncheked en apa partadir che throws anel