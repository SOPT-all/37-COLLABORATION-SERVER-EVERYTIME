package com.everytime.domain.post.utils;

import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.domain.enums.SearchCategory;

import java.util.Arrays;
import java.util.List;

public class SearchCategoryUtils {

    // ALL 검색 시 포함해야 할 8개 Category 목록
    public static List<Category> allowedCategories() {
        return Arrays.stream(SearchCategory.values())
                .filter(sc -> sc.getMappedCategory() != null)
                .map(SearchCategory::getMappedCategory)
                .toList();
    }
}
