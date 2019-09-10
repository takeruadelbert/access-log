package com.stn.logging.service;

import com.stn.logging.entity.AccessLogQueueSender;
import com.stn.logging.entity.AccessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccessLogService {
    @Autowired
    private AccessLogQueueSender accessLogQueueSender;

    public ResponseEntity loggingAccess(AccessLog accessLog) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        if (accessLog != null) {
            try {
                accessLogQueueSender.send(accessLog);
                System.out.println("Message has been sent successfully to Queue.");
                result.put("status", HttpStatus.OK.value());
                result.put("message", "Message has been sent successfully to Queue.");
                status = HttpStatus.OK;
            } catch (Exception ex) {
                result.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());
                result.put("message", ex.getMessage());
                status = HttpStatus.UNPROCESSABLE_ENTITY;
            }
        }
        return new ResponseEntity<>(result, status);
    }


}
