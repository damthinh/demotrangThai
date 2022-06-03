package com.example.demo_trang_thai.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private String message;
    private Object data;

    public Response( String message) {
        this.message = message;
    }
}
