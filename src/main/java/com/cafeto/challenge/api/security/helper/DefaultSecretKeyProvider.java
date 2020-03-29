package com.cafeto.challenge.api.security.helper;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class DefaultSecretKeyProvider implements SecretKeyProvider {

    private byte[] SECRET_KEY = {
            (byte) 0x77, (byte) 0x72, (byte) 0x65, (byte) 0x36,
            (byte) 0x48, (byte) 0x32, (byte) 0x35, (byte) 0x68,
            (byte) 0x45, (byte) 0x73, (byte) 0x75, (byte) 0x66,
            (byte) 0x72, (byte) 0x75, (byte) 0x47, (byte) 0x75
    };


    private String RAW_SECRET_KEY = "wre6H25hEsufruGu";


    private String resourceFile;
    private byte[] secretKeyFile;

    private void init() {
        if (secretKeyFile == null) {
            log.error("!!!!!! ERROR BUILDING SECRET KEY. SOURCE FILE BYTES IS MISSING !!!!!!!!!!");
        }
        try {
            RAW_SECRET_KEY = getHash(secretKeyFile);
            SECRET_KEY = RAW_SECRET_KEY.getBytes();
        } catch (Exception ex) {
            log.error("!!!!!! ERROR BUILDING SECRET KEY HASH !!!!!!!!!!.  Ex:", ex);
        }
    }

    public void start() {
        this.init();
    }

    private String getHash(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest msgDigest = MessageDigest.getInstance("SHA-1");
        byte[] digest = msgDigest.digest(bytes);
        String hexBinary = DatatypeConverter.printHexBinary(digest);
        hexBinary = hexBinary.substring(0, 16);
        return hexBinary;
    }


    @Override
    public String getSecretKey() {
        return RAW_SECRET_KEY;
    }

    @Override
    public void setSecretKeyFile(byte[] secretKeyFile) {
        this.secretKeyFile = secretKeyFile;
        this.init();
    }

}
