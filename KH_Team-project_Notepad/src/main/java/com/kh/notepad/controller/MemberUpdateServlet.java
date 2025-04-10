package com.kh.notepad.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.notepad.model.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 전달 받은 파라미터 가져오기
			String memberPw = req.getParameter("memberPw");
			String memberName = req.getParameter("memberName");
			String memberId = req.getParameter("memberId");
			
			// 서비스 객체 생성
			MemberService service = new MemberService();
			
			// 객체 결과 반환
			int result = service.memberUpdate(memberId, memberPw, memberName);
			
			String url = null;
			String message = null;
			
			HttpSession session = req.getSession();
			
			if(result > 0) {
				url = "/" + memberId;
				message = "수정 완료!";
			} else {
				url = "/" + memberId;
				message = "수정 취소";
			}
			
			session.setAttribute("loginMember", memberId);
			
			resp.sendRedirect("/");
			
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
