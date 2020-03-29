package com.cafeto.challenge.api.commons;

import java.util.List;
import java.util.Optional;

/**
 * @author janezmejias.09
 * @version SPRINT-2020A
 * @see <url_jira_ticket_here>
 */
public interface ServiceBase<T> {

    T save(T model) throws Exception;

    Optional<T> findById(Long id) throws Exception;

    boolean existsById(Long id) throws Exception;

    List<T> findAll() throws Exception;

    long count() throws Exception;

    void deleteById(Long id) throws Exception;

    void delete(T model) throws Exception;

    void deleteAll() throws Exception;

}
