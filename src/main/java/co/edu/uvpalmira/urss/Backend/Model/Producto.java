package co.edu.uvpalmira.urss.Backend.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.FetchType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "producto") 
public class Producto {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) // Asegura que el ID se genere automáticamente
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private boolean stock; // Indica si el producto está en stock o no

    @Column(name = "image_url") 
    private String imageUrl;

    
    @ManyToOne(fetch = FetchType.LAZY) // LAZY para cargar la categoría solo cuando se necesita
    @JoinColumn(name = "category_id", nullable = false) // 'category_id' es el nombre de la FK en la tabla producto. 'nullable = false' si todo producto debe tener categoría.
    private Category category;
    
}
