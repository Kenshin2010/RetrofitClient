
package com.manroid.retrofitclient.result;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Geoname {

    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("geonameId")
    @Expose
    private Integer geonameId;
    @SerializedName("countrycode")
    @Expose
    private String countrycode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fclName")
    @Expose
    private String fclName;
    @SerializedName("toponymName")
    @Expose
    private String toponymName;
    @SerializedName("fcodeName")
    @Expose
    private String fcodeName;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("fcl")
    @Expose
    private String fcl;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("fcode")
    @Expose
    private String fcode;

    /**
     * 
     * @return
     *     The lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     * 
     * @param lng
     *     The lng
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * 
     * @return
     *     The geonameId
     */
    public Integer getGeonameId() {
        return geonameId;
    }

    /**
     * 
     * @param geonameId
     *     The geonameId
     */
    public void setGeonameId(Integer geonameId) {
        this.geonameId = geonameId;
    }

    /**
     * 
     * @return
     *     The countrycode
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * 
     * @param countrycode
     *     The countrycode
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The fclName
     */
    public String getFclName() {
        return fclName;
    }

    /**
     * 
     * @param fclName
     *     The fclName
     */
    public void setFclName(String fclName) {
        this.fclName = fclName;
    }

    /**
     * 
     * @return
     *     The toponymName
     */
    public String getToponymName() {
        return toponymName;
    }

    /**
     * 
     * @param toponymName
     *     The toponymName
     */
    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    /**
     * 
     * @return
     *     The fcodeName
     */
    public String getFcodeName() {
        return fcodeName;
    }

    /**
     * 
     * @param fcodeName
     *     The fcodeName
     */
    public void setFcodeName(String fcodeName) {
        this.fcodeName = fcodeName;
    }

    /**
     * 
     * @return
     *     The wikipedia
     */
    public String getWikipedia() {
        return wikipedia;
    }

    /**
     * 
     * @param wikipedia
     *     The wikipedia
     */
    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The fcl
     */
    public String getFcl() {
        return fcl;
    }

    /**
     * 
     * @param fcl
     *     The fcl
     */
    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    /**
     * 
     * @return
     *     The population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * 
     * @param population
     *     The population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * 
     * @return
     *     The fcode
     */
    public String getFcode() {
        return fcode;
    }

    /**
     * 
     * @param fcode
     *     The fcode
     */
    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

}
