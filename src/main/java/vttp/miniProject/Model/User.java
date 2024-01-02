package vttp.miniProject.Model;

import jakarta.validation.constraints.NotBlank;

public class User {
    @NotBlank(message="Please input name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String user) {
        this.name = user;
    }

    
    
}
