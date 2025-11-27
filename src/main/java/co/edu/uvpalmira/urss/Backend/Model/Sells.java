package co.edu.uvpalmira.urss.Backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Ventas")
public class Sells {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "id_Sell")
    private Long id_Sell;

    @Column(name = "Date")
    private String date;

    @Column(name = "Total_Amount")
    private double totalAmount;

    @Column(name = "Product")
    private Producto products;

    @Column(name = "Quantity")
    private int quantity;

}
