package entidad;

import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "peso", schema = "empaquetado", catalog = "")
public class PesoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_peso")
    private int idPeso;
    @Basic
    @Column(name = "peso_especifico")
    private int pesoEspecifico;
      @OneToMany(mappedBy = "pesoByIdPeso")
    private Collection<ProduccionEntity> produccionByIdPeso;

    public Collection<ProduccionEntity> getProduccionByIdPeso() {
        return produccionByIdPeso;
    }

    public void setProduccionByIdPeso(Collection<ProduccionEntity> produccionByIdPeso) {
        this.produccionByIdPeso = produccionByIdPeso;
    }
      

    public int getIdPeso() {
        return idPeso;
    }

    public void setIdPeso(int idPeso) {
        this.idPeso = idPeso;
    }

    public int getPesoEspecifico() {
        return pesoEspecifico;
    }

    public void setPesoEspecifico(int pesoEspecifico) {
        this.pesoEspecifico = pesoEspecifico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PesoEntity that = (PesoEntity) o;

        if (idPeso != that.idPeso) return false;
        if (pesoEspecifico != that.pesoEspecifico) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPeso;
        result = 31 * result + pesoEspecifico;
        return result;
    }
}
