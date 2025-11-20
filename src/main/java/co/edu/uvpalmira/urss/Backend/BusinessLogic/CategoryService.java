package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uvpalmira.urss.Backend.IRepository.CategoryRepo;
import co.edu.uvpalmira.urss.Backend.Model.Category;
import java.util.List;


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

    // deleteCategory ya no se podrá usar, se cambia por desactivateCategory
    /*
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
    */

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

