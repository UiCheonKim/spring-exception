package hello.exception.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad") // 원래는 Exception 터지면 500 에러가 나옴
public class BadRequestException extends RuntimeException {

}