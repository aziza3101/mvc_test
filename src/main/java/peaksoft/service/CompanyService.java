package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.entity.Course;

import java.util.List;
@Service
public interface CompanyService {
    void saveCompany(Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(Long companyId);
    void updateCompany(Company company, Long companyId);
    void deleteCompanyById(Long id);

    List<Course> myCourses(Long companyId);
}
