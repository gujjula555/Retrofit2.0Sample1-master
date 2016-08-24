package rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by colors on 21-07-2016.
 */
public class AtmListItems {

    @SerializedName("Atmid")
    @Expose
    public String atmid;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("address")
    @Expose
    public String adress;

    public Loca getLocati() {
        return locati;
    }

    public void setLocati(Loca locati) {
        this.locati = locati;
    }

    @SerializedName("location")
    @Expose
    public Loca locati ;/*=  new Loca();*/


    public String getAtmid() {
        return atmid;
    }

    public void setAtmid(String atmid) {
        this.atmid = atmid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }



}
