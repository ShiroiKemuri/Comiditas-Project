// En un nuevo archivo llamado Sale.java
package co.edu.uvpalmira.urss.Backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime saleDate;

    @Column(nullable = false)
    private double totalAmount;

    // Una venta tiene muchos ítems de venta
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> items;
}
