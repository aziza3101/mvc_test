package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;

import java.util.List;
@Repository
public interface CourseRepository {
    void saveCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    void deleteCourseById(Long id);
    void updateCourse(Course course, Long courseId);
}
