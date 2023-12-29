package vttp.miniProject.Model;

import java.util.List;

public class Beer {
    //need to change the json values to string before parsing any data that are numbers
    private String id;
    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;
    private String abv;//Double
    private String ibu;//Integer
    private String target_fg;//Integer
    private String target_og;//Inter=ger
    private String ebc;//Integer
    private String srm;//Integer
    private String ph;//Double
    private String attLevel;//Double
    private Volume volume;
    private boilVolume boilVolume;
    private method method;
    private Ingredients ingredients;
    private List<String> food_pairing;
    private String brewer_tips;

    public Beer()
    {}

    public Beer(String id, String name, String tagline, String first_brewed, String description, String image_url,
            String abv, String ibu, String target_fg, String target_og, String ebc, String srm, String ph,
            String attLevel, Volume volume, boilVolume boilVolume,
            method method, Ingredients ingredients, List<String> food_pairing, String brewer_tips) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.first_brewed = first_brewed;
        this.description = description;
        this.image_url = image_url;
        this.abv = abv;
        this.ibu = ibu;
        this.target_fg = target_fg;
        this.target_og = target_og;
        this.ebc = ebc;
        this.srm = srm;
        this.ph = ph;
        this.attLevel = attLevel;
        this.volume = volume;
        this.boilVolume = boilVolume;
        this.method = method;
        this.ingredients = ingredients;
        this.food_pairing = food_pairing;
        this.brewer_tips = brewer_tips;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTagline() {
        return tagline;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    public String getFirst_brewed() {
        return first_brewed;
    }
    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public String getAbv() {
        return abv;
    }
    public void setAbv(String abv) {
        this.abv = abv;
    }
    public String getIbu() {
        return ibu;
    }
    public void setIbu(String ibu) {
        this.ibu = ibu;
    }
    public String getTarget_fg() {
        return target_fg;
    }
    public void setTarget_fg(String target_fg) {
        this.target_fg = target_fg;
    }
    public String getTarget_og() {
        return target_og;
    }
    public void setTarget_og(String target_og) {
        this.target_og = target_og;
    }
    public String getEbc() {
        return ebc;
    }
    public void setEbc(String ebc) {
        this.ebc = ebc;
    }
    public String getSrm() {
        return srm;
    }
    public void setSrm(String srm) {
        this.srm = srm;
    }
    public String getPh() {
        return ph;
    }
    public void setPh(String ph) {
        this.ph = ph;
    }
    public String getAttLevel() {
        return attLevel;
    }
    public void setAttLevel(String attLevel) {
        this.attLevel = attLevel;
    }
    public Volume getVolume() {
        return volume;
    }
    public void setVolume(Volume volume) {
        this.volume = volume;
    }
    public boilVolume getBoilVolume() {
        return boilVolume;
    }
    public void setBoilVolume(boilVolume boilVolume) {
        this.boilVolume = boilVolume;
    }
    public method getMethod() {
        return method;
    }
    public void setMethod(method method) {
        this.method = method;
    }
    public Ingredients getIngredients() {
        return ingredients;
    }
    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }
    public List<String> getFood_pairing() {
        return food_pairing;
    }
    public void setFood_pairing(List<String> food_pairing) {
        this.food_pairing = food_pairing;
    }
    public String getBrewer_tips() {
        return brewer_tips;
    }
    public void setBrewer_tips(String brewer_tips) {
        this.brewer_tips = brewer_tips;
    }

    



    
}
