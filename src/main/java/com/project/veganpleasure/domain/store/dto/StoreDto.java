package com.project.veganpleasure.domain.store.dto;

import com.project.veganpleasure.domain.store.entity.Category;
import com.project.veganpleasure.domain.store.entity.Store;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StoreDto {
    private Long id;
    private String name;
    private Category category;
    private List<String> vegetarianTypes;
    private String address;
    private int likes;
    private int reviewCount;
    private Long starRating;

    @Builder
    public StoreDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.category = store.getCategory();
        this.vegetarianTypes = store.getVegetarianTypeList();
        this.address = store.getAddress();
        this.likes = store.getLikes();
        this.reviewCount = store.getReviewList().size();
        this.starRating = store.getStarRating();
    }
}
