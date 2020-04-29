package br.com.baronheid.gradlespringbootstudies.model.service;

import br.com.baronheid.gradlespringbootstudies.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryWebService {

    private CategoryRepository categoryRepository;

    public CategoryWebService(@Autowired final CategoryRepository categoryReposirtory) {
        this.categoryRepository = categoryRepository;
    }

    public Object findAll() {
        return categoryRepository.findAll();
    }
}
