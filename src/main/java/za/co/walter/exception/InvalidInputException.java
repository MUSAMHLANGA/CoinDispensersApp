package za.co.walter.exception;

public class InvalidInputException extends RuntimeException{

    public InvalidInputException(String erroMsg){
        super(erroMsg);
    }

}
