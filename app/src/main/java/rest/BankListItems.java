package rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by colors on 15-07-2016.
 */
public class BankListItems implements Serializable {



    @SerializedName("Advertisements")
    @Expose
    private String Advertisements;

    @SerializedName("Bankid")
    @Expose
    public String bankid;
    @SerializedName("name")
    @Expose
   public String bank_name;
    @SerializedName("logo_url")
    @Expose
    public String logo_url;
    @SerializedName("web_url")
    @Expose
    public String web_url;
    @SerializedName("associated_bank_url")
    @Expose
    public String associated_bank_url;
    @SerializedName("quick_pay_url")
    @Expose
    public String quick_pay_url;
    @SerializedName("City")
    @Expose
    public String city;


    @SerializedName("branches")
    @Expose
    public List<Branch> list=new ArrayList<>();
    @SerializedName("atms")
    @Expose
    public List<AtmListItems> atmList=new ArrayList<>();

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }
    public List<AtmListItems> getAtmList() {
        return atmList;
    }

    public void setAtmList(List<AtmListItems> atmList) {
        this.atmList = atmList;
    }

    public List<Branch> getList() {
        return list;
    }

    public void setList(List<Branch> list) {
        this.list = list;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }




    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getAssociated_bank_url() {
        return associated_bank_url;
    }

    public void setAssociated_bank_url(String associated_bank_url) {
        this.associated_bank_url = associated_bank_url;
    }

    public String getQuick_pay_url() {
        return quick_pay_url;
    }

    public void setQuick_pay_url(String quick_pay_url) {
        this.quick_pay_url = quick_pay_url;
    }
}
