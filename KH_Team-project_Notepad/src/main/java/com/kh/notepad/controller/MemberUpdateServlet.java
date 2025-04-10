package com.kh.notepad.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.notepad.model.dto.Member;
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
			HttpSession session = req.getSession();
			// 로그인 한 회원 정보 가져오기
			Member loginMember = (Member) session.getAttribute("loginMember");
			
			// 전달 받은 파라미터 가져오기
			String memberPw = req.getParameter("memberPw");
			String memberName = req.getParameter("memberName");
			String memberId = loginMember.getMemberId();
			
			Member member = new Member();
			member.setMemberId(memberId);
			member.setMemberPw(memberPw);
			member.setMemberName(memberName);
			// 서비스 객체 생성
			MemberService service = new MemberService();
			
			// 객체 결과 반환
			int result = service.memberUpdate(member);
			
			String url = null;
			String message = null;
			
			if(result > 0) {
				session.setAttribute("loginMember", member);
			    session.setAttribute("message", "수정 완료");
			    // 최신 회원 정보를 다시 조회해서 세션에 저장
			 //   Member updatedMember = service.login(memberId, memberPw); // ※ 주의: 로그인과 같은 방식으로 조회
			 //   session.setAttribute("loginMember", updatedMember);
			} else {
			    session.setAttribute("message", "수정 취소");
			    resp.sendRedirect("/");
			}
			resp.sendRedirect("/");

			
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
