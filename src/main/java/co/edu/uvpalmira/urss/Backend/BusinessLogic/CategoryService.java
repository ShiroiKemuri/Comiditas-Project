package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uvpalmira.urss.Backend.IRepository.CategoryRepo;
import co.edu.uvpalmira.urss.Backend.Model.Category;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public Category desactivateCategory(Long id) {
        return categoryRepo.findById(id).map(category -> {
            category.setActive(false);
            return categoryRepo.save(category);
        }).orElse(null);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        return categoryRepo.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            category.setDescription(updatedCategory.getDescription());
            return categoryRepo.save(category);
        }).orElse(null);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
