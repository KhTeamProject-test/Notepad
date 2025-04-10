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

@WebServlet("/post/detail")
public class PostDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try {
            int postNo = Integer.parseInt(request.getParameter("postNo"));
            PostService service = new PostService();
            Post post = service.selectPost(postNo);

            if (post != null) {
                request.setAttribute("post", post);
                request.getRequestDispatcher("/WEB-INF/views/post/detail.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("message", "존재하지 않는 게시글입니다.");
                response.sendRedirect(request.getContextPath() + "/post/list");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            request.getSession().setAttribute("message", "게시글 조회 중 오류가 발생했습니다.");
            response.sendRedirect(request.getContextPath() + "/post/list");
        }
    }
}