package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {

    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //OnetoOne Mapping Example
        /* Employee employee = entityManager.find(Employee.class, 1);

        System.out.println("***********Employee");
        System.out.println(employee.getName());
        System.out.println("***********Card Details");
        System.out.println(employee.getCard());*/

        /*AccessCard card = entityManager.find(AccessCard.class,4);
        System.out.println(card.getOwner());*/


        //OneToMany,ManyToOne Mapping Example
        /*PayStub payStub = entityManager.find(PayStub.class, 7);
        System.out.println(payStub.getEmployee());*/
        /*Employee employee = entityManager.find(Employee.class, 1);
        System.out.println(employee.getPayStub());*/

        //ManyToMany Mapping Example
        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 9);
        System.out.println("Got Email Group, Now Accessing Members");
        System.out.println(emailGroup.getMemberGroup());


    }
}
