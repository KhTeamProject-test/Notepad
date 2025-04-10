package com.kh.notepad.model.dto;

public class Post {
    private int postNo;
    private String postTitle;
    private String postContent;
    private int postTopic;     // 0: 공지, 1: 개인, 2: 업무
    private int postOption;    // 0: 공개, 1: 비공개, 2: 체크리스트
    private boolean postCheck; // 체크 상태 (체크리스트인 경우만 사용)
    private String memberName; // 작성자 이름 (조회용)
    private String regDate;    // 등록일
    
    public Post() {}

    // 메인 목록 조회용 생성자
    public Post(int postNo, String postTitle, int postTopic, int postOption, boolean postCheck, String memberName, String regDate) {

        this.postNo = postNo;
        this.postTitle = postTitle;
        this.postTopic = postTopic;
        this.postOption = postOption;
        this.postCheck = postCheck;
        this.memberName = memberName;
        this.regDate = regDate;
    }

    // 상세 조회용 생성자
    public Post(int postNo, String postTitle, String postContent, int postTopic, int postOption, boolean postCheck, String memberName, String regDate) {
        this.postNo = postNo;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTopic = postTopic;
        this.postOption = postOption;
        this.postCheck = postCheck;
        this.memberName = memberName;
        this.regDate = regDate;
    }

    // Getters and Setters
    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getPostTopic() {
        return postTopic;
    }

    public void setPostTopic(int postTopic) {
        this.postTopic = postTopic;
    }

    public int getPostOption() {
        return postOption;
    }

    public void setPostOption(int postOption) {
        this.postOption = postOption;
    }

    public boolean isPostCheck() {
        return postCheck;
    }

    public void setPostCheck(boolean postCheck) {
        this.postCheck = postCheck;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Post [postNo=" + postNo + ", postTitle=" + postTitle + ", postContent=" + postContent + ", postTopic="
                + postTopic + ", postOption=" + postOption + ", postCheck=" + postCheck + ", memberName=" + memberName + ", regDate=" + regDate + "]";

    }
}