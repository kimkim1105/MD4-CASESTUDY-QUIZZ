package com.codegym.md4casequizz.service.category;

import com.codegym.md4casequizz.model.Category;
import com.codegym.md4casequizz.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGeneralService<Category> {
    Page<Category> findAll(Pageable pageable);
    Category save(Category category);
    Boolean existsByName(String name);
}
