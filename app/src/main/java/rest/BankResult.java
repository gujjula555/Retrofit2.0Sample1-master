package rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colors on 13-08-2016.
 */
public class BankResult {
    public List<BankListItems> getBankresu() {
        return bankresu;
    }

    public void setBankresu(List<BankListItems> bankresu) {
        this.bankresu = bankresu;
    }

    @SerializedName("banklist")
    @Expose

    List<BankListItems> bankresu=new ArrayList<>();



}
