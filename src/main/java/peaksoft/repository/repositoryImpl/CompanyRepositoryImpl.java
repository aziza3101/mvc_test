package peaksoft.repository.repositoryImpl;


import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveCompany(Company company) {
        entityManager.persist(company);
    }
    @Override
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("SELECT c FROM Company c", Company.class).getResultList();
    }
    @Override
    public Company getCompanyById(Long companyId) {
        return entityManager.find(Company.class, companyId);
    }
    @Override
    public void deleteCompanyById(Long id) {
        entityManager.remove(entityManager.find(Company.class, id));
    }
    @Override
    public void updateCompany(Company company, Long companyId) {
       entityManager.createQuery("delete from Company  where id=?1")
               .setParameter(1, companyId);
       company.setId(companyId);
       entityManager.merge(company);
    }

}
