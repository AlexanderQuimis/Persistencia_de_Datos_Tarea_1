package modelo;
import modelo.Proveedor;
import jakarta.persistence.*;
// indica que esta clase es una tabla en la base de datos
@Entity
// define el nombre de la tabla
@Table(name = "corte_carne")
public class CorteCarne {
// indica la clave primaria
    @Id
    // Generación automática del ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int gramaje;
    private double precio;
    private String termino;
    
     // 🔗 RELACIÓN MUCHOS A UNO
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    public Proveedor getProveedor() {
    return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    // GETTERS Y SETTERS

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getGramaje() { return gramaje; }
    public void setGramaje(int gramaje) { this.gramaje = gramaje; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getTermino() { return termino; }
    public void setTermino(String termino) { this.termino = termino; }
}