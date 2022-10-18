package entidad;

import javax.persistence.*;

@Entity
@Table(name = "produccion", schema = "empaquetado", catalog = "")
public class ProduccionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_produccion")
    private int idProduccion;
    @Basic
    @Column(name = "mes")
    private int mes;
    @Basic
    @Column(name = "anio")
    private int anio;
    @Basic
    @Column(name = "numero_cajas")
    private int numeroCajas;
    /*@Basic
    @Column(name = "id_almacen")
    private int idAlmacen;
    @Basic
    @Column(name = "id_calidad")
    private int idCalidad;
    @Basic
    @Column(name = "id_finca")
    private int idFinca;
    @Basic
    @Column(name = "id_peso")
    private int idPeso;*/
    @ManyToOne
    @JoinColumn(name = "id_almacen", referencedColumnName = "id", nullable = false)
    private AlmacenEntity almacenByIdAlmacen;
    @ManyToOne
    @JoinColumn(name = "id_calidad", referencedColumnName = "id_calidad", nullable = false)
    private CalidadEntity calidadByIdCalidad;
    @ManyToOne
    @JoinColumn(name = "id_finca", referencedColumnName = "id_finca", nullable = false)
    private FincaEntity fincaByIdFinca;
    @ManyToOne
    @JoinColumn(name = "id_peso", referencedColumnName = "id_peso", nullable = false)
    private PesoEntity pesoByIdPeso;

    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getNumeroCajas() {
        return numeroCajas;
    }

    public void setNumeroCajas(int numeroCajas) {
        this.numeroCajas = numeroCajas;
    }
//
//    public int getIdAlmacen() {
//        return idAlmacen;
//    }
//
//    public void setIdAlmacen(int idAlmacen) {
//        this.idAlmacen = idAlmacen;
//    }
//
//    public int getIdCalidad() {
//        return idCalidad;
//    }
//
//    public void setIdCalidad(int idCalidad) {
//        this.idCalidad = idCalidad;
//    }
//
//    public int getIdFinca() {
//        return idFinca;
//    }
//
//    public void setIdFinca(int idFinca) {
//        this.idFinca = idFinca;
//    }
//
//    public int getIdPeso() {
//        return idPeso;
//    }
//
//    public void setIdPeso(int idPeso) {
//        this.idPeso = idPeso;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProduccionEntity that = (ProduccionEntity) o;

        if (idProduccion != that.idProduccion) return false;
        if (mes != that.mes) return false;
        if (anio != that.anio) return false;
        if (numeroCajas != that.numeroCajas) return false;
//        if (idAlmacen != that.idAlmacen) return false;
////        if (idCalidad != that.idCalidad) return false;
////        if (idFinca != that.idFinca) return false;
////        if (idPeso != that.idPeso) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduccion;
        result = 31 * result + mes;
        result = 31 * result + anio;
        result = 31 * result + numeroCajas;
//        result = 31 * result + idAlmacen;
//        result = 31 * result + idCalidad;
//        result = 31 * result + idFinca;
//        result = 31 * result + idPeso;
        return result;
    }

    public AlmacenEntity getAlmacenByIdAlmacen() {
        return almacenByIdAlmacen;
    }

    public void setAlmacenByIdAlmacen(AlmacenEntity almacenByIdAlmacen) {
        this.almacenByIdAlmacen = almacenByIdAlmacen;
    }

    public CalidadEntity getCalidadByIdCalidad() {
        return calidadByIdCalidad;
    }

    public void setCalidadByIdCalidad(CalidadEntity calidadByIdCalidad) {
        this.calidadByIdCalidad = calidadByIdCalidad;
    }

    public FincaEntity getFincaByIdFinca() {
        return fincaByIdFinca;
    }

    public void setFincaByIdFinca(FincaEntity fincaByIdFinca) {
        this.fincaByIdFinca = fincaByIdFinca;
    }

    public PesoEntity getPesoByIdPeso() {
        return pesoByIdPeso;
    }

    public void setPesoByIdPeso(PesoEntity pesoByIdPeso) {
        this.pesoByIdPeso = pesoByIdPeso;
    }
}
