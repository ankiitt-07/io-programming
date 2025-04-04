package com.csv.encryptdecrypt;

import java.util.Base64;

public class EncryptionUtil {
    public static String encrypt(String data) {
        try {
            return Base64.getEncoder().encodeToString(data.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    public static String decrypt(String encryptedData) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            return new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error decrypting data", e);
        }
    }
    // Validates if the data is encrypted
    public static boolean isValidEncryptedData(String data) {
        return data != null && data.matches("^[A-Za-z0-9+/=]+$");
    }
}
