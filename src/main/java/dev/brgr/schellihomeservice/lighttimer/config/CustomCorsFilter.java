package dev.brgr.schellihomeservice.lighttimer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomCorsFilter extends GenericFilterBean {

    private final Logger logger = LoggerFactory.getLogger(CustomCorsFilter.class);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("Origin"));
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "GET,HEAD,PUT,PATCH,POST,DELETE");
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, authorization");
        //((HttpServletResponse) response).setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        ((HttpServletResponse) response).setHeader("Cache-Control", "no-store"); // HTTP 1.1.
        ((HttpServletResponse) response).setHeader("Pragma", "no-cache"); // HTTP 1.0.
        ((HttpServletResponse) response).setHeader("Expires", "0"); // Proxies.
        chain.doFilter(request, response);
    }
}
