package com.cafeto.challenge.api.security.helper;

public interface AESCipher {

    void setSecretProvider(SecretKeyProvider secretProvider);

    String encrypt(String encrypt) throws RuntimeException;

}
