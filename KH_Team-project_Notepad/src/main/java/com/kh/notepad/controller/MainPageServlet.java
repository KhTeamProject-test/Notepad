package com.kh.notepad.controller;

import java.io.IOException;
import java.util.List;

import com.kh.notepad.model.dto.Post;
import com.kh.notepad.model.service.PostService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			PostService service = new PostService();
			
			List<Post> openPostList = service.selectOpenPosts();
			
			int checkedCount = service.getCheckedCount();
			
			req.setAttribute("openPostList", openPostList);
			req.setAttribute("checkedCount", checkedCount);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mainPage.jsp");
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.getSession().setAttribute("message", "게시글 목록 조회 중 오류가 발생했습니다.");
            resp.sendRedirect(req.getContextPath());
		}
		
         
         
	}
	
}
