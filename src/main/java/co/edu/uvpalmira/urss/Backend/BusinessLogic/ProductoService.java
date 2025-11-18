package co.edu.uvpalmira.urss.Backend.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uvpalmira.urss.Backend.IRepository.ProductoRepo;
import co.edu.uvpalmira.urss.Backend.Model.Producto;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepo productoRepo;

    public Producto createProducto(co.edu.uvpalmira.urss.Backend.Model.Producto producto) {
        return productoRepo.save(producto);
    }

    public Producto getProductoById(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    public Producto updateProducto(Long id, Producto updatedProducto) {
        return productoRepo.findById(id).map(producto -> {
           
            producto.setName(updatedProducto.getName());
            producto.setDescription(updatedProducto.getDescription());
            producto.setImage(updatedProducto.getImage());
            producto.setPrice(updatedProducto.getPrice());
            producto.setCategory(updatedProducto.getCategory());
            

            return productoRepo.save(producto);
        }).orElse(null);
    }
    public java.util.List<Producto> getAllProductos() {
        return productoRepo.findAll();
    }
}

