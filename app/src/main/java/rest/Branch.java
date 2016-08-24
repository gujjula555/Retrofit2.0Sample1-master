package rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Branch {
    /*@SerializedName("Advertisements")
    @Expose
    private String branches;*/
    @SerializedName("Branchid")
    @Expose
    public String branchid;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("address")
    @Expose
    public String adress;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("web_url")
    @Expose
    public String webUrl;


    @SerializedName("location")
    @Expose
    public Loca locati ;/*=  new Loca();*/



    @SerializedName("working_hours")
    @Expose
    public List<WorkingHours> workingHours ;/*=new ArrayList<>();*/
    @SerializedName("open_all_day")
    @Expose
    public String[] open_all_day;
    @SerializedName("open_morning")
    @Expose
    public String[] open_morning;
    @SerializedName("closed")
    @Expose
    public String[] closed;



    public Loca getLocati() {
        return locati;
    }

    public void setLocati(Loca locati) {
        this.locati = locati;
    }

    public List<WorkingHours> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<WorkingHours> workingHours) {
        this.workingHours = workingHours;
    }


    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    public String[] getOpen_all_day() {
        return open_all_day;
    }

    public void setOpen_all_day(String[] open_all_day) {
        this.open_all_day = open_all_day;
    }

    public String[] getOpen_morning() {
        return open_morning;
    }

    public void setOpen_morning(String[] open_morning) {
        this.open_morning = open_morning;
    }

    public String[] getClosed() {
        return closed;
    }

    public void setClosed(String[] closed) {
        this.closed = closed;
    }


   /* public String[] getWorkingHoursMorningtime() {
        return workingHoursMorningtime;
    }

    public void setWorkingHoursMorningtime(String[] workingHoursMorningtime) {
        this.workingHoursMorningtime = workingHoursMorningtime;
    }

    public String[] getWorkingevEningtime() {
        return workingevEningtime;
    }

    public void setWorkingevEningtime(String[] workingevEningtime) {
        this.workingevEningtime = workingevEningtime;
    }

    public String[]  workingHoursMorningtime;
    public String[]  workingevEningtime;*/
    // public double[] location;





   /* public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }*/


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Branch() {
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


    public class WorkingHours {
        public OpenTime getOpenTime() {
            return openTime;
        }

        public void setOpenTime(OpenTime openTime) {
            this.openTime = openTime;
        }

        public OpenTime getOpenTime1() {
            return openTime1;
        }

        public void setOpenTime1(OpenTime openTime1) {
            this.openTime1 = openTime1;
        }

        @SerializedName("Morningtime")
        @Expose
        OpenTime openTime = new OpenTime();
        @SerializedName("eveningtime")
        @Expose
        OpenTime openTime1 = new OpenTime();
    }


    public class OpenTime {
        @SerializedName("begin_time")
        @Expose
        public String begin_time;
        @SerializedName("end_time")
        @Expose
        public String end_time;

        public String getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }


    }

}