// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpenyasrubielos.persistencia.models;


import interpenyasrubielos.persistencia.AbstractModel;
import interpenyasrubielos.persistencia.pojos.Penyas;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aperalta
 */
public class PenyasModel extends AbstractModel {

    public PenyasModel() {
        super(Penyas.class);
    }

    @Override
    public ArrayList<Penyas> getLista() {
        this.cargarLista();
        return (ArrayList<Penyas>) super.getLista();
    }

   
}
