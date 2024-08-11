package com.comsatel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		try {
            String password = "123";
            byte[] fixedSalt = "fixedsalt12345678".getBytes(); // Salt fijo para consistencia
            String sshaHash = generateSSHAHash(password, fixedSalt);
            System.out.println("Generated SSHA Hash: " + sshaHash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static String generateSSHAHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        // Hash the password with the fixed salt
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(password.getBytes());
        md.update(salt);
        byte[] hashedPassword = md.digest();

        // Combine the hash and salt
        byte[] hashAndSalt = new byte[hashedPassword.length + salt.length];
        System.arraycopy(hashedPassword, 0, hashAndSalt, 0, hashedPassword.length);
        System.arraycopy(salt, 0, hashAndSalt, hashedPassword.length, salt.length);

        // Encode in Base64
        String encodedHash = Base64.getEncoder().encodeToString(hashAndSalt);

        // Return the SSHA format
        return "{SSHA}" + encodedHash;
    }
	
    public static String randomgGnerateSSHAHash(String password) throws NoSuchAlgorithmException {
        // Generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        // Hash the password with the salt
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(password.getBytes());
        md.update(salt);
        byte[] hashedPassword = md.digest();

        // Combine the hash and salt
        byte[] hashAndSalt = new byte[hashedPassword.length + salt.length];
        System.arraycopy(hashedPassword, 0, hashAndSalt, 0, hashedPassword.length);
        System.arraycopy(salt, 0, hashAndSalt, hashedPassword.length, salt.length);

        // Encode in Base64
        String encodedHash = Base64.getEncoder().encodeToString(hashAndSalt);

        // Return the SSHA format
        return "{SSHA}" + encodedHash;
    }
}
