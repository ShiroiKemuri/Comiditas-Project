package co.edu.uvpalmira.urss.Backend.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uvpalmira.urss.Backend.IRepository.ProductoRepo;
import co.edu.uvpalmira.urss.Backend.Exceptions.CategoryNotFoundException;
import co.edu.uvpalmira.urss.Backend.IRepository.CategoryRepo;
import co.edu.uvpalmira.urss.Backend.Model.Category;
import co.edu.uvpalmira.urss.Backend.Model.Producto;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service

public class ProductoService {
    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private CategoryRepo categoryRepo; // Repositorio para manejar categorías

    public Producto createProducto(Producto producto, Long categoryId) {
        // Buscar y Validar la Categoría
        Category category = categoryRepo.findById(categoryId)

            .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        // Asignar la Categoría al Producto
        producto.setCategory(category);
      
        // Guardar el Producto
        return productoRepo.save(producto);
    }

    public Producto getProductoById(Long id) {
        return productoRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Producto con ID " + id + " no encontrado"));
    }


    public Producto updateProducto(Long id, Producto updatedProducto, Long categoryId) {

        // 1. Verificar si el Producto existe
        Producto existingProducto = productoRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Producto con ID " + id + " no encontrado"));

        // 2. Si se proporciona un nuevo categoryId, buscar y validar la Categoría
        if (categoryId != null) {
            Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

            existingProducto.setCategory(category);
        }

        // 3. Actualizar otros campos
        existingProducto.setName(updatedProducto.getName());
        existingProducto.setDescription(updatedProducto.getDescription());
        existingProducto.setPrice(updatedProducto.getPrice());
        existingProducto.setStock(updatedProducto.isStock());
        existingProducto.setImage(updatedProducto.getImage());

        // 4. Guardar la entidad actualizada
        return productoRepo.save(existingProducto);
    } 

    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    public List<Producto> getAllProductos() {
        return productoRepo.findAll();
    }
}