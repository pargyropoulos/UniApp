
package view.settingsForm;

import java.awt.event.ActionListener;
import java.util.List;
import repository.entities.Country;

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

    public void setClearDBbtnText(String press_to_delete_permantly);
}
