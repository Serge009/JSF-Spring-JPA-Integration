package com.bionic.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by oper4 on 31.10.2014.
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String email;
    private String ccno;
    private String cctype;
    private Date maturity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="payment",
            joinColumns=@JoinColumn(name="customerId"),
            inverseJoinColumns=
            @JoinColumn(name="merchantId"))

    private List<Merchant> merchants;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Payment> payments;

    public Customer() {
    }

    public Customer(int id, String name, String address, String email, String ccno, String cctype, Date maturity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.ccno = ccno;
        this.cctype = cctype;
        this.maturity = maturity;
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public int getId() {
        return id;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCcno() {
        return ccno;
    }

    public void setCcno(String ccno) {
        this.ccno = ccno;
    }

    public String getCctype() {
        return cctype;
    }

    public void setCctype(String cctype) {
        this.cctype = cctype;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", ccno='" + ccno + '\'' +
                ", cctype='" + cctype + '\'' +
                ", maturity=" + maturity +
                '}';
    }
}
