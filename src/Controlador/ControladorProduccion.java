/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dto.DtoProduccion;
import Vistas.JdialogOpciones;
import dao.ProduccionDAO;
import entidad.ProduccionEntity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edume
 */
public class ControladorProduccion implements ActionListener {

    int id_produccion, mes, anio, numero_cajas, id_almacen, id_calidad, id_finca, id_peso;
    DtoProduccion dtoproduccion;
    JdialogOpciones opciones;
    ProduccionEntity datosproduccion = new ProduccionEntity();
    ProduccionDAO produccionDao = new ProduccionDAO();

    public ControladorProduccion(java.awt.Frame parent) {

        //  dtoproduccion new DtoProduccion();
        opciones = new JdialogOpciones(parent, true);

        iniciarEventos();
        presentarTabla();
        opciones.setVisible(true);
        ;

    }

    public void iniciarEventos() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        opciones.getjButtonInsertar().addActionListener((ActionListener) this);
        opciones.getjButtonBorrar().addActionListener((ActionListener) this);
        opciones.getjButtonBuscar().addActionListener((ActionListener) this);
        opciones.getjButtonModificar().addActionListener((ActionListener) this);
        opciones.getjButtonAlmacenes().addActionListener((ActionListener) this);
        opciones.getjButtonFincas().addActionListener((ActionListener) this);

    }

    public void recogerCampos() {

    }

    //public static List<Produccion> mostrarProduccion(){}
    @Override
    public void actionPerformed(ActionEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        if (e.getActionCommand() == "INSERTAR") {

            System.out.println("insertar");
            insertar();
        }

        if (e.getActionCommand() == "BORRAR") {

            borrar();
        }

        if (e.getActionCommand() == "BUSCAR") {
            buscar();
        }
        if (e.getActionCommand() == "MODIFICAR") {
            modificar();
        }

        if (e.getActionCommand() == "Almacenes") {
            almacenes();
        }
        if (e.getActionCommand() == "Fincas") {
            fincas();

        }
    }

    private void insertar() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
          
               mes = Integer.parseInt(opciones.getjTextFieldMes().getText());
         
            anio = Integer.parseInt(opciones.getjTextFieldAnio().getText());
            numero_cajas = Integer.parseInt(opciones.getjTextFieldCajas().getText());

            datosproduccion.setMes(Integer.parseInt(opciones.getjTextFieldMes().getText()));
            datosproduccion.setAnio(Integer.parseInt(opciones.getjTextFieldAnio().getText()));
            datosproduccion.setNumeroCajas(Integer.parseInt(opciones.getjTextFieldCajas().getText()));

            produccionDao.setIndiceAlmacen(Integer.parseInt(opciones.getjTextFieldAlmacen().getText()));

            if (Integer.parseInt(opciones.getjTextFieldCalidad().getText()) == 1 || Integer.parseInt(opciones.getjTextFieldCalidad().getText()) == 2) {
                produccionDao.setIndiceCalidad(Integer.parseInt(opciones.getjTextFieldCalidad().getText()));
            } else {
                JOptionPane.showMessageDialog(opciones, "Las calidades tienen que ser 1 o 2");
            }

            produccionDao.setIndiceFinca(Integer.parseInt(opciones.getjTextFieldFinca().getText()));

            if (Integer.parseInt(opciones.getjTextFieldPeso().getText()) == 10 || Integer.parseInt(opciones.getjTextFieldPeso().getText()) == 13) {
                produccionDao.setIndicePeso(Integer.parseInt(opciones.getjTextFieldPeso().getText()));
            } else {
                JOptionPane.showMessageDialog(opciones, "Los pesos tienen que ser igual a 10 o 13");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(opciones, "Datos mal introducidos");
        }

        produccionDao.insertarProduccion(datosproduccion);
        presentarTabla();
    }

    private void borrar() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        produccionDao = new ProduccionDAO();
        int id_prduccion = Integer.parseInt(JOptionPane.showInputDialog("Inserte el número de identificador a borrar"));
        produccionDao.borrarProduccion(id_prduccion);
        presentarTabla();
    }

    private void buscar() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //  produccionDao = new ProduccionDAO();
        int id_prduccion = Integer.parseInt(JOptionPane.showInputDialog("Inserte el número de identificador a buscar"));
        //  produccionDao.getProduccionById(id_prduccion);
        presentarProduccion(produccionDao.getProduccionById(id_prduccion));
        System.out.println("controlador  " + produccionDao.getProduccionById(id_prduccion));

    }

    private ProduccionEntity presentarProduccion(ProduccionEntity producto) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ProduccionEntity> listado = produccionDao.getAllproduccion();
        for (ProduccionEntity produccionEntity : listado) {

            opciones.getjTextFieldProduccion().setText(producto.getIdProduccion() + "");
            opciones.getjTextFieldMes().setText(producto.getMes() + "");
            opciones.getjTextFieldAnio().setText(producto.getAnio() + "");
            opciones.getjTextFieldCajas().setText(producto.getNumeroCajas() + "");
            opciones.getjTextFieldAlmacen().setText(producto.getAlmacenByIdAlmacen().getId() + "");
            opciones.getjTextFieldCalidad().setText(producto.getCalidadByIdCalidad().getIdCalidad() + "");
            opciones.getjTextFieldFinca().setText(producto.getFincaByIdFinca().getIdFinca() + "");
            opciones.getjTextFieldPeso().setText(producto.getPesoByIdPeso().getIdPeso() + "");
            /*,
                ,
                ,
             */

        }
        return producto;
    }

    private void modificar() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
          
               mes = Integer.parseInt(opciones.getjTextFieldMes().getText());

            anio = Integer.parseInt(opciones.getjTextFieldAnio().getText());
            numero_cajas = Integer.parseInt(opciones.getjTextFieldCajas().getText());

            datosproduccion.setMes(Integer.parseInt(opciones.getjTextFieldMes().getText()));
            datosproduccion.setAnio(Integer.parseInt(opciones.getjTextFieldAnio().getText()));
            datosproduccion.setNumeroCajas(Integer.parseInt(opciones.getjTextFieldCajas().getText()));
            datosproduccion.setIdProduccion(Integer.parseInt(opciones.getjTextFieldProduccion().getText()));
            produccionDao.setIndiceAlmacen(Integer.parseInt(opciones.getjTextFieldAlmacen().getText()));

            // produccionDao.setIndiceCalidad(Integer.parseInt(opciones.getjTextFieldCalidad().getText()));
            if (Integer.parseInt(opciones.getjTextFieldCalidad().getText()) == 1 || Integer.parseInt(opciones.getjTextFieldCalidad().getText()) == 2) {
                produccionDao.setIndiceCalidad(Integer.parseInt(opciones.getjTextFieldCalidad().getText()));
            } else {
                JOptionPane.showMessageDialog(opciones, "Las calidades tienen que ser 1 o 2");
            }

            if (Integer.parseInt(opciones.getjTextFieldPeso().getText()) == 10 || Integer.parseInt(opciones.getjTextFieldPeso().getText()) == 13) {
                produccionDao.setIndicePeso(Integer.parseInt(opciones.getjTextFieldPeso().getText()));
            } else {
                JOptionPane.showMessageDialog(opciones, "Los pesos tienen que ser igual a 10 o 13");
            }
            produccionDao.setIndiceFinca(Integer.parseInt(opciones.getjTextFieldFinca().getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(opciones, "Datos mal introducidos");
        }
        // produccionDao.setIndicePeso(Integer.parseInt(opciones.getjTextFieldPeso().getText()));
        produccionDao.modificarProduccion(datosproduccion);
        presentarTabla();
    }

    private void almacenes() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(opciones, "1. Martimar \n2. Costa Caleta");

    }

    private void fincas() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(opciones, "1. Pilotín\n2. Barahona\n3. Buenavista\n4. San Andrés");

    }

    public void presentarTabla() {
        DefaultTableModel tablita = new DefaultTableModel(null, new Object[]{"ID PRODUCCION", "SEMANA", "AÑO", "NUM CAJAS", "ID ALMACEN", "CALIDAD", "ID FINCA", "PESO"});
        List<ProduccionEntity> listado = produccionDao.getAllproduccion();
        for (ProduccionEntity produccionEntity : listado) {
            tablita.addRow(new Object[]{
                produccionEntity.getIdProduccion(),
                produccionEntity.getMes(),
                produccionEntity.getAnio(),
                produccionEntity.getNumeroCajas(),
                produccionEntity.getAlmacenByIdAlmacen().getId(),
                produccionEntity.getCalidadByIdCalidad().getIdCalidad(),
                produccionEntity.getFincaByIdFinca().getIdFinca(),
                produccionEntity.getPesoByIdPeso().getIdPeso()
            });
        }
        opciones.getjTable1().setModel(tablita);

    }

}
