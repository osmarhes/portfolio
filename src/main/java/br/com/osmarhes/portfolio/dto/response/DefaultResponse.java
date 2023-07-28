package br.com.osmarhes.portfolio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponse {
    private String message;
    private String status = "SUCCESS";

    public static DefaultResponse create(HttpStatus httpStatus, String message){
        return new DefaultResponse(message, httpStatus.name());
    }
}
