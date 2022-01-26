package com.amos.learning.cryptography.signature;

import com.amos.learning.cryptography.asymmetric.AsymmetricEncryptionUtils;
import com.google.common.hash.Hashing;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureUntilTest {

    @Test
    void createDigitalSignature() throws Exception {
        byte[] input = "Amos text".getBytes();
        KeyPair keyPair = AsymmetricEncryptionUtils.generateRSAKeyPair();
        byte[] digitalSignature = DigitalSignatureUntil.createDigitalSignature(input, keyPair.getPrivate());
        assertNotNull(digitalSignature);
        //System.out.println(DatatypeConverter.printHexBinary(digitalSignature));
        byte[] input1 = "Amos text".getBytes();
        assertTrue(DigitalSignatureUntil.verifyDigitalSignature(input1, digitalSignature, keyPair.getPublic()));
        String fileName = "test" + ".json";
        String folder = ("sync/").concat(Long.toString(100).concat("/")).concat("test").concat("/");
        File file = new File(folder.concat(fileName));
        FileUtils.writeByteArrayToFile(file, input1);
    }

    @Test
    void verifyDigitalSignature() {
        String hash = Hashing.sha256().hashBytes("amos aniwangr".getBytes()).toString();
        String hash2 = Hashing.sha256().hashBytes("amos aniwangr".getBytes()).toString();
        assertEquals(hash, hash2);




    }
}