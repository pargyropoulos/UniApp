package model.SettingsModel;

import repository.entities.Country;
import java.util.List;
import utils.ICustomEventListener;

public interface ISettingsModel {
    void addCountry(Country country);
    void deleteCountry(int index);
    List<Country> getCountries();
    Country getCountry(int index);
    void populateCountryList();
    void saveData() throws Exception;
    void clearDb() throws Exception;
    void addDataUpdatedEventListener(ICustomEventListener<List<Country>> listener);
    
}
