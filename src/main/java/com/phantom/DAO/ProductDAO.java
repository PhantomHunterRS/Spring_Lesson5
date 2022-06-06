package com.phantom.DAO;

import com.phantom.entity.Product;
import com.phantom.start.SessionStart;
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
        Product inBaseProduct = session.createQuery("SELECT p FROM Product p WHERE p.title =" + product.getTitle(),Product.class).getSingleResult();
        if (inBaseProduct != null){
            inBaseProduct.setCost(product.getCost());
            return inBaseProduct;
        }else {
            session.save(product);
            return product;
        }
    }
}
