package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Company;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonRepository lessonRepository;

    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @ModelAttribute("lessonList")
    public List<Lesson> allLessons(){
        return lessonRepository.getAllLessons();
    }
    @GetMapping
    public String getAll(){
        return "lessonPage";
    }
}
