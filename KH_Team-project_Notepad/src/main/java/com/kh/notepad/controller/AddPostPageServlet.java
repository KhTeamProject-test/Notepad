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

@WebServlet("/addPost/add")
public class AddPostPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        req.getRequestDispatcher("/WEB-INF/views/addPost.jsp").forward(req, resp);		
	}
}