import view.MainView;
import controller.MainController;
import java.util.ArrayList;
import java.util.List;
import model.SettingsModel.SettingsDAO;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class Main { 
    public static void main(String[] args) {     
        MainController ctrl=new MainController(new MainView());
        ctrl.run();
    }
}
