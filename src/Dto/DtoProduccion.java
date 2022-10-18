/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author edume
 */
public class DtoProduccion {
    int id_produccion,mes,anio,numero_cajas,id_almacen,id_calidad,id_finca,id_peso;

    public DtoProduccion(int id_produccion, int mes, int anio, int numero_cajas,int id_calidad, int id_almacen, int id_finca, int id_peso) {
        this.id_produccion = id_produccion;
        this.mes = mes;
        this.anio = anio;
        this.numero_cajas = numero_cajas;
        this.id_calidad= id_calidad;
        this.id_almacen = id_almacen;
        
        this.id_finca = id_finca;
        this.id_peso = id_peso;
    }



    public int getId_produccion() {
        return id_produccion;
    }

    public void setId_produccion(int id_produccion) {
        this.id_produccion = id_produccion;
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

    public int getNumero_cajas() {
        return numero_cajas;
    }

    public void setNumero_cajas(int numero_cajas) {
        this.numero_cajas = numero_cajas;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public int getId_calidad() {
        return id_calidad;
    }

    public void setId_calidad(int id_calidad) {
        this.id_calidad = id_calidad;
    }

    public int getId_finca() {
        return id_finca;
    }

    public void setId_finca(int id_finca) {
        this.id_finca = id_finca;
    }

    public int getId_peso() {
        return id_peso;
    }

    public void setId_peso(int id_peso) {
        this.id_peso = id_peso;
    }
    
    
}
