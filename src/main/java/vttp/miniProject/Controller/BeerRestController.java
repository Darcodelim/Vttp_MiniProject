package vttp.miniProject.Controller;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import vttp.miniProject.Model.Beer;

@RestController
@RequestMapping
public class BeerRestController {
    
    @GetMapping(path="/credits", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRawData()
    {
        String urlCom = UriComponentsBuilder
               .fromUriString("https://api.punkapi.com/v2/beers")
               .path("/1")
               .toUriString();
        RequestEntity<Void> req = RequestEntity.get(urlCom).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;
        try {;

            resp = template.exchange(req, String.class);

         } catch (Exception ex) {
            ex.printStackTrace();
            
         }

        String payload = resp.getBody();
        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonArray result = reader.readArray();
        JsonValue Json_contribute_by =result.get(0);
        JsonObject jsonObject = Json_contribute_by.asJsonObject();
        
        String contributed_by = jsonObject.getString("contributed_by");
        String Results = "This website is powered by: %s\nDone by: %s".formatted("https://api.punkapi.com/v2/beers",contributed_by);
        return Results;
        // JsonReader reader = Json.createReader(new StringReader(payload));
        // JsonArray result = reader.readArray();


    
    }
}
