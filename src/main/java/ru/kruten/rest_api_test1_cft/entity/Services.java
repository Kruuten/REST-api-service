package ru.kruten.rest_api_test1_cft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "pointservice", joinColumns = @JoinColumn(name = "service_id"),
    inverseJoinColumns = @JoinColumn(name = "servicepoint_id"))
    private List<ServicePoint> servicePoints;

    public void addAddressesToServices(ServicePoint addressAndPointName){
        if (addressAndPointName == null)
            servicePoints = new ArrayList<>();
        servicePoints.add(addressAndPointName);
    }

    public Services() {
    }

    public Services(String name) {
        this.name = name;
    }


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

    @JsonIgnore
    public List<ServicePoint> getServicePoints() {
        return servicePoints;
    }

    public void setServicePoints(List<ServicePoint> servicePoints) {
        this.servicePoints = servicePoints;
    }
}
