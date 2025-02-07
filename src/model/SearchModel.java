package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model._SettingsModel.Country;
import repository.Emf;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */

public class SearchModel {
    private String universityName="";
    private String country="";

    public List<Country> getListOfCountries(){
        EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
        try {
            Query query = em.createNamedQuery("Country.findAllOrdered");
            return query.getResultList();
            }
        finally{
            if (em != null){
            em.close();
            }
        }
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
