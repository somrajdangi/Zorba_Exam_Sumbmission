package org.example;

import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(ProductType.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //saving product type data

        ProductType product1 = new ProductType();
        product1.setProductType("grocery");
        product1.setRate(30.00f);

        ProductType product2 = new ProductType();
        product2.setProductType("cosmetic");
        product2.setRate(50.00f);

        ProductType product3 = new ProductType();
        product3.setProductType("dairy product");
        product3.setRate(35.00f);

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(product1);
            session.persist(product2);
            session.persist(product3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        }


        //taking input from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter customer info: ");
        System.out.println("please enter customer name");
        String customerName= scanner.nextLine();
        System.out.println("please enter customer email");
        String customerEmail= scanner.nextLine();
        System.out.println("please enter customer mobile");
        Long mobile = scanner.nextLong();
        scanner.nextLine();

Validation validate = new Validation();
try{
    validate.validateCustomerId()
}
catch (Exception e){

}

        System.out.println("please enter product details: ");
    }
}
