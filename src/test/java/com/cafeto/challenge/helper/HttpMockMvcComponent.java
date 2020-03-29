package com.cafeto.challenge.helper;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.security.service.JwtTokenHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class HttpMockMvcComponent {

    private String token;
    @Autowired
    JwtTokenHelper jwtTokenHelper;

    @PostConstruct
    private void init() {
        token = jwtTokenHelper.generateToken("janezmejias.09@gmail.com");
        log.info("*******************");
        log.info("token was generated -> {}", token);
        log.info("*******************");
    }

    /**
     * @param uri END_POINT to send GET request. i.e "city"
     * @return RequestBuilder
     */
    public RequestBuilder getAll(String uri) {
        return MockMvcRequestBuilders
                .get(uri + Constants.HTTP_GET_ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token);
    }

    /**
     * @param id  Key of POJO with Long data type
     * @param uri END_POINT to send GET request. i.e "city"
     * @return RequestBuilder
     */
    public RequestBuilder getById(String uri, Long id) {
        return MockMvcRequestBuilders
                .get(uri + "/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token);
    }

    /**
     * @param content POJO with JSON format
     * @param uri     END_POINT to send POST request. i.e "city"
     * @return RequestBuilder
     */
    public RequestBuilder post(String uri, String content) {
        return MockMvcRequestBuilders
                .post(uri + Constants.HTTP_POST, content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .content(content);
    }

    /**
     * @param content POJO with JSON format
     * @param uri     END_POINT to send PUT request. i.e "city"
     * @return RequestBuilder
     */
    public RequestBuilder put(String uri, String content) {
        return MockMvcRequestBuilders
                .put(uri + Constants.HTTP_PUT, content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .content(content);
    }

    /**
     * @param uri END_POINT to send PUT request. i.e "city"
     * @param id  Key of POJO with Long data type
     * @return
     */
    public RequestBuilder delete(String uri, Long id) {
        return MockMvcRequestBuilders
                .delete(uri + Constants.HTTP_DELETE + "?id=" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token);
    }

}
