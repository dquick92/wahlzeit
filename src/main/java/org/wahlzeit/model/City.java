package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.util.LinkedList;

import static org.wahlzeit.utils.AssertNotNull.assertStringNotNull;

/**
 * Created by daniel on 09.01.17.
 */
public class City extends DataObject {

    private CityType cityType;
    private long population;
    private String cityName;
    private String country;
    private LinkedList<String> pointsOfInterest; //Sehenswuerdigkeiten der Stadt / die das Foto zeigt

    public City(CityType cityType) {
        this.cityType = cityType;
    }

    /**
     *
     * @methodtype get
     */
    public CityType getCityType() {
        return this.cityType;
    }

    /**
     *
     * @methodtype set
     */
    public void setCityType(CityType cityType) {
        this.cityType = cityType;
    }
        /**
         *
         * @methodtype get
         */
    public String getCityName() {
        return this.cityName;
    }

    /**
     *
     * @methodtype set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     *
     * @methodtype get
     */
    public String getCountry() {
        return this.country;
    }

    /**
     *
     * @methodtype set
     */
    public void setCountry(String country) {
        this.country = country;
        }
    /**
     *
     * @methodtype get
     */
    public long getPopulation() {
        return population;
    }

    /**
     *
     * @methodtype set
     */
    public void setPopulation(long population) {
        if (population <= 0)
            throw new IllegalArgumentException("A cities population cannot be smaller than 0!");
        this.population = population;
    }

    /**
     *
     * @methodtype factory
     */
    public boolean addPointOfInterest(String name){
        assertStringNotNull(name, "name");
        return this.pointsOfInterest.add(name);
    }

    /**
     *
     * @methodtype factory
     */
    public boolean removePointOfInterest(String name){
        assertStringNotNull(name, "name");
        return this.pointsOfInterest.remove(name);
    }

    /**
     *
     * @methodtype get
     */
    public LinkedList<String> getPointsOfInterest(){
        return this.pointsOfInterest;
    }


    @Override
    public String toString(){
        return buildCityID(this.cityName, this.country);
    }

    public static String buildCityID(String cityName, String country){
        return cityName+" in " + country;

    }

}
