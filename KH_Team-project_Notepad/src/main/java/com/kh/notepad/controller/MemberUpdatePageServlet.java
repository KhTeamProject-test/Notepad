package com.kh.notepad.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/updatePage")
public class MemberUpdatePageServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        // JSP로 요청 위임 (forward)
        req.getRequestDispatcher("/WEB-INF/views/memberUpdate.jsp").forward(req, resp);		
	}

}
