package com.kh.notepad.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.notepad.common.JDBCTemplate;
import com.kh.notepad.model.dao.PostDAO;
import com.kh.notepad.model.dto.Post;

public class PostService {
    
    private PostDAO dao = new PostDAO();
    
    /**
     * 게시글 목록 조회 서비스
     * @return 게시글 목록
     * @throws SQLException
     */
    public List<Post> selectAllPosts() throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        List<Post> postList = dao.selectAllPosts(conn);
        
        JDBCTemplate.close(conn);
        
        return postList;
    }
    
    /**
     * 주제별 게시글 목록 조회 서비스
     * @param topic
     * @return 게시글 목록
     * @throws SQLException
     */
    public List<Post> selectPostsByTopic(int topic) throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        List<Post> postList = dao.selectPostsByTopic(conn, topic);
        
        JDBCTemplate.close(conn);
        
        return postList;
    }
    
    /**
     * 체크된 게시글 개수 조회 서비스
     * @return 체크된 게시글 개수
     * @throws SQLException
     */
    public int getCheckedCount() throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        int count = dao.getCheckedCount(conn);
        
        JDBCTemplate.close(conn);
        
        return count;
    }
    
    /**
     * 게시글 추가 서비스
     * @param post
     * @return 성공 여부
     * @throws SQLException
     */
    public boolean addPost(Post post) throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.addPost(conn, post);
        
        if(result > 0)
            JDBCTemplate.commit(conn);
        else
            JDBCTemplate.rollback(conn);
        
        JDBCTemplate.close(conn);
        
        return result > 0;
    }
    
    /**
     * 게시글 상세 조회 서비스
     * @param postNo
     * @return 게시글 정보, 없으면 null
     * @throws SQLException
     */
    public Post selectPost(int postNo) throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        Post post = dao.selectPost(conn, postNo);
        
        JDBCTemplate.close(conn);
        
        return post;
    }
    
    /**
     * 체크 상태 변경 서비스
     * @param postNo
     * @return 성공 여부
     * @throws SQLException
     */
    public boolean toggleCheck(int postNo) throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.toggleCheck(conn, postNo);
        
        if(result > 0)
            JDBCTemplate.commit(conn);
        else
            JDBCTemplate.rollback(conn);
        
        JDBCTemplate.close(conn);
        
        return result > 0;
    }
    
    /**
     * 게시글 삭제 서비스
     * @param postNo
     * @param memberNo
     * @return 성공 여부
     * @throws SQLException
     */
    public boolean deletePost(int postNo, int memberNo) throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.deletePost(conn, postNo, memberNo);
        
        if(result > 0)
            JDBCTemplate.commit(conn);
        else
            JDBCTemplate.rollback(conn);
        
        JDBCTemplate.close(conn);
        
        return result > 0;
    }
    
    /**
     * 게시글 수정 서비스
     * @param post
     * @return 성공 여부
     * @throws SQLException
     */
    public boolean updatePost(Post post) throws SQLException {
        Connection conn = JDBCTemplate.getConnection();
        
        int result = dao.updatePost(conn, post);
        
        if(result > 0)
            JDBCTemplate.commit(conn);
        else
            JDBCTemplate.rollback(conn);
        
        JDBCTemplate.close(conn);
        
        return result > 0;
    }
}