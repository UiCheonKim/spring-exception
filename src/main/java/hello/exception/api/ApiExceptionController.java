package hello.exception.api;

import hello.exception.exception.exception.BadRequestException;
import hello.exception.exception.exception.UserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController // @Controller + @ResponseBody (뷰 리졸버를 실행하지 않고, HTTP 메시지 바디에 직접 데이터를 입력)
@RequiredArgsConstructor
@RequestMapping
public class ApiExceptionController {

    @GetMapping("/error/{id}")
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
    @GetMapping("/response-status-ex1")
    public String responseStatusEx1() {
        throw new BadRequestException();
    }

    @GetMapping("/response-status-ex2")
    public String responseStatusEx2() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "error.bad", new IllegalArgumentException());
    }

    @GetMapping("/default-handler-ex")
    public String defaultException(@RequestParam Integer data) {
        return "ok";
    }


}
