package vttp.miniProject.Utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;



import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import vttp.miniProject.Model.Hops;
import vttp.miniProject.Model.Ingredients;
import vttp.miniProject.Model.Malt;
import vttp.miniProject.Model.Volume;
import vttp.miniProject.Model.boilVolume;
import vttp.miniProject.Model.method;

@Component
public class Utils {

    public List<String> foodPairingList(JsonArray jArrFood)
    {   
        List<String> foodPairList = new ArrayList<>();
        for(int i = 0 ; i<jArrFood.size();i++)
        {
            foodPairList.add(jArrFood.get(i).toString());
        }
        return foodPairList;
    }

    public List<Malt> maltList(JsonArray jArrMalt)
    {       
        List<Malt> maltList = new ArrayList<>();
        for(int i = 0; i <jArrMalt.size();i++)
        {   String name = jArrMalt.getJsonObject(i).getString("name");
            String amount = Double.toString(jArrMalt.getJsonObject(i).getJsonObject("amount").getJsonNumber("value").doubleValue());
            String unit = jArrMalt.getJsonObject(i).getJsonObject("amount").getString("unit");
            Malt malt = new Malt(name, amount, unit);

            maltList.add(malt);
        }
        
        return maltList;
    }

        public List<Hops> hopList(JsonArray jArrHops)
    {       
        List<Hops> hopList = new ArrayList<>();
        for(int i = 0; i <jArrHops.size();i++)
        {   String name = jArrHops.getJsonObject(i).getString("name");
            String amount = Double.toString(jArrHops.getJsonObject(i).getJsonObject("amount").getJsonNumber("value").doubleValue());
            String unit = jArrHops.getJsonObject(i).getJsonObject("amount").getString("unit");
            String add = jArrHops.getJsonObject(i).getString("add");
            String attribute = jArrHops.getJsonObject(i).getString("attribute");
            Hops hops = new Hops(name, amount, unit,add,attribute);

            hopList.add(hops);
        }
        
        return hopList;
    }
    
    public Ingredients ingredients(JsonObject ingredientObject)
    {
        JsonArray maltArray = ingredientObject.getJsonArray("malt");
        JsonArray hopArray = ingredientObject.getJsonArray("hops");
        String yeast = ingredientObject.getString("yeast");

        List<Malt> malt = maltList(maltArray);
        List<Hops> hops = hopList(hopArray);

        Ingredients ingredients = new Ingredients(malt, hops, yeast);

        return ingredients;

    }

    public Volume volume(JsonObject volumeObject)
    {
        String value =  Integer.toString(volumeObject.getInt("value"));
        String unit = volumeObject.getString("unit");

        Volume volume = new Volume(value, unit);

        return volume;
        
    }

    public boilVolume boilvolume(JsonObject boilVolumeObject)
    {
        String value =  Integer.toString(boilVolumeObject.getInt("value"));
        String unit = boilVolumeObject.getString("unit");

        boilVolume boilVolume = new boilVolume(value, unit);

        return boilVolume;
        
    }

    public method method(JsonObject methodObject)
    {   //MashTemp
        JsonObject mashTempObject= methodObject.getJsonArray("mash_temp").getJsonObject(0);
        String mashValue = Integer.toString(mashTempObject.getJsonObject("temp").getInt("value"));
        String mashUnit = mashTempObject.getJsonObject("temp").getString("unit");
        String mashDuration = Integer.toString(mashTempObject.getInt("duration",0));


        //Fermentation
        JsonObject fermentationObject =  methodObject.getJsonObject("fermentation");
        String fermentValue ="";
        try {
            fermentValue = Integer.toString(fermentationObject.getJsonObject("temp").getInt("value",0));
        } catch (Exception e) {
            // TODO: handle exception
            fermentValue = "N/A";
        }
         
        String fermentUnit = fermentationObject.getJsonObject("temp").getString("unit","N/A");

        String twist = methodObject.getString("twist","N/A");

        method method = new method(mashValue, mashUnit, mashDuration, fermentValue, fermentUnit, twist);

        return method;
        
    }
    
}
