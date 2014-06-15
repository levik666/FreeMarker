package com.levik.freemarker.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.levik.freemarker.constants.GlobalConstants;
import com.levik.freemarker.model.User;
import com.levik.freemarker.service.UserService;

public class UserController extends BaseController {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) getBean("userService");
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("users", userService.getUsers());
		request.getRequestDispatcher("/index.ftl").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        User user = new User(request.getParameter(GlobalConstants.FIRST_NAME), request.getParameter(GlobalConstants.LAST_NAME));
        userService.addUser(user);
		doGet(request, response);
	}
}
