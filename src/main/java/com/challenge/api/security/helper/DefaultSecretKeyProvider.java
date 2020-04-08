package com.challenge.api.security.helper;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class DefaultSecretKeyProvider implements SecretKeyProvider {


    private String RAW_SECRET_KEY = "wre6H25hEsufruGu";


    private String resourceFile;
    private byte[] secretKeyFile;

    private void init() {
        if (secretKeyFile == null) {
            log.error("!!!!!! ERROR BUILDING SECRET KEY. SOURCE FILE BYTES IS MISSING !!!!!!!!!!");
        }
        try {
            RAW_SECRET_KEY = getHash(secretKeyFile);
            byte[] SECRET_KEY = RAW_SECRET_KEY.getBytes();
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
