package CoinDispenserApp.exception;

public class InvalidInputException extends RuntimeException{

    public InvalidInputException(String erroMsg){
        super(erroMsg);
    }

}
