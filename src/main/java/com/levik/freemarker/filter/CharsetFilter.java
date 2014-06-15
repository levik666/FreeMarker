package com.levik.freemarker.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.levik.freemarker.constants.GlobalConstants;

public class CharsetFilter implements Filter {

    private String encoding;

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter(GlobalConstants.REQUEST_ENCODING);
        if (encoding == null) encoding = GlobalConstants.DEFAULT_ENCODING;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setContentType(GlobalConstants.DEFAULT_CONTENT_TYPE);
        response.setCharacterEncoding(encoding);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}