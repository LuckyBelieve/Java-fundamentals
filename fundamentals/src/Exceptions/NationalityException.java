package Exceptions;

public class NationalityException extends Exception{
    public String message;
    public NationalityException(String message) {
        super(message);
        this.message = message;
    }
    public String toString(){
        return "Customized Exception " + message;
    }

}
