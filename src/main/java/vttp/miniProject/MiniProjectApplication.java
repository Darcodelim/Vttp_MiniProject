package vttp.miniProject;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import vttp.miniProject.Model.Beer;
import vttp.miniProject.Model.BeerRepo;
import vttp.miniProject.Model.Ingredients;
import vttp.miniProject.Model.Volume;
import vttp.miniProject.Model.boilVolume;
import vttp.miniProject.Model.method;
import vttp.miniProject.Service.BeerService;
import vttp.miniProject.Utils.Utils;


@SpringBootApplication
public class MiniProjectApplication implements CommandLineRunner {

	@Autowired
	BeerService beerSvc;

	@Autowired@Qualifier("BeerRedis")
    private RedisTemplate<String,String>template;

	@Autowired
	Utils utils;
	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}

	@Override
	public void run(String... args)
	 {	SetOperations<String,String> Set = template.opsForSet();
	// 	Set.add("Darien", "1,Buzz");
	// 	String id = "1";
    //   	String name = "Buzz";
    //   	BeerRepo beerRepo = new BeerRepo(id, name);
		
	// 	String rec = "%s,%s".formatted(beerRepo.getId(),beerRepo.getName());
	// 	Long num = Set.remove("Darien",rec);
	// 	System.out.printf("Number of items removed:%s\n",Long.toString(num));
    }
		// BeerRepo beerRepo1 = new BeerRepo("1","A");
	// 	BeerRepo beerRepo2 = new BeerRepo("2","B");
	// 	BeerRepo beerRepo3 = new BeerRepo("3","C");

	// 	List<BeerRepo> beerListRepo = new LinkedList<>();
	// 	beerListRepo.add(beerRepo1);
	// 	beerListRepo.add(beerRepo2);
	// 	beerListRepo.add(beerRepo3);

	// 	String ids = beerListRepo.stream().map(i->i.getId()).collect(Collectors.joining("|"));
    //   	List<Beer> beerList = beerSvc.getBeer(null, null, null, null, null, null, null, null, ids);


		}





