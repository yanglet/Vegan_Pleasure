package com.project.veganpleasure.domain.member.entity;

import com.project.veganpleasure.domain.common.entity.BaseEntity;
import com.project.veganpleasure.domain.common.entity.VegetarianType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String role;
    @Enumerated(EnumType.STRING)
    private VegetarianType vegetarianType; // 한가지 고르는건지??

    @Builder
    public Member(String email, String password, String name, String nickname, String role, VegetarianType vegetarianType) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.role = role;
        this.vegetarianType = vegetarianType;
    }
}
