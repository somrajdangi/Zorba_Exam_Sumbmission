package org.example.selfOwnedFlat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecuteSelfOwnedFlat {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("rentOfFlatBean.xml");
        SelfOwnedFlatProperty selfOwnedFlatProperty1 = context.getBean(SelfOwnedFlatProperty.class);
        SelfOwnedFlatProperty selfOwnedFlatProperty2 = context.getBean(SelfOwnedFlatProperty.class);
        System.out.println(selfOwnedFlatProperty1.getSelfOwnedThreeBHKFlat());

    }
}
