package rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loca {
        @SerializedName("lon")
        @Expose
        public double lon;


        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        @SerializedName("lat")
        @Expose
        public double lat;




    }