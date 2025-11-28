// En un nuevo archivo llamado SaleItem.java
package co.edu.uvpalmira.urss.Backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sale_items")
@Getter
@Setter
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muchos ítems pertenecen a una venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    // Muchos ítems pueden referenciar a un producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Producto product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double pricePerUnit; // Precio al momento de la venta
}
