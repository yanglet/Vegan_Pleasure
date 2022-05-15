package com.project.veganpleasure.domain.review.entity;

import com.project.veganpleasure.domain.common.entity.BaseEntity;
import com.project.veganpleasure.domain.common.entity.UploadFile;
import com.project.veganpleasure.domain.member.entity.Member;
import com.project.veganpleasure.domain.store.entity.Store;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;
    private String content;
    private Long starRating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Store store;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploadfile_id")
    private UploadFile uploadFile;

    @Builder
    public Review(String content, Long starRating, Store store, Member member, UploadFile uploadFile) {
        this.content = content;
        this.starRating = starRating;
        this.store = store;
        this.member = member;
        this.uploadFile = uploadFile;
    }
}
