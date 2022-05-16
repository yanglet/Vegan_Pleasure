package com.project.veganpleasure.domain.member.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  private Long id;
 *     @Column(unique = true)
 *     private String email;
 *     private String password;
 *     private String name;
 *     private String nickname;
 *     private String role;
 *     private String vegetarianTypes;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberJoinRequest {
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String role;
    private String vegetarianTypes;
}
