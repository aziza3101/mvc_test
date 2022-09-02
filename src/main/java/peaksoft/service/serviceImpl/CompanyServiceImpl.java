package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.saveCompany(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.getCompanyById(companyId);
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyRepository.deleteCompanyById(id);
    }

    @Override
    public List<Course> myCourses(Long companyId) {
        Company company = companyRepository.getCompanyById(companyId);
        System.out.println(company.getCourses());
        if  (company.getCourses() == null) {
            return null;
        }
        return company.getCourses();
    }

    @Override
    public void updateCompany(Company company, Long companyId) {
        companyRepository.updateCompany(company,companyId);
    }
}
