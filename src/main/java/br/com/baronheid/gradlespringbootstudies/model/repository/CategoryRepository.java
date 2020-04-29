package br.com.baronheid.gradlespringbootstudies.model.repository;

import br.com.baronheid.gradlespringbootstudies.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
