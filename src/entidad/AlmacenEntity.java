package entidad;

import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "almacen", schema = "empaquetado", catalog = "")
public class AlmacenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "almacenByIdAlmacen")
    private Collection<ProduccionEntity> produccionByIdAlmacen;
    
    

    public Collection<ProduccionEntity> getProduccionByIdAlmacen() {
        return produccionByIdAlmacen;
    }

    public void setProduccionByIdAlmacen(Collection<ProduccionEntity> produccionByIdAlmacen) {
        this.produccionByIdAlmacen = produccionByIdAlmacen;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlmacenEntity that = (AlmacenEntity) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
