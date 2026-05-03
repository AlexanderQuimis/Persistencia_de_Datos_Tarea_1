package modelo;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String telefono;

    // 🔗 UNO A MUCHOS
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<CorteCarne> cortes;

    // getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<CorteCarne> getCortes() { return cortes; }
    public void setCortes(List<CorteCarne> cortes) { this.cortes = cortes; }
}