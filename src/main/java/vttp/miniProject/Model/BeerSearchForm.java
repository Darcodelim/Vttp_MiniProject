package vttp.miniProject.Model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BeerSearchForm {
    
    
    @Pattern(regexp="^[A-Za-z ]+$|^(?=\\s*$)",message="Must be a character") 
    private String food;

    @Pattern(regexp="^(?=\\s*$)|^(0|[1-9]\\d*)(\\.\\d+)?$")
    @DecimalMin(value= "0.5",message="The minimum ABV is 0.5%" )@DecimalMax(value = "55", message="The maximum ABV is 55%")
    private String ABVmin;

    @Pattern(regexp="^(?=\\s*$)|^(0|[1-9]\\d*)(\\.\\d+)?$",message="accepts only Spaces,Integer and Decimals")
    @Size(min=0,max=2)@DecimalMin(value= "0.5",message="The minimum ABV is 0.5%" )@DecimalMax(value = "55", message="The maximum ABV is 55%")
    private String ABVmax;

    @Pattern(regexp="^(?=\\s*$)|^(0|[1-9]\\d*)$")
    @Size(min=0,max=3)@Min(value=1,message="The minimum IBU is 1")@Max(value=250,message="The maximum IBU is 250")
    private String IBUmin;

    @Pattern(regexp="^(?=\\s*$)|^(0|[1-9]\\d*)$")
    @Min(value=1,message="The minimum IBU is 1")@Max(value=250,message="The maximum IBU is 250")
    private String IBUmax;
    

    public BeerSearchForm(@Pattern(regexp = "^[A-Za-z ]+$|^(?=\\s*$)", message = "Must be a character") String food,
            @Pattern(regexp = "^(?=\\s*$)|^(0|[1-9]\\d*)(\\.\\d+)?$") @DecimalMin(value = "0.5", message = "The minimum ABV is 0.5%") @DecimalMax(value = "55", message = "The maximum ABV is 55%") String aBVmin,
            @Pattern(regexp = "^(?=\\s*$)|^(0|[1-9]\\d*)(\\.\\d+)?$", message = "accepts only Spaces,Integer and Decimals") @Size(min = 0, max = 2) @DecimalMin(value = "0.5", message = "The minimum ABV is 0.5%") @DecimalMax(value = "55", message = "The maximum ABV is 55%") String aBVmax,
            @Pattern(regexp = "^(?=\\s*$)|^(0|[1-9]\\d*)$") @Size(min = 0, max = 3) @Min(value = 1, message = "The minimum IBU is 1") @Max(value = 250, message = "The maximum IBU is 250") String iBUmin,
            @Pattern(regexp = "^(?=\\s*$)|^(0|[1-9]\\d*)$") @Min(value = 1, message = "The minimum IBU is 1") @Max(value = 250, message = "The maximum IBU is 250") String iBUmax) {
        this.food = food;
        ABVmin = aBVmin;
        ABVmax = aBVmax;
        IBUmin = iBUmin;
        IBUmax = iBUmax;
    }
    
    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }
    public String getABVmin() {
        return ABVmin;
    }
    public void setABVmin(String aBVmin) {
        ABVmin = aBVmin;
    }
    public String getABVmax() {
        return ABVmax;
    }
    public void setABVmax(String aBVmax) {
        ABVmax = aBVmax;
    }
    public String getIBUmin() {
        return IBUmin;
    }
    public void setIBUmin(String iBUmin) {
        IBUmin = iBUmin;
    }
    public String getIBUmax() {
        return IBUmax;
    }
    public void setIBUmax(String iBUmax) {
        IBUmax = iBUmax;
    }
    


    
    
}
