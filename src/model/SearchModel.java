package model;

import java.util.List;
import repository.entities.Country;
import model.SettingsModel.SettingsDAO;

/**
 * 
 * Model part of the Search MVC
 */
public class SearchModel {
    private String universityName="";
    private String country="";

    /**
     * Returns the list of all available countries.
     * @return 
     */
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
    
    /**
     * Validates name and country fields
     * @param name
     * @param country
     * @return 
     */
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
    
    /**
     * Builds the search string to be sent to the REST API
     * @return 
     */
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
