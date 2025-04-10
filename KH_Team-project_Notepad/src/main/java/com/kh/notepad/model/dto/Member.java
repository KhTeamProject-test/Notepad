package com.kh.notepad.model.dto;

import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String memberId;
    private String memberPw;
    private String memberName;
    private Date enrollDate;
}
