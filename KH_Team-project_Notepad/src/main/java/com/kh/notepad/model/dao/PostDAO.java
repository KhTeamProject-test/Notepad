package com.kh.notepad.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.notepad.common.JDBCTemplate;
import com.kh.notepad.model.dto.Post;

public class PostDAO {
    
    private Properties prop;
    
    /**
     * PostDAO 생성자 /xml/sql.xml 경로 읽어오기
     */
    public PostDAO() {
        // PostDAO 객체가 생성 될 때(Service 단에서 new 연산자를 통해 객체화 될 때)
        // sql.xml 파일의 내용을 읽어와 Properties prop 객체에 K:V 세팅
        
        try {
            String filePath = PostDAO.class.getResource("/xml/sql.xml").getPath();
            
            prop = new Properties();
            prop.loadFromXML(new FileInputStream(filePath));
            
        } catch (Exception e) {
            System.out.println("sql.xml 로드 중 예외발생");
            e.printStackTrace();
        }
    }
    
    /**
     * 게시글 목록 조회
     * @param conn
     * @return 게시글 목록
     */
    public List<Post> selectAllPosts(Connection conn) throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String sql = prop.getProperty("postListFullView");
            
            pstmt = conn.prepareStatement(sql);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Post post = new Post();
                
                post.setPostNo(rs.getInt("POST_NO"));
                post.setPostTitle(rs.getString("POST_TITLE"));
                post.setPostTopic(rs.getInt("POST_TOPIC"));
                post.setPostOption(rs.getInt("POST_OPTION"));
                post.setMemberName(rs.getString("MEMBER_NAME"));
                post.setRegDate(rs.getString("REG_DATE"));
                
                // 체크리스트인 경우 체크 상태도 가져옴
                if(post.getPostOption() == 2) {
                    post.setPostCheck(rs.getInt("POST_CHECK") == 1);
                }
                
                postList.add(post);
            }
            
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        return postList;
    }
    
    /**
     * 주제별 게시글 목록 조회
     * @param conn
     * @param topic
     * @return 게시글 목록
     */
    public List<Post> selectPostsByTopic(Connection conn, int topic) throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String sql = prop.getProperty("postListByTopic");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, topic);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Post post = new Post();
                
                post.setPostNo(rs.getInt("POST_NO"));
                post.setPostTitle(rs.getString("POST_TITLE"));
                post.setPostTopic(rs.getInt("POST_TOPIC"));
                post.setPostOption(rs.getInt("POST_OPTION"));
                post.setMemberName(rs.getString("MEMBER_NAME"));
                post.setRegDate(rs.getString("REG_DATE"));
                
                if(post.getPostOption() == 2) {
                    post.setPostCheck(rs.getInt("POST_CHECK") == 1);
                }
                
                postList.add(post);
            }
            
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        return postList;
    }
    
    /**
     * 체크된 게시글 개수 조회
     * @param conn
     * @return 체크된 게시글 개수
     */
    public int getCheckedCount(Connection conn) throws SQLException {
        int count = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String sql = prop.getProperty("getCheckedCount");
            
            pstmt = conn.prepareStatement(sql);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                count = rs.getInt(1);
            }
            
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        return count;
    }
    
    /**
     * 게시글 추가
     * @param conn
     * @param post
     * @return 성공한 행의 개수
     */
    public int addPost(Connection conn, Post post) throws SQLException {
        int result = 0;
        PreparedStatement pstmt = null;
        
        try {
            String sql = prop.getProperty("postAdd");
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, post.getPostTitle());
            pstmt.setString(2, post.getPostContent());
            pstmt.setInt(3, post.getPostTopic());
            pstmt.setInt(4, post.getPostOption());

            result = pstmt.executeUpdate();
            
        } finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
    
    /**
     * 게시글 상세 조회
     * @param conn
     * @param postNo
     * @return 게시글 정보, 없으면 null
     */
    public Post selectPost(Connection conn, int postNo) throws SQLException {
        Post post = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String sql = prop.getProperty("postDetail");
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, postNo);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                post = new Post();
                
                post.setPostNo(rs.getInt("POST_NO"));
                post.setPostTitle(rs.getString("POST_TITLE"));
                post.setPostContent(rs.getString("POST_CONTENT"));
                post.setPostTopic(rs.getInt("POST_TOPIC"));
                post.setPostOption(rs.getInt("POST_OPTION"));
                post.setMemberName(rs.getString("MEMBER_NAME"));
                post.setRegDate(rs.getString("REG_DATE"));
                
                if(post.getPostOption() == 2) {
                    post.setPostCheck(rs.getInt("POST_CHECK") == 1);
                }
            }
            
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
        }
        
        return post;
    }
    
    /**
     * 체크 상태 변경
     * @param conn
     * @param postNo
     * @return 성공한 행의 개수
     */
    public int toggleCheck(Connection conn, int postNo) throws SQLException {
        int result = 0;
        PreparedStatement pstmt = null;
        
        try {
            String sql = prop.getProperty("toggleCheck");
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, postNo);
            
            result = pstmt.executeUpdate();
            
        } finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
    
    /**
     * 게시글 삭제
     * @param conn
     * @param postNo
     * @param memberNo
     * @return 성공한 행의 개수
     */
    public int deletePost(Connection conn, int postNo, int memberNo) throws SQLException {
        int result = 0;
        PreparedStatement pstmt = null;
        
        try {
            String sql = prop.getProperty("postDelete");
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, postNo);
            pstmt.setInt(2, memberNo);
            
            result = pstmt.executeUpdate();
            
        } finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
    
    /**
     * 게시글 수정
     * @param conn
     * @param post
     * @return 성공한 행의 개수
     */
    public int updatePost(Connection conn, Post post) throws SQLException {
        int result = 0;
        PreparedStatement pstmt = null;
        
        try {
            String sql = prop.getProperty("postUpdate");
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, post.getPostTitle());
            pstmt.setString(2, post.getPostContent());
            pstmt.setInt(3, post.getPostTopic());
            pstmt.setInt(4, post.getPostOption());
            pstmt.setInt(5, post.getPostNo());
            
            result = pstmt.executeUpdate();
            
        } finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
}