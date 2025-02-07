
package view.settingsForm;

import java.awt.event.ActionListener;
import java.util.List;
import model.SettingsModel.Country;
/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or
 * std154845@ac.eap.gr
 */
public interface ISettingsView{
    void addSaveEventListener(ActionListener listener);
    void addCloseEventListener(ActionListener listener);
    void addClearDbEventListener(ActionListener listener);
    void addDeleteEntryEventListener(ActionListener listener);
    void addAddEntryEventListener(ActionListener listener);
    void show();
    int getSelectedRowIndex();
    String getCountryTextBox();
    void setCountryTextBox(String countryName);
    void updateGrid(List<Country> data);
    <T> T getView();
}
