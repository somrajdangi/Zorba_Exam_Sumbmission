package org.example.rentOfFlat_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecuteRentOfFlat {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("rentOfFlatBean.xml");
        RentOfFlatProperty rentProperty1 = (RentOfFlatProperty) context.getBean("property1");
        RentOfFlatProperty rentProperty2 = (RentOfFlatProperty) context.getBean("property2");
        System.out.println(rentProperty1.getRentOfThreeBHKFlat());
    }
}
