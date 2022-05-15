package com.project.veganpleasure.domain.store.entity;

import com.project.veganpleasure.domain.common.entity.BaseEntity;
import com.project.veganpleasure.domain.common.entity.UploadFile;
import com.project.veganpleasure.domain.common.entity.VegetarianType;
import com.project.veganpleasure.domain.review.entity.Review;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String address;
    @Enumerated(EnumType.STRING)
    private District district;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private VegetarianType vegetarianType;
    private int likes;
    private String menu;
    @OneToMany(mappedBy = "store")
    private List<Review> reviewList = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploadfile_id")
    private UploadFile uploadFile;

    @Builder
    public Store(String name, Category category, String address, District district, String phoneNumber, VegetarianType vegetarianType, int likes, List<Review> reviewList, String menu, UploadFile uploadFile) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.district = district;
        this.phoneNumber = phoneNumber;
        this.vegetarianType = vegetarianType;
        this.likes = likes;
        this.menu = menu;
        this.reviewList = reviewList;
        this.uploadFile = uploadFile;
    }
}
