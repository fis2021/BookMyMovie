package services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import exceptions.UsernameAlreadyExistsException;
import exceptions.WrongPasswordException;
import exceptions.SessionAlreadyExistsException;
import model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import static services.FileSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public final class UserService {

    private static ObjectRepository<User> userRepository;
    private static Nitrite database;
    private static User loggedInUser;

    public static void initDatabase() {
        database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role));
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

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
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