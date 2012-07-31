// AutomatModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpenyasrubielos.persistencia.models;


import interpenyasrubielos.persistencia.AbstractModel;
import interpenyasrubielos.persistencia.pojos.Pedidos;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aperalta
 */
public class PedidosModel extends AbstractModel {

    public PedidosModel() {
        super(Pedidos.class);
    }

    @Override
    public ArrayList<Pedidos> getLista() {
        this.cargarLista();
        return (ArrayList<Pedidos>) super.getLista();
    }

   
}
