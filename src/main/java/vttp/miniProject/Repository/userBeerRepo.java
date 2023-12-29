package vttp.miniProject.Repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
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
        ListOperations<String,String> list = template.opsForList();
        beerList.stream().forEach(Beer->{ 
            String rec ="%s,%s".formatted(Beer.getId(),Beer.getName());
            list.leftPush(name,rec);
        });
    }
    
    public List<BeerRepo> getBeerList(String name)
    {
        ListOperations<String,String> list = template.opsForList();
        Long size = list.size(name);
        List<BeerRepo> beerList = new LinkedList<>();
        for(String i : list.range(name,0,size))
        {
            String[] terms = i.split(",");
            BeerRepo beerRepo = new BeerRepo();
            beerRepo.setId(terms[0]);
            beerRepo.setName(terms[1]);
            beerList.add(beerRepo);
        }
        return beerList;
    }
}
