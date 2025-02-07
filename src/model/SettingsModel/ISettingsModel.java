
package model.SettingsModel;

import java.util.List;
import utils.ICustomEventListener;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
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
