package org.example;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA")
@NamedQuery(query="select e from Employee where e.age >:age order by e.name", name="emp name asc")
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "employee_name")
    private String name;

    private int age;
    @Column(unique = true,nullable = false,updatable = false)
    private String ssn;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;
    @OneToOne
    private AccessCard card;
    @OneToMany(mappedBy = "employee")
    private List<PayStub> payStub;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Email_Group_Subscriptions",
    joinColumns = @JoinColumn(name = "Employee_Id"),
    inverseJoinColumns = @JoinColumn(name = "Subscription_Email_Id"))
    private List<EmailGroup> emailGroup = new ArrayList<>();
    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ssn='" + ssn + '\'' +
                ", dob=" + dob +
                ", type=" + type +
                ", card=" + card +
                '}';
    }

    @Transient
    private String debugval;


    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public List<PayStub> getPayStub() {
        return payStub;
    }

    public void setPayStub(List<PayStub> payStub) {
        this.payStub = payStub;
    }

    public List<EmailGroup> getEmailGroup() {
        return emailGroup;
    }

    public void setEmailGroup(List<EmailGroup> emailGroup) {
        this.emailGroup = emailGroup;
    }

    public void addEmailSubscription(EmailGroup emailGroup){
        this.emailGroup.add(emailGroup);
    }
}
