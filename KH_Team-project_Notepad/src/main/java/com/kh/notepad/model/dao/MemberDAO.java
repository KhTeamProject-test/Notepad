package com.kh.notepad.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.notepad.common.JDBCTemplate;
import com.kh.notepad.model.dto.Member;

public class MemberDAO {
    
    private Properties prop;
    
    /**
    * MemberDAO 생성자 /xml/sql.xml 경로 읽어오기
    */
    public MemberDAO() {
       // MemberDAO 객체가 생성 될 때(Service 단에서 new 연산자를 통해 객체화 될 때)
       // sql.xml 파일의 내용을 읽어와 Properties prop 객체에 K:V 세팅
       
       try {
           String filePath = MemberDAO.class.getResource("/xml/sql.xml").getPath();
           
           prop = new Properties();
           prop.loadFromXML(new FileInputStream(filePath));
           
       } catch (Exception e) {
           System.out.println("sql.xml 로드 중 예외발생");
           e.printStackTrace();
       }
    }
    
    /**
     * 회원 가입
     * @param conn
     * @param member
     * @return 성공한 행의 개수
     */
    public int signUp(Connection conn, Member member) throws SQLException {
        int result = 0;
        PreparedStatement pstmt = null;
        
        try {
            String sql = prop.getProperty("memberSignUp");
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, member.getMemberId());
            pstmt.setString(2, member.getMemberPw());
            pstmt.setString(3, member.getMemberName());
            
            result = pstmt.executeUpdate();
            
        } finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
    
    /**
     * 로그인
     * @param conn
     * @param memberId
     * @param memberPw
     * @return 로그인한 회원 정보, 실패 시 null
     */
    public Member login(Connection conn, String memberId, String memberPw) throws SQLException {
        Member member = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String sql = prop.getProperty("memberLogin");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.setString(2, memberPw);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                member = new Member();
                
                member.setMemberNo(rs.getInt("MEMBER_NO"));
                member.setMemberId(rs.getString("MEMBER_ID"));
                member.setMemberName(rs.getString("MEMBER_NAME"));
            }
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        return member;
    }
}