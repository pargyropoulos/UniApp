package model;

import java.util.List;
import model.SettingsModel.Country;
import repository.CountryDAO;


/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */

public class SearchModel {
    private String universityName="";
    private String country="";

    public List<Country> getListOfCountries(){
        CountryDAO dao =new CountryDAO(null);
//        CountryDAO dao=new CountryDAO(repository.Emf.getEntityManagerFactory());
        return dao.findAllOrdered();
    }
        
    public String getUniversityName() {
        return universityName;
    }
    
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public Boolean validate(String name, String country){
        return isAlphanumeric(universityName) && isAlphanumeric(country);
    }
    
    // Helper method to check if a string is alphanumeric using Regex
    private boolean isAlphanumeric(String text) {
        return text.matches("[a-zA-Z 0-9]*");
    }    
    
    public String getSearchString(){
        String searchString= !universityName.isEmpty() ? "?name="+universityName : "" ;
        if (searchString.contains("name")) {
            searchString+= !country.isEmpty() ? "&country="+country : "" ;
        }else {
            searchString= !country.isEmpty() ? "?country="+country : "" ;
        }
        return searchString;
    }
}
