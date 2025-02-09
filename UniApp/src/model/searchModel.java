package model;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class searchModel {
    private String universityName;
    private String country;

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
    
    public Boolean validate(){
        return isAlphanumeric(universityName) && isAlphanumeric(country);
    }
    
    // Helper method to check if a string is alphanumeric using Regex
    public boolean isAlphanumeric(String text) {
        return text.matches("[a-zA-Z0-9]*");
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
