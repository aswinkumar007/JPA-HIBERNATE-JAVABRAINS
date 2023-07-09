package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JpaStarterCreate
{
    public static void main( String[] args )    {

        //Create
        Employee employee = new Employee();
        employee.setName("Aswin");
        employee.setAge(29);
        employee.setSsn("123");
        employee.setDob(new Date());
        employee.setType(EmployeeType.FULL_TIME);

        Employee employee2 = new Employee();
        employee2.setName("Aarthi");
        employee2.setAge(28);
        employee2.setSsn("132");
        employee2.setDob(new Date());
        employee2.setType(EmployeeType.CONTRACTOR);

        Employee employee3 = new Employee();
        employee3.setName("Aakash");
        employee3.setAge(27);
        employee3.setSsn("456");
        employee3.setDob(new Date());
        employee3.setType(EmployeeType.INTERN);

        AccessCard card1 = new AccessCard();
        card1.setIssuedDate(new Date());
        card1.setActive(true);
        card1.setFirmwareVersion("1.0");
        card1.setOwner(employee);
        employee.setCard(card1);

        AccessCard card2 = new AccessCard();
        card2.setIssuedDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("2.0");
        card2.setOwner(employee2);
        employee2.setCard(card2);

        AccessCard card3 = new AccessCard();
        card3.setIssuedDate(new Date());
        card3.setActive(false);
        card3.setFirmwareVersion("3.0");
        card3.setOwner(employee3);
        employee3.setCard(card3);

        PayStub paystub1 = new PayStub();
        paystub1.setPayPeriodStart(new Date());
        paystub1.setPayPeriodEnd(new Date());
        paystub1.setEmployee(employee);
        paystub1.setSalary(2000);

        PayStub paystub2 = new PayStub();
        paystub2.setPayPeriodStart(new Date());
        paystub2.setPayPeriodEnd(new Date());
        paystub2.setEmployee(employee);
        paystub2.setSalary(3500);

        List<PayStub> list = new ArrayList<>();
        list.add(paystub1);
        list.add(paystub2);
        employee.setPayStub(list);

        EmailGroup emailGroup1 = new EmailGroup();
        emailGroup1.setName("Medical Science");
        emailGroup1.addMember(employee);
        emailGroup1.addMember(employee2);
        employee.addEmailSubscription(emailGroup1);
        employee2.addEmailSubscription(emailGroup1);

        EmailGroup emailGroup2 = new EmailGroup();
        emailGroup2.setName("Computer Engineering");
        employee.addEmailSubscription(emailGroup2);
        emailGroup2.addMember(employee);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(employee);
        entityManager.persist(employee2);
        entityManager.persist(employee3);

        entityManager.persist(card1);
        entityManager.persist(card2);
        entityManager.persist(card3);

        entityManager.persist(paystub1);
        entityManager.persist(paystub2);

        entityManager.persist(emailGroup1);
        entityManager.persist(emailGroup2);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();


        //Read & Update
        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class,1);
        Employee employee1 = entityManager.find(Employee.class,2);

        System.out.println(employee);
        System.out.println(employee1);

        employee.setAge(18);
        employee.setType(EmployeeType.INTERN);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
*/

        //Delete
        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class,3);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(employee);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();*/
    }
}
