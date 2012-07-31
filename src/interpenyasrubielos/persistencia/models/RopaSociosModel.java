// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpenyasrubielos.persistencia.models;


import interpenyasrubielos.persistencia.AbstractModel;
import interpenyasrubielos.persistencia.pojos.RopaSocios;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aperalta
 */
public class RopaSociosModel extends AbstractModel {

    public RopaSociosModel() {
        super(RopaSocios.class);
    }

    @Override
    public ArrayList<RopaSocios> getLista() {
        this.cargarLista();
        return (ArrayList<RopaSocios>) super.getLista();
    }

   
}
