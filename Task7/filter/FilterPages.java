package com.example10.filter;

import jakarta.servlet.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FilterPages implements Filter {
    private Logger logger = LoggerFactory.getLogger(FilterPages.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter: - begin");

        var params = servletRequest.getParameterMap();
        for(String param: params.keySet()){
            var values = params.get(param);
            String valuesString = String.join(",", values);
            logger.info("doFilter: " + param + ": { " + valuesString + " }.");
        }
        var attributes = servletRequest.getAttributeNames().asIterator();
        while (attributes.hasNext()){
            var attribute = attributes.next();
            logger.info("doFilter: " + attribute + " => " + servletRequest.getAttributeNames());
        }
        FilterChain.doFilter(servletRequest, servletResponse);
        logger.info("doFilter: - end");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
