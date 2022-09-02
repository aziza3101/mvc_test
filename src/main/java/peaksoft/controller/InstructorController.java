package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Instructor;
import peaksoft.service.InstructorService;

import java.util.List;

@Controller
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @ModelAttribute("instructorList")
    public List<Instructor> allInstructors(){
        return instructorService.getAllInstructors();
    }
    @GetMapping
    public String getAll(){
        return "instructorPage";
    }
}
