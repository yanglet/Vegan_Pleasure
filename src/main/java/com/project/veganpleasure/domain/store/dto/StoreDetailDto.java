package com.project.veganpleasure.domain.store.dto;

import com.project.veganpleasure.domain.review.dto.ReviewDto;
import com.project.veganpleasure.domain.store.entity.Category;
import com.project.veganpleasure.domain.store.entity.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class StoreDetailDto {
    private Long id;
    private String name;
    private Category category;
    private List<String> vegetarianTypes;
    private String address;
    private Long starRating;
    private List<ReviewDto> reviewList = new ArrayList<>();

    @Builder
    public StoreDetailDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.category = store.getCategory();
        this.vegetarianTypes = store.getVegetarianTypeList();
        this.address = store.getAddress();
        this.starRating = store.getStarRating();
        this.reviewList = store.getReviewList()
                .stream()
                .map(r -> new ReviewDto(r))
                .collect(Collectors.toList());
    }
}
