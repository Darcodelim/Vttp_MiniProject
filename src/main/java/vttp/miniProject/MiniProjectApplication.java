package vttp.miniProject;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
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
import vttp.miniProject.Service.BeerRepoService;
import vttp.miniProject.Service.BeerService;
import vttp.miniProject.Utils.Utils;


@SpringBootApplication
public class MiniProjectApplication implements CommandLineRunner {

	@Autowired
	BeerService beerSvc;



	@Autowired
	Utils utils;
	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}

	@Override
	public void run(String... args)
	{	BeerRepo beerRepo1 = new BeerRepo("1","A");
		BeerRepo beerRepo2 = new BeerRepo("2","B");
		BeerRepo beerRepo3 = new BeerRepo("3","C");

		List<BeerRepo> beerListRepo = new LinkedList<>();
		beerListRepo.add(beerRepo1);
		beerListRepo.add(beerRepo2);
		beerListRepo.add(beerRepo3);

		String ids = beerListRepo.stream().map(i->i.getId()).collect(Collectors.joining("|"));
      	List<Beer> beerList = beerSvc.getBeer(null, null, null, null, null, null, null, null, "2");
		System.out.println(ids);
		// Beer beer1 = beerList.get(0);
		
		// List<Beer> beerList = beerSvc.getBeer(null,null,null,null,null,null,null,null,"280");
		// Beer beer1 = beerList.get(0);
		// System.out.printf("Beer id:%s\nBeer name:%s\n", beer1.getId(),beer1.getName());
		// long num = 1;
		// double num1 = 2;
		// System.out.printf("num1: %d, num2: %f",num,num1);

		// String[] teStrings= {"hi","bye","wtf"};
		// List<String> test = new ArrayList<>();
		// for(String string:teStrings)
		// {
		// 	 test = utils.foodPairingList(string);
		// 	 System.out.printf("%d",test.size());
		// for(String str: test)
		// {	
		// 	System.out.println(str);
		// }
		}

		


	}


