
package com.manroid.retrofitclient.result;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CountryFromCode {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("subregion")
    @Expose
    private String subregion;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     *
     * @param capital
     * The capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     *
     * @return
     * The subregion
     */
    public String getSubregion() {
        return subregion;
    }

    /**
     *
     * @param subregion
     * The subregion
     */
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }
}
