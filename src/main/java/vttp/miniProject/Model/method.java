package vttp.miniProject.Model;

public class method {

    private String mashTempValue; //Integer
    private String mashTempUnit;
    private String duration;
    private String fermentationTemp;//Integer
    private String fermentationUnit;
    private String twist;
    
    

    
    public method(String mashTempValue, String mashTempUnit, String duration, String fermentationTemp,
            String fermentationUnit, String twist) {
        this.mashTempValue = mashTempValue;
        this.mashTempUnit = mashTempUnit;
        this.duration = duration;
        this.fermentationTemp = fermentationTemp;
        this.fermentationUnit = fermentationUnit;
        this.twist = twist;
    }
    
    public String getMashTempValue() {
        return mashTempValue;
    }
    public void setMashTempValue(String mashTempValue) {
        this.mashTempValue = mashTempValue;
    }
    public String getMashTempUnit() {
        return mashTempUnit;
    }
    public void setMashTempUnit(String mashTempUnit) {
        this.mashTempUnit = mashTempUnit;
    }
    public String getFermentationTemp() {
        return fermentationTemp;
    }
    public void setFermentationTemp(String fermentationTemp) {
        this.fermentationTemp = fermentationTemp;
    }
    public String getFermentationUnit() {
        return fermentationUnit;
    }
    public void setFermentationUnit(String fermentationUnit) {
        this.fermentationUnit = fermentationUnit;
    }
    public String getTwist() {
        return twist;
    }
    public void setTwist(String twist) {
        this.twist = twist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    

    
}
