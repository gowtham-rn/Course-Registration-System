package com.example.Course.Registration.System.Service;

import com.example.Course.Registration.System.Repository.CourseRegistryRepo;
import com.example.Course.Registration.System.Repository.CourseRepository;
import com.example.Course.Registration.System.model.Course;
import com.example.Course.Registration.System.model.CourseRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> displayCourses() {
        return courseRepository.findAll();
    }


    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry=new CourseRegistry(name,emailId,courseName);
        courseRegistryRepo.save(courseRegistry);
    }


    public void deleteCourse(int id) {
        courseRegistryRepo.deleteById(id);
    }
}
