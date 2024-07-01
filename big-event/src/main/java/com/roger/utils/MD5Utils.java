package com.roger.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /**
     * Generate MD5 hash for a given input string.
     *
     * @param input the input string to hash
     * @return the MD5 hash as a hexadecimal string
     */
    public static String getMD5(String input) {
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add input bytes to digest
            md.update(input.getBytes());

            // Get the hash bytes
            byte[] byteData = md.digest();

            // Convert the byte to hex format
            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "password123";
        String md5Hash = MD5Utils.getMD5(input);
        System.out.println("MD5 hash of '" + input + "' is: " + md5Hash);
    }
}

