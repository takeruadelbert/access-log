package com.stn.logging.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stn.logging.entity.enumerate.RequestMethod;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class AccessLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("IpAddress")
    private String IPAddress;

    @JsonProperty("URI")
    private String URI;

    @JsonProperty("requestMethod")
    private RequestMethod requestMethod;

    @JsonProperty("requestBody")
    private String requestBody;

    @CreatedDate
    @CreationTimestamp
    @JsonIgnore
    private Date createdDate;

    public AccessLog() {

    }

    public AccessLog(String IPAddress, String URI, RequestMethod requestMethod, String requestBody) {
        this.IPAddress = IPAddress;
        this.URI = URI;
        this.requestMethod = requestMethod;
        this.requestBody = requestBody;
    }
}