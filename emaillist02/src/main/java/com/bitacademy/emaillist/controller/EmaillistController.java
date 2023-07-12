package com.bitacademy.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.emaillist.dao.EmaillistDao;
import com.bitacademy.emaillist.vo.EmaillistVo;


public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("call doGet()");
		request.setCharacterEncoding("utf-8");
		
		String actionName = request.getParameter("action");
		
		if("add".equals(actionName)) {
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");
			
			EmaillistDao dao = new EmaillistDao();
			
			EmaillistVo vo = new EmaillistVo();
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			
			dao.insert(vo);
			
			response.sendRedirect(request.getContextPath().toString()+"/el");	
		}else if ("form".equals(actionName)) {
			//request.setAttribute("test", request.getContextPath().toString());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(request, response);
		}else {
			EmaillistDao dao = new EmaillistDao();
			List<EmaillistVo> list = dao.findAll();
			
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
