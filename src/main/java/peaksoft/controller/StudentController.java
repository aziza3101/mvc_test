package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Student;
import peaksoft.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @ModelAttribute("studentList")
    public List<Student> allStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping
    public String getAll(){
        return "studentPage";
    }
}
