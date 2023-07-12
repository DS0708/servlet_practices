package com.bitacademy.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.guestbook.dao.GuestBookDao;
import com.bitacademy.guestbook.vo.GuestBookVo;

@WebServlet("/gb")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String actionName = request.getParameter("a");
		
		if("add".equals(actionName)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String text = request.getParameter("message");
			
			GuestBookVo vo = new GuestBookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setText(text);
			
			GuestBookDao dao = new GuestBookDao();
			dao.insert(vo);
			
			response.sendRedirect(request.getContextPath().toString()+"/gb");
		}else if("deleteform".equals(actionName)) {
			String no = request.getParameter("no");
			
			request.setAttribute("no", no);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		}else if("delete".equals(actionName)) {
			Long no = Long.parseLong(request.getParameter("no"));
			String password = request.getParameter("password");
			
			GuestBookDao dao = new GuestBookDao();
			
			dao.delete(no, password);
			
			response.sendRedirect(request.getContextPath()+"/gb");
		}
		else {
			GuestBookDao dao = new GuestBookDao();
			List<GuestBookVo> list = dao.findAll();
			
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
