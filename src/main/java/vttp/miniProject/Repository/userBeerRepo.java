package vttp.miniProject.Repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;


import vttp.miniProject.Model.BeerRepo;

@Repository
public class userBeerRepo {

    @Autowired@Qualifier("BeerRedis")
    private RedisTemplate<String,String>template;

    public boolean hasList(String name)
    {
        return template.hasKey(name);
    }

    public void deleteList(String name)
    {
        template.delete(name);
    }

    public void addList(String name,List<BeerRepo> beerList)
    {
        SetOperations<String,String> Set = template.opsForSet();
        beerList.stream().forEach(Beer->{ 
            String rec ="%s,%s".formatted(Beer.getId(),Beer.getName());
            System.out.printf("Beer Added:%s",rec);
            Set.add(name, rec);
        });
    }
    
    public List<BeerRepo> getBeerList(String name)
    {
        SetOperations<String,String> Set = template.opsForSet();
        // Long size = list.size(name);
        List<BeerRepo> beerList = new LinkedList<>();
        for(String i : Set.members(name))
        {
            String[] terms = i.split(",");
            BeerRepo beerRepo = new BeerRepo();
            beerRepo.setId(terms[0]);
            beerRepo.setName(terms[1]);
            beerList.add(beerRepo);
        }
        return beerList;
    }

    public void deleteBeerRepo(String name, String id,String beerName)
    {
        SetOperations<String,String> Set = template.opsForSet();
        System.out.printf("Beer ID removed:%s\n",id);
        System.out.printf("Name removed:%s\n",beerName);
        String rec = "%s,%s".formatted(id,beerName);
        Long num = Set.remove(name,rec);
        System.out.println(rec);
        
        System.out.printf("Number of items removed:%s\n",Long.toString(num));
    }
}
