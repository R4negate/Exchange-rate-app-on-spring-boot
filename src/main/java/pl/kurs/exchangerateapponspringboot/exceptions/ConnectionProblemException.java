package pl.kurs.exchangerateapponspringboot.exceptions;

public class ConnectionProblemException extends Exception{

    public ConnectionProblemException(String message) {
        super(message);
    }

    public ConnectionProblemException(String message, Throwable cause) {
        super(message, cause);
    }
}
