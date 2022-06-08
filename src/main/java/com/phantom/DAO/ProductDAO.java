package com.phantom.DAO;

import com.phantom.entity.Product;
import com.phantom.start.SessionStart;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.util.List;


public class ProductDAO {
    private final SessionStart start;

    public ProductDAO(SessionStart start) {
        this.start = start;
    }

    public Product findById(Long id){
        Session session = start.getFactory().getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class,id);
        session.getTransaction().commit();
        return product;
    }
    public List<Product> findAll(){
        Session session = start.getFactory().getCurrentSession();
        session.beginTransaction();
        List<Product> productsList = session.createQuery("SELECT p FROM Product p ").getResultList();
        session.getTransaction().commit();
        return productsList;
    }
    public void deleteById(Long id){
        Session session = start.getFactory().getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class,id);
        if (product != null) {
            session.delete(product);
            System.out.println("delete product.id = " + id);
        }
        session.getTransaction().commit();

    }
    public Product saveOrUpdate(Product product){
        Session session = start.getFactory().getCurrentSession();
        session.beginTransaction();
        Product inBaseProductNamedQuery = null;
        try {
            inBaseProductNamedQuery = session.createNamedQuery("inBaseProduct", Product.class)
                    .setParameter("productTitle", product.getTitle())
                    .getSingleResult();
        } catch (NoResultException e) {

        }
        if (inBaseProductNamedQuery != null){
            inBaseProductNamedQuery.setCost(product.getCost());
            session.getTransaction().commit();
            return inBaseProductNamedQuery;
        }else {
            session.save(product);
            session.getTransaction().commit();
            return product;

        }

    }
    public void findByTitle(String title){
        Session session = start.getFactory().getCurrentSession();
        session.beginTransaction();
        Product inBaseProductNamedQueryTitle = null;
        try {
            inBaseProductNamedQueryTitle = session.createNamedQuery("inBaseProduct", Product.class)
                    .setParameter("productTitle", title)
                    .getSingleResult();
        } catch (NoResultException e) {

        }
        if (inBaseProductNamedQueryTitle != null){
            System.out.println(inBaseProductNamedQueryTitle);
        }else {
            System.out.println("NO");
        }
        session.getTransaction().commit();
    }
}
