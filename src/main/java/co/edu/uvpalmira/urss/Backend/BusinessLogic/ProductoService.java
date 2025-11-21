package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import org.springframework.web.server.ResponseStatusException;
import co.edu.uvpalmira.urss.Backend.IRepository.ProductoRepo;
import co.edu.uvpalmira.urss.Backend.Model.Producto;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepo productoRepo;

    public Producto createProducto(Producto producto) {
        producto.setFechaCreacion(LocalDateTime.now());
        return productoRepo.save(producto);
    }

    public Producto getProductoById(Long id) {
        return productoRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado con id: " + id));
    }

    public void deleteProducto(Long id) {
        if (!productoRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede eliminar. Producto no encontrado con id: " + id);
        }
        productoRepo.deleteById(id);
    }

    public Producto updateProducto(Long id, Producto updatedProducto) {
        return productoRepo.findById(id).map(producto -> {
            producto.setName(updatedProducto.getName());
            producto.setDescription(updatedProducto.getDescription());
            producto.setImage(updatedProducto.getImage());
            producto.setPrice(updatedProducto.getPrice());
            producto.setCategory(updatedProducto.getCategory()); // Asignar la categoría actualizada
            return productoRepo.save(producto);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede actualizar. Producto no encontrado con id: " + id));
    }

    public List<Producto> getAllProductos() {
        return productoRepo.findAll();
    }
}
