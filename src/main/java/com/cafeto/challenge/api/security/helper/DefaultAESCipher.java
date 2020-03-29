package com.cafeto.challenge.api.security.helper;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.spec.KeySpec;

@Slf4j
public class DefaultAESCipher implements AESCipher {

    private static final String BASE = "BOEVNAASDRVVQOPL";
    private static final String ALG = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_ALG = "PBEWithMD5AndDES";

    private SecretKeyProvider secretKeyProvider;

    @Override
    public void setSecretProvider(SecretKeyProvider secretProvider) {
        this.secretKeyProvider = secretProvider;
    }

    public String encrypt(String encrypt) throws RuntimeException {
        try {
            Cipher cipher = Cipher.getInstance(ALG);
            IvParameterSpec iv = new IvParameterSpec(BASE.getBytes(StandardCharsets.UTF_8));
            String rawStr = secretKeyProvider.getSecretKey();
            Key secretKey = buildSecretKey2(rawStr);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] bytes = encrypt.getBytes(StandardCharsets.UTF_8);
            byte[] encrypted = cipher.doFinal(bytes);
            return DatatypeConverter.printBase64Binary(encrypted);
        } catch (Exception ex) {
            log.error("Error encrypting. Ex:{}", ex);
        }
        return null;
    }

    private static SecretKey buildSecretKey2(String rawStr) throws GeneralSecurityException {
        String salt = "ssshhhhhhhhhhh!!!!";
        KeySpec spec = new PBEKeySpec(rawStr.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_ALG);
        SecretKey secretKey = factory.generateSecret(spec);
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }


}