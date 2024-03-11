package com.xion.controller;


import com.xion.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // Rest API returns a java bean
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "Sayanthan", "Mahendran");
        return student;
    }

    // Rest API returns a List in json format
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Sayanthan", "Mahendran"));
        students.add(new Student(2, "Harina", "Sayanthan"));
        students.add(new Student(3, "Maju", "Anandh"));
        return students;
    }

    // Rest API with Path Variable
    // {id} - URI template variable
    @GetMapping("students/{id}")
    public Student getStudentWithPathVariable(@PathVariable int id) {
        return new Student(id, "Sayanthan", "Mahendran");
    }

    // Rest API with multiple Path Variable
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student getStudentWithMultiplePathVariable(@PathVariable("id") int studentId,
                                                      @PathVariable("first-name") String firstName,
                                                      @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    // Rest API with Request Param
    @GetMapping("students/one")
    public Student getStudentWithRequestParam(@RequestParam int id) {
        return new Student(id, "Sayanthan", "Mahendran");
    }

    // Rest API with multiple Request Params
    //http://localhost:8080/students/one?id=1&firstName=Sayan
    @GetMapping("all-students/one")
    public Student getStudentWithMultipleRequestParam(@RequestParam int id, @RequestParam String firstName) {
        return new Student(id, firstName, "Mahendran");
    }

    // Rest API that handles HTTP POST Request - Creating new resource
    // @PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;

    }

    // Rest API that handles HTTP PUT Request - Updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Rest API that handles Delete Request
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student deleted successfully";
    }

    // Rest API returns a java bean with ResponseEntity
    @GetMapping("student/get")
    public ResponseEntity<Student> getStudentWithResponseEntity() {
        Student student = new Student(1, "Sayanthan", "Mahendran");
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "Sayan").body(student);
    }
}
