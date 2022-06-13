package com.phantom.DAO;

import com.phantom.entity.Buyer;
import com.phantom.entity.Product;
import com.phantom.start.SessionStart;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyerDAO {

    private final SessionStart start;
    private final Buyer buyer;
    private final List<Product> productList;

    public BuyerDAO(SessionStart start, Buyer buyer) {
        this.start = start;
        this.buyer = buyer;
        productList = new ArrayList<>();
    }

    public void addInCart(Long id){
        Session session = start.getFactory().getCurrentSession();
        session.beginTransaction();
        Product inCartProduct = session.get(Product.class,id);
        System.out.println(inCartProduct);
        productList.add(inCartProduct);
        session.getTransaction().commit();
    }
    public List<Product> showShoppingList(){
        return productList;
    }


}
