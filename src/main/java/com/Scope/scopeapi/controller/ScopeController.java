package com.Scope.scopeapi.controller;

import javax.validation.Valid;
import com.Scope.scopeapi.model.Class;
import com.Scope.scopeapi.model.Instructor;
import com.Scope.scopeapi.model.Student;
import com.Scope.scopeapi.repository.ClassRepository;
import com.Scope.scopeapi.repository.InstructorRepository;
import com.Scope.scopeapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class ScopeController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private ClassRepository classRepository;


    @GetMapping(value ="/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();//.toString();
    }


    @GetMapping("/students/create/NetId={net}/first={first}/last={last}")
    public String createStudent(@PathVariable("net") String NetId,@PathVariable("first") String first,@PathVariable("last") String last) {
        Student student = new Student();
        student.setNetId(NetId);
        student.setFirstName(first);
        student.setLastName(last);
        studentRepository.save(student);
        return "Saved record: " + NetId +" "+ first+ " "+ last;
    }

    @GetMapping("/students/delete/{netId}")
    public String deleteStudent(@PathVariable("netId") String NetId) {

        Optional<Student> student = studentRepository.findById(NetId);
               // .orElseThrow(() -> throw new Exception("User not found on :: "+ NetId));

        Student stu = student.get();

       studentRepository.delete(stu);
        return "deleted record " +NetId;
    }

    @GetMapping("/students/update/NetId={net}/first={first}/last={last}")
    public String updateStudent(@PathVariable("net") String NetId,@PathVariable("first") String first,@PathVariable("last") String last) {
        Student student = new Student();
        student.setNetId(NetId);
        student.setFirstName(first);
        student.setLastName(last);
        studentRepository.save(student);
        return "Updated record record: " + NetId +" "+ first+ " "+ last;
    }


    @GetMapping(value ="/instructors")
    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();//.toString();
    }

    @GetMapping("/instructors/create/NetId={net}/first={first}/last={last}")
    public String createInstructor(@PathVariable("net") String NetId,@PathVariable("first") String first,@PathVariable("last") String last) {
        Instructor instructor = new Instructor();
        instructor.setNetId(NetId);
        instructor.setFirstName(first);
        instructor.setLastName(last);
        instructorRepository.save(instructor);
        return "Saved record: " + NetId +" "+ first+ " "+ last;
    }

    @GetMapping("/instructor/delete/{netId}")
    public String deleteInstructor(@PathVariable("netId") String NetId) {

        Optional<Instructor> instructor = instructorRepository.findById(NetId);
        // .orElseThrow(() -> throw new Exception("User not found on :: "+ NetId));

        Instructor ins = instructor.get();

        instructorRepository.delete(ins);
        return "deleted record " +NetId;
    }

    @GetMapping("/instructors/update/NetId={net}/first={first}/last={last}")
    public String updateInstructor(@PathVariable("net") String NetId,@PathVariable("first") String first,@PathVariable("last") String last) {
        Instructor instructor = new Instructor();
        instructor.setNetId(NetId);
        instructor.setFirstName(first);
        instructor.setLastName(last);
        instructorRepository.save(instructor);
        return "Saved record: " + NetId +" "+ first+ " "+ last;
    }

    @GetMapping(value ="/classes")
    public List<Class> getAllClasses(){
        return classRepository.findAll();//.toString();
    }

    @GetMapping("/class/create/CRN={crn}/department={dept}/courseNumber={cnum}/courseTitle={ctitle}")
    public String createClass(@PathVariable("crn") String CRN,@PathVariable("dept") String dept,@PathVariable("cnum") String cnum,@PathVariable("ctitle") String ctitle) {
      Class cla = new Class();
        cla.setCourseNumber(cnum);
        cla.setCourseTitle(ctitle);
        cla.setCRN(CRN);
        cla.setDepartment(dept);
        classRepository.save(cla);
        return "Saved record: " + CRN +" "+ ctitle+ " "+ dept + " "+ cnum;
    }

    @GetMapping("/class/delete/{CRN}")
    public String deleteClass(@PathVariable("CRN") String CRN) {

        Optional<Class> cla = classRepository.findById(CRN);
        // .orElseThrow(() -> throw new Exception("User not found on :: "+ NetId));

        Class ins = cla.get();

        classRepository.delete(ins);
        return "deleted record " +CRN;
    }

    @GetMapping("/class/update/CRN={crn}/department={dept}/courseNumber={cnum}/courseTitle={ctitle}")
    public String updateClass(@PathVariable("crn") String CRN,@PathVariable("dept") String dept,@PathVariable("cnum") String cnum,@PathVariable("ctitle") String ctitle) {
        Class cla = new Class();
        cla.setCourseNumber(cnum);
        cla.setCourseTitle(ctitle);
        cla.setCRN(CRN);
        cla.setDepartment(dept);
        classRepository.save(cla);
        return "Saved record: " + CRN +" "+ ctitle+ " "+ dept + " "+ cnum;
    }
}
