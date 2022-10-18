/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.JdialogOpciones;


import Vistas.VistaPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author edume
 */
public class ControladorPrincipal  implements ActionListener {
VistaPrincipal vista=new VistaPrincipal();
ControladorProduccion produccion;
    

    public ControladorPrincipal() {
        
        IniciarEventos();
        vista.setBackground(Color.cyan);
        vista.setVisible(true);
    }
    
    
   

    private void IniciarEventos() {
        vista.getjButton1().addActionListener((ActionListener) this);
        
       
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e.getActionCommand()=="INICIAR"){
           
          produccion =new ControladorProduccion(vista);
      }
    
}
}
