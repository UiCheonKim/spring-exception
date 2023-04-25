package hello.exception.exception.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        log.info("call resolver", ex);

        // ex - 이런 exception 이 발생했을 때
        // ModelAndView - 정상적인 ModelAndView 를 반환해주면 된다.
        try {
            // 예외 꿀꺽함
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400"); // 컨트롤러 내부에서 IllegalArgumentException 이 발생하면 컨트롤러 밖으로 나오면 400 에러로 변환 처리
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                return new ModelAndView(); // 새로운 ModelAndView 를 반환해줘야 한다.
                // ModelAndView(); 빈 값으로 넘기면 정상적인 흐름대로 return..return..return.. 이 되어서 Servlet was container 까지 흐름이 return 된다.
            }
/*
            if(ex..) {
                response.getWriter().println("{"key":"value"}"); // json 형태로 보내준다.
            }
 */
        }catch (IOException e) { // sendError 는 IOException 을 발생시키는데 Checked Exception 이므로 try-catch 로 처리해줘야 한다.
            log.error("resolver ex", e);
        }
        return null; // null 로 하게되면 예외가 터져서 계속 날라가게 됨
    }
}
