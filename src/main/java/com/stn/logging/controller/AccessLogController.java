package com.stn.logging.controller;

import com.stn.logging.entity.AccessLog;
import com.stn.logging.service.AccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access_log")
public class AccessLogController {
    @Autowired
    private AccessLogService accessLogService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity loggingAccess(@RequestBody AccessLog accessLog) {
        return accessLogService.loggingAccess(accessLog);
    }
}