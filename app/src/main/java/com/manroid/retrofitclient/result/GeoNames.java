
package com.manroid.retrofitclient.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class GeoNames {

    @SerializedName("geonames")
    @Expose
    private List<Geoname> geonames = new ArrayList<Geoname>();

    /**
     * 
     * @return
     *     The geonames
     */
    public List<Geoname> getGeonames() {
        return geonames;
    }

    /**
     * 
     * @param geonames
     *     The geonames
     */
    public void setGeonames(List<Geoname> geonames) {
        this.geonames = geonames;
    }

}
