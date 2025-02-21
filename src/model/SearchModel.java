package model;

import java.util.List;
import repository.entities.Country;
import model.SettingsModel.SettingsDAO;


public class SearchModel {
    private String universityName="";
    private String country="";

    public List<Country> getListOfCountries(){
        SettingsDAO dao =new SettingsDAO(null);
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
    
    /**
     * Helper method to check if a string is alphanumeric using Regex
     * @param text
     * @return true if the text matches EN alpanumerics
     */
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
