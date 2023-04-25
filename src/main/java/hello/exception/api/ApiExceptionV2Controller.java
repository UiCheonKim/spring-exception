package hello.exception.api;

import hello.exception.exception.exception.UserException;
import hello.exception.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ApiExceptionV2Controller {

/*
    // 참고로 @ExceptionHandler 는 여기서 발생한 @Controller 에서 발생한 예외만 처리한다.
    // Service, Repository 에서 발생하는 에러는 제외 -> 이것을 처리하려면 @ControllerAdvice or @RestControllerAdvice 를 사용해야 한다.

    // ExceptionHandlerExceptionResolver 가 실행되면서 IllegalArgumentException 을 처리 할 수 있는 핸들러(@ExceptionHandler)를 찾는다.
    // @ResponseBody // 이것도 사용가능 정상적인 흐름으로 되는게 만들었기 때문에
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 이것도 사용가능 정상적인 흐름으로 되는게 만들었기 때문에
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD", e.getMessage());
    }

    // @ExceptionHandler(UserException.class) 생략가능
    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandler(UserException e) {
        log.error("[exceptionHandler] ex", e);
        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
        return new ResponseEntity(errorResult, HttpStatus.BAD_REQUEST); // ResponseEntity 를 사용하면 상태코드를 지정할 수 있다.
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandler(Exception e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("EX", "내부 오류");
    }
*/
    @GetMapping("/error2/{id}")
    public String error(@PathVariable String id) {

        if(id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }

        if(id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 입력값");
        }

        if(id.equals("user-ex")) {
            throw new UserException("사용자 오류");
        }

        return "success";
    }

}
