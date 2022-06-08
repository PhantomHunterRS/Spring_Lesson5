package com.phantom.start;

import com.phantom.DAO.ProductDAO;
import com.phantom.entity.Product;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public class Start {

    public static void main(String[] args) {

        SessionStart sessionStart = new SessionStart();
        ProductDAO productDAO = new ProductDAO(sessionStart);
        try {
        System.out.println(productDAO.findAll().size());
        System.out.println(productDAO.findById(34L));
        productDAO.deleteById(62L);
        System.out.println(productDAO.findAll() + " " + productDAO.findAll().size());
        productDAO.saveOrUpdate(new Product("Banana", new BigDecimal(99.99)));
        System.out.println(productDAO.findAll().size());
        productDAO.findByTitle("Banana");
        productDAO.findByTitle("Chocolate - Mi - Amere Semi");
        }
        finally {
            sessionStart.getFactory().close();
        }

    }
}
