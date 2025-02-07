package model._SettingsModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import repository.CountryJpaController;
import repository.Emf;
import utils.CustomEventSource;
import utils.ICustomEventListener;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class SettingsModel implements ISettingsModel {
    private Country countryModel;
    private List<Country> countries=null;
    private final CountryJpaController dao;
    private final List<Country> deletedRows = new ArrayList<>();
    private final Set<Country> insertedRows = new HashSet<>();
    private final CustomEventSource<List<Country>> dataUpdatedEventSource = new CustomEventSource<>();
    
    public SettingsModel() {
        this.countryModel = null;
        this.dao = new CountryJpaController(repository.Emf.getEntityManagerFactory());
    }
    
    @Override
    public void populateCountryList(){
//        this.countries=dao.findCountryEntities();
        EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
        System.out.println(em);
        try {
            Query query = em.createNamedQuery("Country.findAllOrdered");
            countries = query.getResultList();
            dataUpdatedEventSource.notifyEventListeners(countries);
            }
        finally {
            if (em != null){
            em.close();
            }
        }
    }
    
    @Override
    public List<Country> getCountries(){
        return countries;
    }

    @Override
    public Country getCountry(int index) {
        this.countryModel=this.countries.get(index);
        return countryModel;
    }

    @Override
    public void saveData() throws Exception{
        for (var item:insertedRows){
            dao.create(item);
        }
        for (var item:deletedRows){
            dao.destroy(item.getName());
        }
        populateCountryList();
        deletedRows.clear();
        insertedRows.clear();
    }
    
    @Override
    public void deleteCountry(int index) {
        Country tmpCountry=countries.get(index);
        if (insertedRows.contains(tmpCountry)){
            insertedRows.remove(tmpCountry);
        }else {
            deletedRows.add(countries.get(index));
        }
        countries.remove(index);
        System.out.println("-".repeat(10));
        for (var item:deletedRows){
            System.out.println(item);
        }
        dataUpdatedEventSource.notifyEventListeners(countries);
    }

    @Override
    public void addCountry(Country country) {
        if (countries.contains(country)) return;
        countries.add(country);
        insertedRows.add(country);
        System.out.println("-".repeat(10));
        for (var item:insertedRows){
            System.out.println(item);
        }
        dataUpdatedEventSource.notifyEventListeners(countries);
    }

    @Override
    public void clearDb() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addDataUpdatedEventListener(ICustomEventListener<List<Country>> listener) {
        dataUpdatedEventSource.addEventListener(listener);
    }
}

