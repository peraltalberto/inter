/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpenyasrubielos;

import interpenyasrubielos.persistencia.models.*;

/**
 *
 * @author aperalta
 */
public class InterpenyasRubielos {

    /**
     * @param args the command line arguments
     */
    

      public static  SociosModel sm=new SociosModel();
    public static  PedidosModel pm = new PedidosModel();
    public static  PenyasModel pym= new PenyasModel();
    public static  RopaModel rm= new RopaModel();
    public static  RopaSociosModel rsm = new RopaSociosModel();
    public static void main(String[] args) {
        
        new VentanaPrincipal().setVisible(true);
        
    }
}
