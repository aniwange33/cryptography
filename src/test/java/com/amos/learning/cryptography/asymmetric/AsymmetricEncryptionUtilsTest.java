package com.amos.learning.cryptography.asymmetric;

import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;
import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.*;

class AsymmetricEncryptionUtilsTest {

    @Test
    void generateRSAKeyPair() {
    }


    @Test
    void performRSAEncryption() throws Exception {
        KeyPair keyPair = AsymmetricEncryptionUtils.generateRSAKeyPair();
        String text = "testing in fhi360 office";
        byte[] cipherText = AsymmetricEncryptionUtils.performRSAEncryption(text, keyPair.getPrivate());
       assertNotNull(cipherText);
        System.out.println(DatatypeConverter.printHexBinary(cipherText));
        String decryptionText = AsymmetricEncryptionUtils.performRSADecryption(cipherText, keyPair.getPublic());
        assertEquals(text, decryptionText);
    }

    @Test
    void performRSADecryption() {

    }
}