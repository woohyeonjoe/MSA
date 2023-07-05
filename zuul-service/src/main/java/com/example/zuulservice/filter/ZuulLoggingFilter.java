package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    // 사용자가 요청할때마다 해당 로직 동작
    @Override
    public Object run() throws ZuulException {
        log.info("************* printing logs: ");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("************* : " + request.getRequestURI());

        return null;
    }

    // 필터 타입
    @Override
    public String filterType() {
        return "pre";
    }

    // 필터 순서
    @Override
    public int filterOrder() {
        return 1;
    }

    // true: 필터 사용 하겠다.
    @Override
    public boolean shouldFilter() {
        return true;
    }

}
