package ecoturismo.user.exception;

public class InvalidRequestException extends UserException {

    public InvalidRequestException() {
        super();
    }

    public InvalidRequestException(String message) {
        super(message);
    }

}