package com.kh.notepad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.kh.notepad.model.dto.Member;
import com.kh.notepad.model.dto.Post;
import com.kh.notepad.model.service.MemberService;
import com.kh.notepad.model.service.PostService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addPost/post")
public class AddPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            HttpSession session = request.getSession();
            Member loginMember = (Member) session.getAttribute("loginMember");

            // 로그인 여부 확인
            if (loginMember == null) {
                session.setAttribute("message", "로그인 후 이용해주세요.");
                response.sendRedirect(request.getContextPath() + "/loginPage");
                return;
            }
            
            // 파라미터 추출
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int topic = Integer.parseInt(request.getParameter("topic"));
            int option = Integer.parseInt(request.getParameter("option"));
            String Id = loginMember.getMemberId();

            
            Post post = new Post();
            post.setPostTitle(title);
            post.setPostContent(content);
            post.setPostTopic(topic);
            post.setPostOption(option);
            post.setMemberId(Id);
            PostService service = new PostService();
            boolean result = service.addPost(post);

            if (result) {
                session.setAttribute("message", "게시글이 등록되었습니다.");
                response.sendRedirect(request.getContextPath() + "/main");
            } else {
                request.setAttribute("message", "게시글 등록 실패");
                request.getRequestDispatcher("/WEB-INF/views/addPost.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "게시글 등록 중 오류 발생");
            request.getRequestDispatcher("/WEB-INF/views/addPost.jsp").forward(request, response);
        }
    }
}