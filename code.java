import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserAuthentication {

    public static void main(String[] args) {

        // Initialize the scanner
        Scanner scanner = new Scanner(System.in);

        // Initialize the username and password
        String username = "";
        String password = "";

        // Ask the user to enter the username
        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        // Ask the user to enter the password
        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        // Hash the password
        String hashedPassword = hash(password);

        // Verify the username and password
        if (verifyCredentials(username, hashedPassword)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed.");
        }
    }

    private static String hash(String password) {

        // Define the algorithm
        MessageDigest messageDigest = null;
        String hashedPassword = null;

        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(password.getBytes("UTF-8"));

            // Get the hash of the password
            hashedPassword = String.format("%040x", new BigInteger(1, messageDigest.digest()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashedPassword;
    }

    private static boolean verifyCredentials(String username, String hashedPassword) {

        // Initialize the valid username and hashed password
        String validUsername = "user";
        String validHashedPassword = hash("user");

        // Check if the username and hashed password match
        if
private static boolean verifyCredentials(String username, String hashedPassword) {
    // Initialize the valid username and hashed password
    String validUsername = "user";
    String validHashedPassword = hash("password"); // Assuming "password" is the valid one for simplicity

    // Check if the username and hashed password match
    return username.equals(validUsername) && hashedPassword.equals(validHashedPassword);
}
