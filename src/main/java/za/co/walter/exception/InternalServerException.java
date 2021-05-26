package za.co.walter.exception;

public class InternalServerException extends InternalError{



    public InternalServerException(String message){
        super(message);
    }
}
