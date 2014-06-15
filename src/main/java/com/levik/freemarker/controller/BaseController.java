package com.levik.freemarker.controller;

import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.levik.freemarker.annotation.Service;
import com.levik.freemarker.constants.GlobalConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseController extends HttpServlet {

    protected static final Logger LOGGER = LogManager.getLogger(BaseController.class);

    private Map<String, Object> bean;

    public BaseController() {
        bean = new ConcurrentHashMap<>();
    }

    private void onInit(String servicePackage) {
        if(servicePackage.contains(GlobalConstants.PACKAGE_SCAN)) {
            try {
                final Class<?> clazz = Class.forName(servicePackage);

                if(clazz.isAnnotationPresent(Service.class)) {
                    final Service service = clazz.getAnnotation(Service.class);
                    final String name = service.name();
                    bean.put(name, clazz.newInstance());
                } else {
                    LOGGER.error("Class {} is not annotation annotation Service", servicePackage);
                }
            } catch(Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public Object getBean(String name) {
        return bean.get(name);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        final ServletContext servletContext = getServletContext();
        final Enumeration initParameterNames = servletContext.getInitParameterNames();
        while(initParameterNames.hasMoreElements()) {
            final String name = (String) initParameterNames.nextElement();
            final String servicePackage = servletContext.getInitParameter(name);
            onInit(servicePackage);
        }
    }
}
