package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.repository.CompanyRepository;
import peaksoft.repository.CourseRepository;
import peaksoft.service.CourseService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;
    @Autowired

    public CourseServiceImpl(CompanyRepository companyRepository, CourseRepository courseRepository) {
        this.companyRepository = companyRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    public void saveCourse(Course course) {
        courseRepository.saveCourse(course);
    }
    public void save(Long companyId, Course course){
        Company company = companyRepository.getCompanyById(companyId);
        course.setCompany(company);
        company.setCourse(course);
        courseRepository.saveCourse(course);

    }
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }
    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }
    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteCourseById(id);
    }
    @Override
    public void updateCourse(Long courseId, Course course) {
        courseRepository.updateCourse(course, courseId);
    }
}
