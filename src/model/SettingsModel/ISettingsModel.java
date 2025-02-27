package model.SettingsModel;

import repository.entities.Country;
import java.util.List;
import utils.ICustomEventListener;

/**
 * 
 * Settings Model Interface. Used for allowing dependency inversion in Settings Model
 */
public interface ISettingsModel {
    /**
     * Adds a new country
     * @param country 
     */
    void addCountry(Country country);
    /**
     * Deletes an existing country
     * @param index 
     */
    void deleteCountry(int index);
    /**
     * Returns the private list of Countries
     * @return List<Country>
     */
    List<Country> getCountries();
    /**
     * Returns the Country Object of a country record
     * @param index
     * @return Country
     */
    Country getCountry(int index);
    
    /**
     * Populates a private list of Country type with all the available countries in the DB
     */
    void populateCountryList();
    /**
     * Inserts or Deletes any changes made on the Countries list to the Country DB table
     * @throws Exception 
     */
    void saveData() throws Exception;
    
    /**
     * Cascade deletes all universities
     * @throws Exception 
     */
    void clearDb() throws Exception;
    
    /**
     * Helper method to add event listeners to the ListUpadated event
     * @param listener 
     */
    void addDataUpdatedEventListener(ICustomEventListener<List<Country>> listener);
}
