/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.service;
import java.util.List;
/**
 *
 * @author xe-di
 */
public class UniversityService {

    private UniversityRankingRepository universityRepository;

    public UniversityService() {
        universityRepository = new UniversityRankingRepository();
    }

    public List<UniversityDTO> getUniversitiesWithCounterGreaterThanEqualTen() {
        return universityRepository.findUniversitiesWithCounterGreaterThanEqualTen();
    }

//    public List<UniversityDTO> getAllUniversities() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
