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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            // 파라미터 얻어오기
            String memberId = request.getParameter("userId");
            String memberPw = request.getParameter("userPw");
            
            // 서비스 호출
            MemberService service = new MemberService();
            Member loginMember = service.login(memberId, memberPw);
            
            HttpSession session = request.getSession();
            
            if(loginMember != null) { // 로그인 성공
                session.setAttribute("loginMember", loginMember);
                session.setAttribute("message", "환영합니다!");

                // 메인 페이지로 리다이렉트
                response.sendRedirect(request.getContextPath() + "/main");
            } else { // 로그인 실패
                session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
                // 로그인 페이지로 리다이렉트
                response.sendRedirect(request.getContextPath() + "/loginPage");
            }
            

            
        } catch (SQLException e) {
            e.printStackTrace();
            
            request.getSession().setAttribute("message", "로그인 중 오류가 발생했습니다.");
            response.sendRedirect(request.getContextPath());
        }
    }
}
