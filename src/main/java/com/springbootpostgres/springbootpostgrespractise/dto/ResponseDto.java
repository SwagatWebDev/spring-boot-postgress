package com.springbootpostgres.springbootpostgrespractise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    private HttpStatus status;
    private String message;  // reason uses for error case
    private T data;
    private String serviceName;

    public static <T> ResponseDto<T> ok(T data, String serviceName) {
        ResponseDto<T> responseDto = new ResponseDto<>();
        responseDto.setServiceName(serviceName);
        responseDto.setData(data);
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("SUCCESS");
        return responseDto;
    }

    public static ResponseDto error(String error, String serviceName) {
        ResponseDto responseDto = new ResponseDto<>();
        responseDto.setServiceName(serviceName);
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage(error);
        return responseDto;
    }
}
