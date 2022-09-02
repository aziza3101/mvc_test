package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;

    }
    @ModelAttribute("companyList")
    public List<Company> allCompanies(){
        return companyService.getAllCompanies();
    }
    @GetMapping
    public String getAll(){
        return "companyPage";
    }
    @GetMapping("/saveCompany")
    public String addCompany(Model model){
        model.addAttribute("newCompany", new Company());
        return "saveCompanyPage";
    }
    @PostMapping("/saveCompany")
    public String saveCompany(Company company){
        companyService.saveCompany(company);
        return "redirect:/api/companies";
    }
    @GetMapping("/updateCompany/{companyId}")
   public String updateCompany(@PathVariable Long companyId, Model model){
        Company company = companyService.getCompanyById(companyId);
        model.addAttribute("newCompany", company);
        return "updateCompanyPage";
    }
    @PostMapping("/updateCompany/{companyId}")
    public String saveUpdateCompany(Company company, @PathVariable Long companyId){
        companyService.updateCompany(company, companyId);
        return "redirect:/api/companies";
    }
    @GetMapping("/delete/{companyId}")
    public String removeById(@PathVariable Long companyId){
        companyService.deleteCompanyById(companyId);
        return "redirect:/api/companies";
    }
    @GetMapping("/myCourses/{companyId}")
    public String myCourses(@PathVariable Long companyId, Model model){
        List<Course> myCourses = companyService.myCourses(companyId);
        model.addAttribute("myCourses", myCourses);
        return "companiesCourses";
    }
}
