package vttp.miniProject.Model;

import java.util.List;

public class Ingredients {

    private List<Malt> listOfMalt;
    private List<Hops> listOfHops;
    private String yeast;
    
    public Ingredients(List<Malt> listOfMalt, List<Hops> listOfHops, String yeast) {
        this.listOfMalt = listOfMalt;
        this.listOfHops = listOfHops;
        this.yeast = yeast;
    }
    public List<Malt> getListOfMalt() {
        return listOfMalt;
    }
    public void setListOfMalt(List<Malt> listOfMalt) {
        this.listOfMalt = listOfMalt;
    }
    public List<Hops> getListOfHops() {
        return listOfHops;
    }
    public void setListOfHops(List<Hops> listOfHops) {
        this.listOfHops = listOfHops;
    }
    public String getYeast() {
        return yeast;
    }
    public void setYeast(String yeast) {
        this.yeast = yeast;
    }
    
    
}
