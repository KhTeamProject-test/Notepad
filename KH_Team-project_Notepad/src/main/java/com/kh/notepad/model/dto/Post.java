package com.kh.notepad.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Post {
    private int postNo;
    private String postTitle;
    private String postContent;
    private int postTopic;     // 0: 공지, 1: 개인, 2: 업무
    private int postOption;    // 0: 공개, 1: 비공개, 2: 체크리스트
    private boolean postCheck;
    private String memberId;
    private String regDate;

    // 메인 목록 조회용 생성자
    public Post(int postNo, String postTitle, int postTopic, int postOption, boolean postCheck, String memberId, String regDate) {
        this.postNo = postNo;
        this.postTitle = postTitle;
        this.postTopic = postTopic;
        this.postOption = postOption;
        this.postCheck = postCheck;
        this.memberId = memberId;
        this.regDate = regDate;
    }

    // 상세 조회용 생성자
    public Post(int postNo, String postTitle, String postContent, int postTopic, int postOption, boolean postCheck, String memberId, String regDate) {
        this.postNo = postNo;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTopic = postTopic;
        this.postOption = postOption;
        this.postCheck = postCheck;
        this.memberId = memberId;
        this.regDate = regDate;
    }
}
