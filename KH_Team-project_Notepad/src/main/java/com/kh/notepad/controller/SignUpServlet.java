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

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 데이터 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        
        try {
            // 파라미터 얻어오기
            String memberId = request.getParameter("userId");
            String memberPw = request.getParameter("userPw");
            String memberName = request.getParameter("userName");
            
            // Member 객체에 파라미터 세팅
            Member member = new Member();
            member.setMemberId(memberId);
            member.setMemberPw(memberPw);
            member.setMemberName(memberName);
            
            // 서비스 호출
            MemberService service = new MemberService();
            boolean result = service.signUp(member);
            
            HttpSession session = request.getSession();
            
            if(result) { // 성공
                session.setAttribute("message", "회원 가입 성공! 로그인 해주세요.");
            } else { // 실패
                session.setAttribute("message", "회원 가입 실패. 다시 시도해주세요.");
            }
            
            // 메인 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath());
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            request.getSession().setAttribute("message", "회원 가입 중 오류가 발생했습니다.");
            response.sendRedirect(request.getContextPath());
        }
    }
}