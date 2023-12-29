package vttp.miniProject.Service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import vttp.miniProject.Model.Beer;
import vttp.miniProject.Model.Ingredients;
import vttp.miniProject.Model.Volume;
import vttp.miniProject.Model.boilVolume;
import vttp.miniProject.Model.method;
import vttp.miniProject.Utils.Utils;

@Service
public class BeerService {

    @Autowired
    Utils utils;

    // @Value("${Stock.key}")
    // private String apiKey;

    public List<Beer> getBeer(String page,String per_page, String abv_gt, String abv_lt, String ibu_gt, String ibu_lt, String food,String beer_name,String ids)
    {   //There are only 325 beers

        Optional<String> pageOp = Optional.ofNullable(page);
        Optional<String> per_pageOp = Optional.ofNullable(per_page);
        Optional<String> abv_gtOp = Optional.ofNullable(abv_gt);
        Optional<String> abv_ltOp = Optional.ofNullable(abv_lt);
        Optional<String> ibu_gtOp = Optional.ofNullable(ibu_gt);
        Optional<String> ibu_ltOp = Optional.ofNullable(ibu_lt);
        Optional<String> foodOp = Optional.ofNullable(food);
        Optional<String> beer_nameOp = Optional.ofNullable(beer_name);

        // String encodedIds = "";
        // try {
        //     encodedIds = java.net.URLEncoder.encode(ids,"UTF-8");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // System.out.printf("Encoded:%s",encodedIds);
        Optional<String> beer_IDOp =Optional.ofNullable(ids);
        System.out.println(beer_IDOp);

        String url = UriComponentsBuilder
               .fromUriString("https://api.punkapi.com/v2/beers")
               .queryParamIfPresent("page", pageOp)
               .queryParamIfPresent("per_page", per_pageOp)
               .queryParamIfPresent("abv_gt",abv_gtOp)
               .queryParamIfPresent("abv_lt",abv_ltOp)
               .queryParamIfPresent("ibu_gt",ibu_gtOp)
               .queryParamIfPresent("ibu_lt",ibu_ltOp)
               .queryParamIfPresent("food",foodOp)
               .queryParamIfPresent("beer_name",beer_nameOp)
               .queryParamIfPresent("ids", beer_IDOp)
               .toUriString();
        
         System.out.println(url);
         RequestEntity<Void> req = RequestEntity.get(url).build();
         System.out.println(req);
         RestTemplate template = new RestTemplate();
         ResponseEntity<String> resp = null;

        try {

            resp = template.exchange(req, String.class);

         } catch (Exception ex) {
            ex.printStackTrace();
            // return new LinkedList<>();
         }

         String payload = resp.getBody();
         System.out.println(payload);
         JsonReader reader = Json.createReader(new StringReader(payload));
         JsonArray result = reader.readArray();
        
         List<Beer> beerList = new ArrayList<>();

         for(JsonValue jsonValue : result)
         {
            JsonObject jsonObject = jsonValue.asJsonObject();

            String id = Integer.toString(jsonObject.getInt("id"));
            String name = jsonObject.getString("name");
            String tagline = jsonObject.getString("tagline");
            String first_brewed = jsonObject.getString("first_brewed");
            String description =  jsonObject.getString("description");
            String image_url = jsonObject.getString("image_url",null);
            String abv = Double.toString(jsonObject.getJsonNumber("abv").doubleValue());
            String ibu="";
            String ebc="";
            String srm ="";
            String pH = "";
            try {
                ibu = Double.toString(jsonObject.getJsonNumber("ibu").doubleValue());
                ebc = Integer.toString(jsonObject.getInt("ebc"));
                srm = Integer.toString(jsonObject.getInt("srm"));
                pH = Double.toString(jsonObject.getJsonNumber("ph").doubleValue());
            } catch (Exception e) {
                ibu = "N/A";
                ebc = "N/A";
                srm = "N/A";
                pH = "N/A";
            }
            // String ibu = utils.doubleValue(jsonObject.get("ibu"));
            String target_fg = Double.toString(jsonObject.getJsonNumber("target_fg").doubleValue());
            String target_og =  Double.toString(jsonObject.getJsonNumber("target_og").doubleValue());
            
            
            String attLevel = Integer.toString(jsonObject.getInt("attenuation_level"));
            
            //Volume JsonObject
            JsonObject volumeObject = jsonObject.getJsonObject("volume");
            Volume volume = utils.volume(volumeObject);
            //boilVolume JsonObject
            JsonObject boilVolumeObject = jsonObject.getJsonObject("boil_volume");
            boilVolume boilVolume = utils.boilvolume(boilVolumeObject);
            //method JsonObject
            JsonObject methodObject = jsonObject.getJsonObject("method");
            method method = utils.method(methodObject);

            //ingredients JsonObject
            JsonObject ingredientObject = jsonObject.getJsonObject("ingredients");
            Ingredients ingredients = utils.ingredients(ingredientObject);
            //food pairing JsonArray
            JsonArray foodPairing = jsonObject.getJsonArray("food_pairing");
            List<String> foodPairingList = utils.foodPairingList(foodPairing);

            String brewerTips = jsonObject.getString("brewers_tips");

            Beer beer = new Beer(id, name, tagline, first_brewed, description, image_url, abv, ibu, target_fg, target_og, ebc, srm, pH, attLevel, volume, boilVolume, method, ingredients, foodPairingList, brewerTips);
            beerList.add(beer);

            // //TroubleShooting

            // JsonValue methodObject = jsonObject.getJsonObject("method").getJsonArray("mash_temp").getJsonObject(0).get("duration");
            
            // if(methodObject.getValueType() == JsonValue.ValueType.NUMBER)
            //  {
            //     System.out.println("Mash Duration is Number1");
    
            //  }
    
            //  else
            //  {
            //     System.out.println("Mash Duration is some other types");
            //  }
         
         }
         System.out.println(Integer.toString(beerList.size()));
         return beerList;
         

        

         
    }


    
}
