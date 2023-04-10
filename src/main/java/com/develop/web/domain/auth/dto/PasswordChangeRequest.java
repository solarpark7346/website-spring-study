package com.develop.web.domain.auth.dto;

import lombok.Data;

@Data
public class PasswordChangeRequest {
    private String password;            // 패스워드
    private String changePassword;  // 패스워드 변경
}
