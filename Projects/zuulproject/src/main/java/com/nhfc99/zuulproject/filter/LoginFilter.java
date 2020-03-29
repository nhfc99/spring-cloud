package com.nhfc99.zuulproject.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String urlString = httpServletRequest.getRequestURL().toString();
        String uriString = httpServletRequest.getRequestURI();

        boolean can = ctx.getBoolean("success");

        if ("/nhfc99/getway/index/getport".compareToIgnoreCase(uriString) == 0 &&
                can) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();

        String token = httpServletRequest.getHeader("token");
        if (token == null) {
            token = httpServletRequest.getParameter("token");
        }

        if (token == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("没有登录成功");
            ctx.getResponse().setContentType("application/json; charset=utf-8");
        }

        return null;
    }
}
