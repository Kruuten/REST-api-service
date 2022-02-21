package ru.kruten.rest_api_test1_cft.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Country can't be blank")
    @Column(name = "name")
    private String name;

    public Country() {}

    public Country(String name) {
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
}
