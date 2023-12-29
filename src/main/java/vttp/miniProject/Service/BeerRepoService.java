package vttp.miniProject.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.miniProject.Model.BeerRepo;
import vttp.miniProject.Repository.userBeerRepo;

@Service
public class BeerRepoService {
    
    @Autowired
    private userBeerRepo userBeerRepo;

    public List<BeerRepo> getList(String name)
    {
        if(userBeerRepo.hasList(name))
        {
            return userBeerRepo.getBeerList(name);
        }

        return new LinkedList<>();
    }


    public void save(String name, List<BeerRepo> list)
    {
        userBeerRepo.deleteList(name);
        userBeerRepo.addList(name, list);
    }
    
}
