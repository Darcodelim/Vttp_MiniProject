package vttp.miniProject.Model;

public class Malt {

    private String name;
    private String amountValue;
    private String amountUnit;

    
    public Malt(String name, String amountValue, String amountUnit) {
        this.name = name;
        this.amountValue = amountValue;
        this.amountUnit = amountUnit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAmountValue() {
        return amountValue;
    }
    public void setAmountValue(String amountValue) {
        this.amountValue = amountValue;
    }
    public String getAmountUnit() {
        return amountUnit;
    }
    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }
    
    
}
