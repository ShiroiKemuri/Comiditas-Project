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
@RequestMapping("/product")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/createProduct")
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @GetMapping("/getProductById/{id}")
    public Producto getProductoById(@PathVariable("id") Long id) {
        return productoService.getProductoById(id);
    }

    @DeleteMapping("/deleteProducto/{id}")
    public void deleteProducto(@PathVariable("id") Long id) {
        productoService.deleteProducto(id);
    }

    @PutMapping("/updateProduct/{id}")
    public Producto updateProducto(@PathVariable("id") Long id, @RequestBody Producto updatedProducto) {
        return productoService.updateProducto(id, updatedProducto);
    }
    @GetMapping("/getAllProductos")
    public java.util.List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

}

