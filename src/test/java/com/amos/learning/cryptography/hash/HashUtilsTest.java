package com.amos.learning.cryptography.hash;

import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HashUtilsTest {


    @Test
    void generateRandomSalt() {
        byte[] salt = HashUtils.generateRandomSalt();
        assertNotNull(salt);
        String result = DatatypeConverter.printHexBinary(salt);
        System.out.println(result);
    }
    @Test
    void createSHA2Hash() throws Exception {
        byte[] salt = HashUtils.generateRandomSalt();
        String valueToHash = "Amos tertese";
        byte[] hash = HashUtils.createSHA2Hash(valueToHash, salt);
        assertNotNull(hash);
        byte[] hash2 = HashUtils.createSHA2Hash(valueToHash, salt);
        assertEquals(DatatypeConverter.printHexBinary(hash), DatatypeConverter.printHexBinary(hash2));


    }
}