package com.challenge.api.commons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * @author janezmejias.09
 */
@Slf4j
public abstract class ControllerBase<T> {

    private final ServiceBase<T> service;

    public ControllerBase(ServiceBase<T> service) {
        this.service = service;
    }

    @GetMapping(Constants.HTTP_GET_ALL)
    @ResponseBody
    ResponseEntity<ResponseBase> listAll() {
        try {
            log.info("GET ALL FROM -> {}", service.getClass().getCanonicalName());
            List<T> body = service.findAll();
            return new ResponseEntity(ResponseBase
                    .buildSuccessResponse(body), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ResponseBase
                    .buildErrorResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(Constants.HTTP_GET_ONE)
    @ResponseBody
    ResponseEntity<ResponseBase> getById(@PathVariable("id") Long id) {
        try {
            log.info("GET ONE FROM -> {} WITH ID={}", service.getClass().getCanonicalName(), id);
            Optional<T> body = service.findById(id);
            return new ResponseEntity(ResponseBase
                    .buildSuccessResponse(body), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ResponseBase
                    .buildErrorResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(Constants.HTTP_POST)
    @ResponseBody
    ResponseEntity<ResponseBase> create(@RequestBody T model) {
        try {
            log.info("POST {}", model.toString());
            T body = service.save(model);
            return new ResponseEntity(ResponseBase
                    .buildSuccessResponse(body), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ResponseBase
                    .buildErrorResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(Constants.HTTP_PUT)
    @ResponseBody
    ResponseEntity<ResponseBase> update(@RequestBody T model) {
        try {
            log.info("PUT {}", model.toString());
            T body = service.save(model);
            return new ResponseEntity(ResponseBase
                    .buildSuccessResponse(body), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ResponseBase
                    .buildErrorResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(Constants.HTTP_DELETE)
    @ResponseBody
    ResponseEntity<ResponseBase> delete(@RequestParam("id") Long id) {
        try {
            log.info("DELETE ONE OF -> {} WITH ID={}", service.getClass().getCanonicalName(), id);
            service.deleteById(id);
            return new ResponseEntity(ResponseBase
                    .buildSuccessWithOutBodyResponse(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ResponseBase
                    .buildErrorResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
