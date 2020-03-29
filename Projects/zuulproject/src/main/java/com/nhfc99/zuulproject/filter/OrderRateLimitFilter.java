package com.nhfc99.zuulproject.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class OrderRateLimitFilter extends ZuulFilter {
    static RateLimiter rateLimiter = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -10;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String urlString = httpServletRequest.getRequestURL().toString();
        String uriString = httpServletRequest.getRequestURI();
        System.out.println("url = " + urlString);
        System.out.println("urI = " + uriString);

        if ("/nhfc99/getway/index/getport".compareToIgnoreCase(uriString) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();

        if (!rateLimiter.tryAcquire()) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("请求数量太多了");
            ctx.setResponseStatusCode(HttpStatus.SC_REQUEST_TOO_LONG);
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            ctx.set("success", false);
        } else {
            ctx.set("sendForwardFilter.ran", true);
        }
        return null;
    }
}
