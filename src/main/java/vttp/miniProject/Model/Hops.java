package vttp.miniProject.Model;

public class Hops {

    private String name;
    private String amountValue;
    private String amountUnit;
    private String add;
    private String attribute;
    
    public Hops(String name, String amountValue, String amountUnit, String add, String attribute) {
        this.name = name;
        this.amountValue = amountValue;
        this.amountUnit = amountUnit;
        this.add = add;
        this.attribute = attribute;
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
    public String getAdd() {
        return add;
    }
    public void setAdd(String add) {
        this.add = add;
    }
    public String getAttribute() {
        return attribute;
    }
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    
}
