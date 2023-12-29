package vttp.miniProject.Model;

public class boilVolume {

    private String value; //Integer
    private String unit;
    
    public boilVolume(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
}
