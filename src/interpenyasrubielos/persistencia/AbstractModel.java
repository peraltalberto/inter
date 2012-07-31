// AutomatAbstractModel
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpenyasrubielos.persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author aperalta
 * @version 1.0
 * Clase que genera un modelo de datos preparado para el acceso rapido a BBDD pudiendo generar consultas rapidamente
 */
public abstract class AbstractModel {

    private Class clase;
    private ArrayList<?> lista;
    
    public static SessionFactory factory;
    /**
     *
     * @param cl
     */
    public AbstractModel(Class cl) {
        this.clase = cl;
        this.lista = new ArrayList();    
        factory = TBSessionFactory.getInstance();
    }


    public ArrayList<?> cargarLista() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        this.lista = (ArrayList<?>) session.createCriteria(this.clase).list();
        System.out.println(this.lista.size());
        return this.lista;
    }
    public ArrayList<?> cargarLista(int offSet,int cantidad) {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        this.lista = (ArrayList<?>) session.createCriteria(this.clase)
                .setFirstResult(offSet).setMaxResults(cantidad).list();
        System.out.println(this.lista.size());
        return this.lista;
    }
    public void saveDato(Object dato) {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(dato);
        tx.commit();
        //cargarLista();
    }

   
    public void removeDato(Object dato) {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(dato);
        tx.commit();
        //cargarLista();
    }

    public void updateDato(Object dato) {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(dato);
        tx.commit();
        //cargarLista();
    }

    public Object busquedaDato(String porpName, Object Value) {

        Object result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        result = session.createCriteria(this.clase).add(Restrictions.eq(porpName, Value)).uniqueResult();
        return result;
    }
    public Object busquedaDato(Serializable s) {

        Object result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        result = session.get(this.clase,s);
        return result;
    }
  
public ArrayList<?> busquedaDatos(String porpName, Object Value) {

        ArrayList<?> result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        result = (ArrayList<?>) session.createCriteria(this.clase).add(Restrictions.eq(porpName, Value)).list();
        return result;
    }
    
  

    public Object lanzarSql(String sql, boolean unico) {
        Object result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        if (unico) {
            result = session.createSQLQuery(sql).addEntity(this.clase).uniqueResult();
        } else {
            result = session.createSQLQuery(sql).addEntity(this.clase).list();
        }
        return result;
    }

    public ArrayList<?> lanzarSql(String sql) {
        ArrayList<?> result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        result = (ArrayList<?>) session.createSQLQuery(sql).addEntity(this.clase).list();
        return result;
    }
    public ArrayList<?> lanzarHql(String hql) {
        ArrayList<?> result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        result = (ArrayList<?>) session.createQuery(hql).list();
        return result;
    }

    public Object lanzarHql(String hql,boolean unico) {
        Object result = null;
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        if(unico){
            result = session.createQuery(hql).uniqueResult();
        }else{
        result = (ArrayList<?>) session.createQuery(hql).list();
        }
        return result;
        
        }
   





    public ArrayList<?> getLista() {
        return lista;
    }

    public void setLista(ArrayList<?> lista) {
        this.lista = lista;
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        AbstractModel.factory = factory;
    }



  
    
    
}
