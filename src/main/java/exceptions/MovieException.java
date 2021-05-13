package exceptions;

public class MovieException extends Exception{
    public MovieException() {
        super("Movie does not exist!");
    }
}
