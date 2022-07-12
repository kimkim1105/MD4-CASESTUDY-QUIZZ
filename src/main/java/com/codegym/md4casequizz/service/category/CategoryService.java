package com.codegym.md4casequizz.service.category;

import com.codegym.md4casequizz.model.Category;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.repository.ICategoryRepository;
import com.codegym.md4casequizz.security.userprincal.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    UserDetailService userDetailService;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    //tim all category trong phan trang voi angular
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    public Page<Category> findAllByNameContaining(String name, Pageable pageable) {
        return categoryRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Category save(Category category) {
        User user=userDetailService.getCurrentUser();
        category.setUser(user);
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
