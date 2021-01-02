package com.employee.model;
import javax.persistence.*;


@Entity
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fName;
    private String lName;
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addID")
    private AddressModel add;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public AddressModel getAdd() {
        return add;
    }

    public void setAdd(AddressModel add) {
        this.add = add;
    }

    public EmployeeModel() {
    }
}
