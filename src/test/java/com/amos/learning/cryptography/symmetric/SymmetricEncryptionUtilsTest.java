package com.amos.learning.cryptography.symmetric;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricEncryptionUtilsTest {

    @Test
    void createAESKey() throws NoSuchAlgorithmException {
        SecretKey aesKey = SymmetricEncryptionUtils.createAESKey();
        assertNotNull(aesKey);
        System.out.println(DatatypeConverter.printHexBinary(aesKey.getEncoded()));
    }

    @Test
    void performAESEncryption() throws Exception {
        SecretKey aesKey = SymmetricEncryptionUtils.createAESKey();
        byte[] initializationVector = SymmetricEncryptionUtils.createInitializationVector();
        String text = "Amos is testing encryption";
        byte[] cipherText = SymmetricEncryptionUtils.performAESEncryption(text, aesKey, initializationVector);
        assertNotNull(cipherText);
        System.out.println(DatatypeConverter.printHexBinary(cipherText));
        String decryptText = SymmetricEncryptionUtils.performAESDecryption(cipherText, aesKey, initializationVector);
        assertEquals(text, decryptText);
    }

}