package com.sahil.movieBookingSystem.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class City {

    @Id
    @GeneratedValue
    private int cityId;

    @Column(length=20,nullable = false)
    private String cityName;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER) //using only @OneToMany this will always result in creating a new table,,which given use a problem(wastage of resources,reduction and many more)
    //to avoid this we use mappedBy
    private Set<Theatre> theatres;

    public City(){}

    public City(int cityId, String cityName){
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City(String cityName){
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }
}
