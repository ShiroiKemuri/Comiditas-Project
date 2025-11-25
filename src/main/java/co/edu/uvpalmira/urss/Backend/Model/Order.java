package co.edu.uvpalmira.urss.Backend.Model;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders") // "order" es una palabra reservada en SQL, por eso usamos "orders"
public class Order {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @Column(name = "order_number") // número de orden
    private Long orderNumber;

    @Column(name = "customer_number", nullable = false)
    private String customerNumber; // número de cliente

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>(); // lista de ítems en la orden

    @Column(name = "total_to_pay")
    private BigDecimal totalToPay; // total a pagar

    @Column(name = "date")
    private LocalDate date; // fecha de la orden

    @Column(name = "time")
    private LocalTime time; // hora de la orden


}