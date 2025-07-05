package Homeworks.Homework_3.cipher;

public class RouteCipherTest {

    public static void main(String[] args) {
        // Test 1: Encryption Example
        String plainText = "ABORT THE MISSION, YOU HAVE BEEN SPOTTED";
        int key1 = -5;
        RouteCipher cipher1 = new RouteCipher(key1);

        System.out.println("=== Test 1: Encryption ===");
        System.out.println("Plaintext: " + plainText);
        String encrypted = cipher1.encrypt(plainText);
        System.out.println("Encrypted: " + encrypted);

        // Test 2: Decryption Example
        System.out.println("\n=== Test 2: Decryption ===");
        String cipherText = "TIEIXTXXEAHSIHSPNTLT";
        int key2 = 4;
        RouteCipher cipher2 = new RouteCipher(key2);

        System.out.println("Ciphertext: " + cipherText);
        String decrypted = cipher2.decrypt(cipherText);
        System.out.println("Decrypted: " + decrypted);

        // Test 3: Encrypt and Decrypt Round-trip
        System.out.println("\n=== Test 3: Encrypt and Decrypt Round-trip ===");
        String message = "THIS IS A SECRET MESSAGE";
        int key3 = 3;
        RouteCipher cipher3 = new RouteCipher(key3);

        String encryptedMessage = cipher3.encrypt(message);
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = cipher3.decrypt(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}