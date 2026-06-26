package com.example.Course.Registration.System.Controller;

import com.example.Course.Registration.System.Service.CourseService;
import com.example.Course.Registration.System.model.Course;
import com.example.Course.Registration.System.model.CourseRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> displayCourses()
    {
        return courseService.displayCourses();
    }

    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudents()
    {
        return courseService.enrolledStudents();
    }

    @PostMapping("courses/enrolled")
    @ResponseBody
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("emailId") String emailId ,
                               @RequestParam("courseName") String courseName)
    {
        courseService.enrollCourse(name,emailId,courseName);
        return "Congratulations! "+name+" you are successfully enrolled the course "+courseName;
    }
    @DeleteMapping("courses/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
        return "courseid "+id+" deleted successfully";
    }
}
