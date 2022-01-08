package ru.kruten.rest_api_test1_cft.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicepoint")
public class ServicePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Address can't be blank")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "Pointname can't be blank")
    @Column(name = "pointname")
    private String pointName;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "pointservice", joinColumns = @JoinColumn(name = "servicepoint_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Services> services;

    public void addServicesToAddress(Services service){
        if (services == null)
            services = new ArrayList<>();
        services.add(service);
    }

    public ServicePoint() {
    }

    public ServicePoint(String address, String pointName) {
        this.address = address;
        this.pointName = pointName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Services> getServicesList() {
        return services;
    }

    public void setServicesList(List<Services> services) {
        this.services = services;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
