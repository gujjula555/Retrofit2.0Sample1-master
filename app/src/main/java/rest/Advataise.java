package rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by colors on 13-08-2016.
 */
public class Advataise  {


   @SerializedName("postad_id")
    @Expose
    private String postad_id;

    @SerializedName("bank")
    @Expose
    private String bank;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("arabic_title")
    @Expose
    private String arabic_title;

    @SerializedName("pub_date")
    @Expose
    private String pub_date;

    @SerializedName("Web_url")
    @Expose
    private String Web_url;

    @SerializedName("image_urls")
    @Expose
    private String[] image_urls;

    @SerializedName("notification_image_url")
    @Expose
    private String notification_image_url;

    @SerializedName("text")
    @Expose
    private String text;

    public String getNotification_image_url() {
        return notification_image_url;
    }

    public void setNotification_image_url(String notification_image_url) {
        this.notification_image_url = notification_image_url;
    }

    public String getPostad_id() {
        return postad_id;
    }

    public void setPostad_id(String postad_id) {
        this.postad_id = postad_id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArabic_title() {
        return arabic_title;
    }

    public void setArabic_title(String arabic_title) {
        this.arabic_title = arabic_title;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getWeb_url() {
        return Web_url;
    }

    public void setWeb_url(String web_url) {
        Web_url = web_url;
    }

    public String[] getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(String[] image_urls) {
        this.image_urls = image_urls;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }











}
