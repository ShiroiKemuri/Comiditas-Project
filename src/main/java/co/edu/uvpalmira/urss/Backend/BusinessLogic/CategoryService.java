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

    public Category createCategory(co.edu.uvpalmira.urss.Backend.Model.Category category) {
        return categoryRepo.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        return categoryRepo.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            category.setDescription(updatedCategory.getDescription());
            return categoryRepo.save(category);
        }).orElse(null);
    }
}
