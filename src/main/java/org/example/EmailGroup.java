package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EmailGroup {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany(mappedBy = "emailGroup")
    private List<Employee> memberGroup = new ArrayList<>();
    public int getId() {
        return id;
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

    public List<Employee> getMemberGroup() {
        return memberGroup;
    }

    public void setMemberGroup(List<Employee> memberGroup) {
        this.memberGroup = memberGroup;
    }

    public void addMember(Employee employee){
        this.memberGroup.add(employee);
    }
}
