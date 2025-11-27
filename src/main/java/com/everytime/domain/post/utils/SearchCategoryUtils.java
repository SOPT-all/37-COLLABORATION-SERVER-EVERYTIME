package com.everytime.domain.post.utils;

import com.everytime.domain.post.domain.enums.Category;
import com.everytime.domain.post.domain.enums.SearchCategory;

import java.util.Arrays;
import java.util.List;

public class SearchCategoryUtils {

    private static final List<Category> ALLOWED_CATEGORIES =
            Arrays.stream(SearchCategory.values())
                    .filter(sc -> sc.getMappedCategory() != null)
                    .map(SearchCategory::getMappedCategory)
                    .toList();

    public static List<Category> allowedCategories() {
        return ALLOWED_CATEGORIES;
    }
}
