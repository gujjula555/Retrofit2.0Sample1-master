package rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colors on 13-08-2016.
 */
public class Resultss {

    public List<Advataise> getResults() {
        return results;
    }

    public void setResults(List<Advataise> results) {
        this.results = results;
    }

    @SerializedName("Advertisements")
    @Expose
    public List<Advataise> results = new ArrayList<>();
}
