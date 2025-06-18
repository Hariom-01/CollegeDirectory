package com.aryajohary.collegedirectory.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter
public class GlobalErrorResponse {

    private HttpStatus status;
    private String message;
    private LocalDateTime timeStamp;

}
