package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

import java.util.LinkedList;

@Subclass
public class CityPhoto extends Photo {


    /**
     *Explanation:
     *the City Type shall be given wrt. to the cities country. For example:
     *A city with 700k inhabitants is a CITY (or METROPOLIS) in Germany, but a TOWN in China
     *
     */
    enum CityType {
        METROPOLIS, CITY, TOWN, VILLAGE
    }


    /**
     * Explanation:
     * Describes the culture of this city. E.G. touristic, business, students city etc.
     * Example: Erlangen is a typical student city but Frankfurt is a business city. Berlin
     * is a student, business and touristic city
     * So a city can have more than one culture types
     */
    enum CityCulture {
        STUDENT_CITY, BUSINESS_CITY, TOURIST_CITY
    }


    private String cityName;
    private String country;
    private CityType cityType;
    private CityCulture[] cityCulture;
    private long population;
    private LinkedList<String> pointsOfInterest; //Sehenswuerdigkeiten der Stadt / die das Foto zeigt


    /**
     *
     *@methodtype constructor
     */
    public CityPhoto(){
        super();
    }

    /**
     *
     *@methodtype constructor
     */
    public CityPhoto(PhotoId myId) {
        super(myId);
    }

    /**
     *
     * @methodtype set
     */
    public void setCityName ( String cityName){
        assertStringNotNull(cityName, "cityName");
        this.cityName = cityName;
    }

    /**
     *
     * @methodtype get
     */
    public String getCityName() {
        return cityName;
    }


    /**
     *
     * @methodtype get
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @methodtype set
     */
    public void setCountry(String country) {
        assertStringNotNull(country, "country");
        this.country = country;
    }

    /**
     *
     * @methodtype get
     */
    public CityType getCityType() {
        return cityType;
    }

    /**
     *
     * @methodtype set
     */
    public void setCityType(CityType cityType) {
        if(cityType == null)
            throw new IllegalArgumentException("The argument cityType must not be null!");
        this.cityType = cityType;
    }

    /**
     *
     * @methodtype get
     */
    public CityCulture[] getCityCulture() {
        return cityCulture;
    }

    /**
     *
     * @methodtype set
     */
    public void setCityCulture(CityCulture[] cityCulture) {
        if(cityCulture == null)
            throw new IllegalArgumentException("The argument cityType must not be null!");

        this.cityCulture = cityCulture;
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

    private void assertStringNotNull(String strToTest, String arg){
        if (strToTest == null)
            throw new IllegalArgumentException("The argument "+ arg + " must not be null!");
    }

}
