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
import com.Scope.scopeapi.repository.TeachesRepo.TeachesRepository;
import com.mongodb.BasicDBObject;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    @Autowired
    private TeachesRepository teachesRepository;





    //students
    @GetMapping(value ="/students")
    public String getAllStudents() throws JSONException {
        return studentRepository.findAllStudents().toString();//.toString();
    }

    @GetMapping(value ="/student/{id}")
    public String getStudentById(@PathVariable String id) throws JSONException {
       return studentRepository.findStudentByNetId(id).toString();
       //return student.get(0);
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
    public String getAllInstructors() throws JSONException {
        return instructorRepository.findAllInstructors().toString() ;//.toString();
    }

    @GetMapping(value ="/instructor/{id}")
    public String getInstructorById(@PathVariable String id) throws JSONException {
         return instructorRepository.findInstructorByNetId(id).toString();
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
    public String getAllCourses() throws IOException, JSONException {
        return  courseRepository.findAllCourses().toString();//.toString();
    }

    @GetMapping(value ="/course/{id}")
    public String getCourseById(@PathVariable String id) throws JSONException {
          return courseRepository.findCourseByCRN(id).toString();
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
    public String getAllEnrollments() throws JSONException {
        return enrollmentRepository.findAllEnrollments().toString();//.toString();
    }


    @PostMapping("/enrollment")
    ResponseEntity<Enrollment> createEnrollment(@Valid @RequestBody Enrollment enrollment) throws URISyntaxException{
        Enrollment result = enrollmentRepository.save(enrollment);
        return ResponseEntity.created(new URI("/enrollment/" +result.getCRN())).body(enrollment);
    }

    @DeleteMapping(value = "/enrollment/{netId}/{CRN}")
    ResponseEntity<?> deleteEnrollment(@PathVariable String netId, @PathVariable String CRN){
       // Enrollment enrollment =new Enrollment(netId,CRN);
        enrollmentRepository.deleteEnrollment(CRN,netId);
        return ResponseEntity.ok().build();
    }


    //teaches

    @GetMapping(value ="/teaches")
    public String getAllTeaches() throws JSONException {
        return teachesRepository.findAllTeaches().toString();//.toString();
    }

    @PostMapping("/teaches")
    ResponseEntity<Teaches> createTeaches(@Valid @RequestBody Teaches teaches) throws URISyntaxException{
        Teaches result = teachesRepository.save(teaches);
        return ResponseEntity.created(new URI("/teaches/" +result.getCRN())).body(teaches);
    }

    @DeleteMapping(value = "/teaches/{netId}/{CRN}")
    ResponseEntity<?> deletTeaches(@PathVariable String netId, @PathVariable String CRN){
        // Enrollment enrollment =new Enrollment(netId,CRN);
        teachesRepository.deleteTeaches(CRN,netId);
        return ResponseEntity.ok().build();
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
    @GetMapping(value ="/Assessment/student/{netId}")
    public List<BasicDBObject> getAssessmentByNetId(@PathVariable String netId) throws JSONException {
        return assessmentRepository.findAssessmentByNetId(netId);
    }
    @GetMapping(value ="/Assessment/instructor/{netId}")
    public List<BasicDBObject> getAssessmentByInstructorNetId(@PathVariable String netId) throws JSONException {
        return assessmentRepository.findAssessmentByInstructorNetId(netId);
    }
    @PostMapping("/Assessment")
    ResponseEntity<BasicDBObject> createEnrollment(@Valid @RequestBody BasicDBObject assessment) throws URISyntaxException{
        assessmentRepository.insertAssessment(assessment);
        return ResponseEntity.created(new URI("/enrollment/?")).body(assessment);
    }





    //query

    @GetMapping(value ="/query/student/{netId}")
    public String getStudentClasses(@PathVariable String netId) throws JSONException {

       return studentRepository.findStudentClasses(netId).toString();
    }
    @GetMapping(value ="/query/instructor/{netId}")
    public String getInstructorClasses(@PathVariable String netId) throws JSONException {

        return instructorRepository.findInstructorClasses(netId).toString();
    }
}
