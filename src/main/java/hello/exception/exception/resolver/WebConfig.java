package hello.exception.exception.resolver;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        // configureHandlerExceptionResolvers 를 사용하면 스프링이 기본으로 등록하면 ExceptionResolver 가 제거되므로 주의, extendHandlerExceptionResolvers 를 사용하자.
        resolvers.add(new MyHandlerExceptionResolver());
        resolvers.add(new UserHandlerExceptionResolver());
    }
}
