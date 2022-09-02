package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;
import peaksoft.service.InstructorService;
import peaksoft.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;
    private final InstructorService instructorService;
    private final CompanyService companyService;

    @Autowired
    public CourseController(CourseService courseService,
                            InstructorService instructorService,
                            CompanyService companyService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
        this.companyService = companyService;
    }

    @ModelAttribute("courseList")
    public List<Course> allCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping
    public String getAll() {
        return "coursePage";
    }

    @GetMapping("/saveCourse")
    public String saveCoursePage(Model model) {
        model.addAttribute("newCourse", new Course());
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "saveCoursePage";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("newCourse") Course course) {
        courseService.saveCourse(course);
        return "redirect:/api/courses/";
    }

    @GetMapping("/update/{courseId}")
    public String updateCourse(@PathVariable("courseId") Long courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        model.addAttribute("newCourse", course);
        model.addAttribute("companyId", course.getCompany().getId());
        return "updateCourse";

    }

    @PostMapping("/saveUpdate/{companyId}")
    public String saveUpdateCourse(@PathVariable("companyId") Long companyId,
                                   @PathVariable("courseId") Long courseId,
                                   @ModelAttribute("course") Course course) {
        courseService.updateCourse(courseId, course);
        return "redirect:/api/courses" + companyId;
    }

    @DeleteMapping("/delete/{courseId}")
        public String removeById (@PathVariable Long courseId){
            courseService.deleteCourseById(courseId);
            return "redirect:/api/courses";
    }
}