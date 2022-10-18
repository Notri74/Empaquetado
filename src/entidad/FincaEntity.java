package entidad;

import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "finca", schema = "empaquetado", catalog = "")
public class FincaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_finca")
    private int idFinca;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "municipio")
    private String municipio;
      @OneToMany(mappedBy = "fincaByIdFinca")
    private Collection<ProduccionEntity> produccionByIdFinca;

    public Collection<ProduccionEntity> getProduccionByIdFinca() {
        return produccionByIdFinca;
    }

    public void setProduccionByIdFinca(Collection<ProduccionEntity> produccionByIdFinca) {
        this.produccionByIdFinca = produccionByIdFinca;
    }
      

    public int getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(int idFinca) {
        this.idFinca = idFinca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FincaEntity that = (FincaEntity) o;

        if (idFinca != that.idFinca) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (municipio != null ? !municipio.equals(that.municipio) : that.municipio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFinca;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (municipio != null ? municipio.hashCode() : 0);
        return result;
    }
}
