// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpenyasrubielos.persistencia.models;


import interpenyasrubielos.persistencia.AbstractModel;
import interpenyasrubielos.persistencia.pojos.Ropa;
import interpenyasrubielos.persistencia.pojos.Socios;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aperalta
 */
public class RopaModel extends AbstractModel {

    public RopaModel() {
        super(Ropa.class);
    }

    @Override
    public ArrayList<Ropa> getLista() {
        this.cargarLista();
        return (ArrayList<Ropa>) super.getLista();
    }
    /*
    public ArrayList<Ropa> getRopaSocio(Socios so){
        
    }
   */
}
