package controller;
import view.StatsView;
import repository.service.UniversityService;
import repository.service.UniversityDTO;
import java.util.List;
import view.Utils;

/**
 *
 * @author xe-di
 */

public class StatisticsController {
    private StatsView view;
    private UniversityService universityService;

    public StatisticsController() {
        universityService = new UniversityService();
        
    }

    public void loadStatistics() {
        List<UniversityDTO> popularUniversities = universityService.getUniversitiesWithCounterGreaterThanEqualTen();
        view = new StatsView(popularUniversities);
        this.view.setLocation(Utils.getParentCenterLocation(this.view.getParent(), this.view)); 
        view.setVisible(true);
    }

    public StatsView getView() {
        return view;
    }
}

