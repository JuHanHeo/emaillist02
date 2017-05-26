package com.jx372.emaillist.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jx372.emaillist.dao.EmailListDao;
import com.jx372.emaillist.vo.emailListVo;
import com.jx372.web.util.WebUtils;

@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String actionName = request.getParameter("a");

		if("form".equals(actionName)){

		}else if("insert".equals(actionName)){

		}else{
			//default action(list)
			List<emailListVo> list = new EmailListDao().getList();
			
			request.setAttribute("list", list);
			
			WebUtils.forward("/WEB-INF/views/index.jsp", request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
