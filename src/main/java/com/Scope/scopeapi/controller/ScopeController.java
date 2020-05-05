package com.Scope.scopeapi.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import com.Scope.scopeapi.model.*;
import com.Scope.scopeapi.repository.AssessmentRepo.AssessmentRepository;
import com.Scope.scopeapi.repository.CourseRepo.CourseRepository;
import com.Scope.scopeapi.repository.EnrollmentRepo.EnrollmentRepository;
import com.Scope.scopeapi.repository.InstructorRepo.InstructorRepository;

import com.Scope.scopeapi.repository.StudentRepo.StudentRepository;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ScopeController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private AssessmentRepository assessmentRepository;





    //students
    @GetMapping(value ="/students")
    public List<String[]> getAllStudents(){
        return studentRepository.findAllStudents();//.toString();
    }

    @GetMapping(value ="/student/{id}")
    public String[] getStudentById(@PathVariable String id){
       List<String[]> student = studentRepository.findStudentByNetId(id);
       return student.get(0);
    }

    @PostMapping("/student")
    ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) throws URISyntaxException{
        Student result = studentRepository.save(student);
        return ResponseEntity.created(new URI("/student/" +result.getNetId())).body(student);
    }

    @PutMapping(value = "/student/{id}")
    ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student){
        Student result = studentRepository.save(student);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id){
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


//instructors
    @GetMapping(value ="/instructors")
    public List<String[]> getAllInstructors(){
        return instructorRepository.findAllInstructors() ;//.toString();
    }

    @GetMapping(value ="/instructor/{id}")
    public List<String[]> getInstructorById(@PathVariable String id){
         return instructorRepository.findInstructorByNetId(id);
        //return instructor.get();
    }

    @PostMapping("/instructor")
    ResponseEntity<Instructor> createInstructor(@Valid @RequestBody Instructor instructor) throws URISyntaxException{
        Instructor result = instructorRepository.save(instructor);
        return ResponseEntity.created(new URI("/instructor/" +result.getNetId())).body(instructor);
    }

    @PutMapping(value = "/instructor/{id}")
    ResponseEntity<Instructor> updateInstructor(@Valid @RequestBody Instructor instructor){
        Instructor result = instructorRepository.save(instructor);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/instructor/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable String id){
        instructorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


//courses
    @GetMapping(value ="/courses")
    public List<Map> getAllCourses(){
        return courseRepository.findAllCourses();//.toString();
    }

    @GetMapping(value ="/course/{id}")
    public List<String[]> getCourseById(@PathVariable String id){
          return courseRepository.findCourseByCRN(id);
            }

    @PostMapping("/course")
    ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) throws URISyntaxException{
        Course result = courseRepository.save(course);
        return ResponseEntity.created(new URI("/course/" +result.getCRN())).body(course);
    }

    @PutMapping(value = "/course/{id}")
    ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course){
        Course result = courseRepository.save(course);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable String id){
        instructorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    //enrollments

    @GetMapping(value ="/enrollment")
    public List<String[]> getAllEnrollments(){
        return enrollmentRepository.findAllEnrollments();//.toString();
    }


    @PostMapping("/enrollment")
    ResponseEntity<Enrollment> createEnrollment(@Valid @RequestBody Enrollment enrollment) throws URISyntaxException{
        Enrollment result = enrollmentRepository.save(enrollment);
        return ResponseEntity.created(new URI("/enrollment/" +result.getCRN())).body(enrollment);
    }

    //mongo
    @GetMapping(value ="/Assessment")
    public List<BasicDBObject> getAllAssessments(){
        return assessmentRepository.findAllAssessments();//.toString();
    }
    @GetMapping(value ="/Assessment/{CRN}")
    public List<BasicDBObject> getAssessmentByCRN(@PathVariable String CRN){
        return assessmentRepository.findAssessmentByClass(CRN);
    }






    //query

    @GetMapping(value ="/query/{netId}")
    public List<String[]> getStudentClasses(@PathVariable String netId){



       return studentRepository.findStudentClasses(netId);
    }

}
