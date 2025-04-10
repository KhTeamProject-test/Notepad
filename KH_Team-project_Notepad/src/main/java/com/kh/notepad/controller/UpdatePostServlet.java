package com.kh.notepad.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.notepad.model.dto.Member;
import com.kh.notepad.model.dto.Post;
import com.kh.notepad.model.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/post/update")
public class UpdatePostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        Member loginMember = (Member) session.getAttribute("loginMember");
        if (loginMember == null) {
            session.setAttribute("message", "로그인 후 이용해주세요.");
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        try {
            int postNo = Integer.parseInt(request.getParameter("postNo"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int topic = Integer.parseInt(request.getParameter("topic"));
            int option = Integer.parseInt(request.getParameter("option"));

            Post post = new Post();
            post.setPostNo(postNo);
            post.setPostTitle(title);
            post.setPostContent(content);
            post.setPostTopic(topic);
            post.setPostOption(option);
            post.setMemberNo(loginMember.getMemberNo());

            PostService service = new PostService();
            boolean result = service.updatePost(post);

            if (result) {
                session.setAttribute("message", "게시글이 수정되었습니다.");
                response.sendRedirect(request.getContextPath() + "/post/detail?postNo=" + postNo);
            } else {
                request.setAttribute("message", "게시글 수정 실패");
                request.getRequestDispatcher("/WEB-INF/views/updatePost.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "게시글 수정 중 오류 발생");
            request.getRequestDispatcher("/WEB-INF/views/updatePost.jsp").forward(request, response);
        }
    }
}
