package co.edu.uvpalmira.urss.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uvpalmira.urss.Backend.BusinessLogic.CategoryService;
import co.edu.uvpalmira.urss.Backend.Model.Category;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    // deleteCategory ya no se podrá usar, se cambia por desactivateCategory
    /*
    @DeleteMapping("/deleteCategory/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    */
   
    @PutMapping("/desactivateCategory/{id}")
    public ResponseEntity<Category> desactivateCategory(@PathVariable Long id) {
        Category deactivatedCategory = categoryService.desactivateCategory(id);
        if (deactivatedCategory != null) {
            return ResponseEntity.ok(deactivatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateCategory/{id}")
    public Category updateCategory(@PathVariable("id") Long id, @RequestBody Category updatedCategory) {
        return categoryService.updateCategory(id, updatedCategory);
    }

    @GetMapping("/getAllCategories")
    public java.util.List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
