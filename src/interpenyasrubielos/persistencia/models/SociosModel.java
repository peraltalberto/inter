// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpenyasrubielos.persistencia.models;


import interpenyasrubielos.persistencia.AbstractModel;
import interpenyasrubielos.persistencia.pojos.Socios;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aperalta
 */
public class SociosModel extends AbstractModel {

    public SociosModel() {
        super(Socios.class);
    }

    @Override
    public ArrayList<Socios> getLista() {
        this.cargarLista();
        return (ArrayList<Socios>) super.getLista();
    }

   
}
