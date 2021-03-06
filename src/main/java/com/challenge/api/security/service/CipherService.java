package com.challenge.api.security.service;

import com.challenge.api.security.helper.AESCipher;
import com.challenge.api.security.helper.DefaultAESCipher;
import com.challenge.api.security.helper.DefaultSecretKeyProvider;
import com.challenge.api.security.helper.SecretKeyProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Slf4j
public class CipherService {

    private AESCipher cipher;

    @Value("${jwt.seed}")
    private String seed;

    @PostConstruct
    private void init() {
        try {
            byte[] secretKey = seed.getBytes();

            SecretKeyProvider keyProvider = new DefaultSecretKeyProvider();
            keyProvider.setSecretKeyFile(secretKey);

            cipher = new DefaultAESCipher();
            cipher.setSecretProvider(keyProvider);
        } catch (Exception ex) {
            log.error("!!!!!! ERROR BUILDING KEY PROVIDER !!!!!!!!!!.  Ex:", ex);
        }
    }

    public String encrypt(String content) {
        return cipher.encrypt(content);
    }

}
