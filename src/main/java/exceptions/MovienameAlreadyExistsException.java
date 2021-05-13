package exceptions;

public class MovienameAlreadyExistsException extends Exception {

    private String name;

    public MovienameAlreadyExistsException(String name) {
        super(String.format("The movie %s is already added!", name));
        this.name = name;
    }

    public String getMoviename() {
        return name;
    }
}