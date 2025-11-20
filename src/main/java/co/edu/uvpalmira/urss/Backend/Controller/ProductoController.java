package co.edu.uvpalmira.urss.Backend.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uvpalmira.urss.Backend.BusinessLogic.ProductoService;
import co.edu.uvpalmira.urss.Backend.Model.Producto;


@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/createProducto")
    public Producto createProducto(@RequestBody Producto producto) {

        Long categoryId = extractCategoryId(producto);

        return productoService.createProducto(producto, categoryId);
    }

    @GetMapping("/getProductoById/{id}")
    public Producto getProductoById(@PathVariable("id") Long id) {
        return productoService.getProductoById(id);
    }

    @DeleteMapping("/deleteProducto/{id}")
    public void deleteProducto(@PathVariable("id") Long id) {
        productoService.deleteProducto(id);
    }

    @PutMapping("/updateProducto/{id}")
    public Producto updateProducto(@PathVariable("id") Long id, @RequestBody Producto updatedProducto) {

        Long categoryId = extractCategoryId(updatedProducto);

        return productoService.updateProducto(id, updatedProducto, categoryId);
    }

    @GetMapping("/getAllProductos")
    public java.util.List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    private Long extractCategoryId(Producto producto) {
        if (producto.getCategory() == null) {
            // Lanza una excepción clara si el payload JSON está incompleto
            throw new IllegalArgumentException("El ID de la categoría es requerido y debe ser incluido en la solicitud.");
        }
        return producto.getCategory().getId();
    }
}