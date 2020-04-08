package com.challenge.api.security.helper;

public interface SecretKeyProvider {

    void setSecretKeyFile(byte[] secretKeyFile);

    String getSecretKey();
}
