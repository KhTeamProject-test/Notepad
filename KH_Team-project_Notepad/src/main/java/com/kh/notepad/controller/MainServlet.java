package com.kh.notepad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.kh.notepad.model.dto.Post;
import com.kh.notepad.model.service.PostService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            // 서비스 객체 생성
            PostService service = new PostService();
            
            // 전체 게시글 목록 조회
            List<Post> postList = service.selectAllPosts();
            
            // 공개 게시글 목록 조회
            List<Post> openPostList = service.selectOpenPosts();
			
			request.setAttribute("openPostList", openPostList);
			
            
			// 비공개 게시글 목록 조회
			List<Post> privatePostList = service.selectPrivatePostList();
			
			request.setAttribute("privatePostList", privatePostList);
			
            // 체크된 게시글 개수 조회
            int checkedCount = service.getCheckedCount();
            
            // 조회 결과를 request 객체에 세팅
            request.setAttribute("postList", postList);
            request.setAttribute("checkedCount", checkedCount);
            
            // JSP로 포워드
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/main.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            
            request.getSession().setAttribute("message", "게시글 목록 조회 중 오류가 발생했습니다.");
            response.sendRedirect(request.getContextPath()  + "/main");
        }
    }
}