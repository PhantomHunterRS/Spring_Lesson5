package com.phantom.start;

import com.phantom.DAO.BuyerDAO;
import com.phantom.DAO.ProductDAO;
import com.phantom.entity.Buyer;
import com.phantom.entity.Product;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public class Start {

    public static void main(String[] args) {
        SessionStart sessionStart = new SessionStart();
        ProductDAO productDAO = new ProductDAO(sessionStart);
        BuyerDAO buyerDAO = new BuyerDAO(sessionStart,new Buyer("Mishel"));
        try {
            //homeWork5
//        System.out.println(productDAO.findAll().size());
//        System.out.println(productDAO.findById(34L));
//        productDAO.deleteById(62L);
//        System.out.println(productDAO.findAll() + " " + productDAO.findAll().size());
//        productDAO.saveOrUpdate(new Product("Banana", new BigDecimal(99.99)));
//        System.out.println(productDAO.findAll().size());
//        productDAO.findByTitle("Banana");
//        productDAO.findByTitle("Chocolate - Mi - Amere Semi");
            //homeWork6
            buyerDAO.addInCart(2L);
            buyerDAO.addInCart(15L);
            buyerDAO.addInCart(25L);
            buyerDAO.addInCart(35L);
            buyerDAO.addInCart(45L);
            buyerDAO.addInCart(4L);
            System.out.println(buyerDAO.showShoppingList());
        }
        finally {
            sessionStart.getFactory().close();
        }

    }
}
