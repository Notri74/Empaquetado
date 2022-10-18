package entidad;

import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "calidad", schema = "empaquetado", catalog = "")
public class CalidadEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_calidad")
    private int idCalidad;
    @Basic
    @Column(name = "tipo_calidad")
    private String tipoCalidad;
        
    @OneToMany(mappedBy = "calidadByIdCalidad")
    private Collection<ProduccionEntity> produccionByIdCalidad;

    public Collection<ProduccionEntity> getProduccionByIdCalidad() {
        return produccionByIdCalidad;
    }

    public void setProduccionByIdCalidad(Collection<ProduccionEntity> produccionByIdCalidad) {
        this.produccionByIdCalidad = produccionByIdCalidad;
    }
    

    public int getIdCalidad() {
        return idCalidad;
    }

    public void setIdCalidad(int idCalidad) {
        this.idCalidad = idCalidad;
    }

    public String getTipoCalidad() {
        return tipoCalidad;
    }

    public void setTipoCalidad(String tipoCalidad) {
        this.tipoCalidad = tipoCalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalidadEntity that = (CalidadEntity) o;

        if (idCalidad != that.idCalidad) return false;
        if (tipoCalidad != null ? !tipoCalidad.equals(that.tipoCalidad) : that.tipoCalidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCalidad;
        result = 31 * result + (tipoCalidad != null ? tipoCalidad.hashCode() : 0);
        return result;
    }
}
