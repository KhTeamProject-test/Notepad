package com.kh.notepad.model.dto;

import java.sql.Date;

public class Member {
    private String memberId;
    private String memberPw;
    private String memberName;
    private Date enrollDate;
    
    public Member() {}
    public Member(String memberId, String memberPw, String memberName, Date enrollDate) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.enrollDate = enrollDate;
    }
    
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="

                + memberName + ", enrollDate=" + enrollDate + "]";
    }
}