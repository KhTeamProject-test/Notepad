package com.kh.notepad.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.kh.notepad.common.JDBCTemplate;
import com.kh.notepad.model.dao.MemberDAO;
import com.kh.notepad.model.dto.Member;

public class MemberService {
    
    private MemberDAO dao = new MemberDAO();
    
    /**
     * 회원가입 서비스
     * @param member
     * @return 성공 여부
     * @throws SQLException
     */
    public boolean signUp(Member member) throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.signUp(conn, member);
        
        if(result > 0)
            JDBCTemplate.commit(conn);
        else
            JDBCTemplate.rollback(conn);
        
        JDBCTemplate.close(conn);
        
        return result > 0;
    }
    
    /**
     * 로그인 서비스
     * @param memberId
     * @param memberPw
     * @return 로그인한 회원 정보, 실패 시 null
     * @throws SQLException
     */
    public Member login(String memberId, String memberPw) throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        Member member = dao.login(conn, memberId, memberPw);
        
        JDBCTemplate.close(conn);
        
        return member;
    }

	/** 유저 정보 수정 서비스
	 * @param memberId
	 * @param memberPw
	 * @param memberName
	 * @return 
	 * @throws SQLException 
	 */
	public int memberUpdate(Member member) throws SQLException {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.memberUpdate(conn, member);
		
        if(result > 0)
            JDBCTemplate.commit(conn);
        else
            JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}