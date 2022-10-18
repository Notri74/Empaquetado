/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.AlmacenEntity;
import entidad.CalidadEntity;
import entidad.FincaEntity;
import entidad.PesoEntity;
import entidad.ProduccionEntity;
import hibernate.util.HibernateUtil;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author edume
 */
public class ProduccionDAO {

    int indiceCalidad = 0;
    int indicePeso = 0;
    int indiceAlmacen = 0;
    int indiceFinca = 0;
    Transaction transaction = null;
    SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(ProduccionEntity.class)
            .addAnnotatedClass(CalidadEntity.class)
            .addAnnotatedClass(FincaEntity.class)
            .addAnnotatedClass(PesoEntity.class)
            .addAnnotatedClass(AlmacenEntity.class)
            .buildSessionFactory();
    Session miSession = miFactory.openSession();

    public void borrarProduccion(int idProduccion) {
        Transaction transaction = null;
        ProduccionEntity produccion = null;
        List<ProduccionEntity> producciones = null;

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            produccion = session.get(ProduccionEntity.class, idProduccion);

            session.delete(produccion);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    public void insertarProduccion(entidad.ProduccionEntity produccion) {
        Transaction tx = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction(); //Crea una transacción
        // ProduccionEntity a = new ProduccionEntity();                    
        AlmacenEntity almacen = miSession.get(AlmacenEntity.class, indiceAlmacen);
        CalidadEntity calidad = miSession.get(CalidadEntity.class, indiceCalidad);
        FincaEntity finca = miSession.get(FincaEntity.class, indiceFinca);
        PesoEntity peso = miSession.get(PesoEntity.class, indicePeso);

        produccion.setAlmacenByIdAlmacen(almacen);
        produccion.setCalidadByIdCalidad(calidad);
        produccion.setFincaByIdFinca(finca);
        produccion.setPesoByIdPeso(peso);

        session.save(produccion);
        tx.commit();
        session.close();

    }
      public void modificarProduccion(entidad.ProduccionEntity produccion) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           Transaction tx = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction(); //Crea una transacción
        // ProduccionEntity a = new ProduccionEntity();                    
        AlmacenEntity almacen = miSession.get(AlmacenEntity.class, indiceAlmacen);
        CalidadEntity calidad = miSession.get(CalidadEntity.class, indiceCalidad);
        FincaEntity finca = miSession.get(FincaEntity.class, indiceFinca);
        PesoEntity peso = miSession.get(PesoEntity.class, indicePeso);

        produccion.setAlmacenByIdAlmacen(almacen);
        produccion.setCalidadByIdCalidad(calidad);
        produccion.setFincaByIdFinca(finca);
        produccion.setPesoByIdPeso(peso);

        session.merge(produccion);
        tx.commit();
        session.close();
      }


    public List<ProduccionEntity> getAllproduccion() {
        Transaction transaction = null;
        List<ProduccionEntity> producciones = null;

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            producciones = session.createQuery("from ProduccionEntity").list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return producciones;
    }

    public ProduccionEntity getProduccionById(int id_prduccion) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Transaction transaction = null;
        ProduccionEntity produccion = null;

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            produccion = session.get(ProduccionEntity.class, id_prduccion);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        System.out.println("DAO"+produccion.getIdProduccion());
        return produccion;
    }

    public int getIndiceCalidad() {
        return indiceCalidad;
    }

    public void setIndiceCalidad(int indiceCalidad) {
        this.indiceCalidad = indiceCalidad;
    }

    public int getIndicePeso() {
        return indicePeso;
    }

    public void setIndicePeso(int indicePeso) {
        this.indicePeso = indicePeso;
    }

    public int getIndiceAlmacen() {
        return indiceAlmacen;
    }

    public void setIndiceAlmacen(int indiceAlmacen) {
        this.indiceAlmacen = indiceAlmacen;
    }

    public int getIndiceFinca() {
        return indiceFinca;
    }

    public void setIndiceFinca(int indiceFinca) {
        this.indiceFinca = indiceFinca;
    }

  
}
