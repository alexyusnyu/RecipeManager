
package com.aldrin.foodfam.service;

import com.aldrin.foodfam.model.Recipe;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * @author ALDRIN
 */
@EnableJpaRepositories
@Repository
public interface RecipeService {
        List<Recipe> getTitleSortByKeyword(String name);
        Recipe findById(Integer id);

}
