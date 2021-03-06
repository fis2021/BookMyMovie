package services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import exceptions.UsernameAlreadyExistsException;
import exceptions.WrongPasswordException;
import exceptions.SessionAlreadyExistsException;
import model.User;
import model.Movie;
import exceptions.MovieException;
import exceptions.MovienameAlreadyExistsException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import static services.FileSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public final class UserService {

    private static ObjectRepository<User> userRepository;
    private static ObjectRepository<Movie> movieRepository;
    private static Nitrite database;
    private static User loggedInUser;
    private static int ok;

    public static void initDatabase() {
        database = Nitrite.builder()
                .filePath(getPathToFile("BookMyMovie.db").toFile())
                .openOrCreate();
        userRepository = database.getRepository(User.class);
        movieRepository = database.getRepository(Movie.class);
    }

    public static List<User> getAllUsers() {
        return userRepository.find().toList();
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role));
    }

    public static void addMovie(String name, String genre, String description) throws MovienameAlreadyExistsException {
        checkMovieDoesNotAlreadyExist(name);
        movieRepository.insert(new Movie(name, genre, description));
    }
    public static List<Movie> findMovies() {
        return getMovieRepo().find().toList();

    }
    public static Movie findMovie(String name) {
        return getMovieRepo().find(eq("name", name)).firstOrDefault();
    }

    public static void addRate(String name, int rate) throws MovieException{
        ok = 0;
        for (Movie movie1 : movieRepository.find()) {
            if (Objects.equals(name, movie1.getName())) {
                movie1.setRate(rate);
                ok=1;
            }
        }
        if(ok==0){
            throw new MovieException();
        }
    }

    public static void deleteMovie(String name) throws MovieException{
        ok=0;
        for (Movie movie : movieRepository.find()) {
            if (Objects.equals(name, movie.getName())) {
                getMovieRepo().remove(movie);
                ok=1;
            }
        }
        if(ok==0){
            throw new MovieException();
        }
    }

    protected static ObjectRepository<Movie> getMovieRepo() {
        return movieRepository;
    }


    public static User findUser(String username) {
        return getUserRepo().find(eq("username", username)).firstOrDefault();
    }

    protected static ObjectRepository<User> getUserRepo() {
        return userRepository;
    }

    public static User login(String username, String password) throws Exception {
        User user = findUser(username);
        if (user == null) {
            throw new WrongPasswordException();
        }
        checkPassword(user, password);
        startSession(user);
        return user;
    }

    private static boolean checkSessionExists() {
        return loggedInUser != null;
    }

    public static void startSession(User user) throws Exception{
        if (checkSessionExists()) {
            throw new SessionAlreadyExistsException();
        }
        loggedInUser = user;
    }

    public static void logout() {
        destroySession();
    }

    public static void destroySession() {
        loggedInUser = null;
    }

    public static void closeDatabase() {
        database.close();
    }

    private static void checkPassword(User user, String password) throws WrongPasswordException {
        if (!Objects.equals(encodePassword(user.getUsername(), password), user.getPassword())) {
            throw new WrongPasswordException();
        }
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    private static void checkMovieDoesNotAlreadyExist(String name) throws MovienameAlreadyExistsException {
        for (Movie movie : movieRepository.find()) {
            if (Objects.equals(name, movie.getName()))
                throw new MovienameAlreadyExistsException(name);
        }
    }

    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", "");
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

}