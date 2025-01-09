package com.jspark.rdmbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public  class  ReplyDto<T> {
    private boolean success;
    private String message;
    private T data;
    private ErrorMessage error;
}
