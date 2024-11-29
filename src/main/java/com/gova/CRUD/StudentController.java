
package com.gova.CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    // @Autowired
    // private StudentRepo studentRepository;


    private final StudentRepo studentRepository;

    // Constructor-based dependency injection
    @Autowired
    public StudentController(StudentRepo studentRepository) {
        this.studentRepository = studentRepository;
    }



    @PostMapping
    Student createStudent(@RequestBody Student s){
       return studentRepository.save(s);
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id, 
            @RequestBody Student studentDetails) {
        // Check if student exists
        return studentRepository.findById(id)
            .map(existingStudent -> {
                existingStudent.setName(studentDetails.getName());
                existingStudent.setEmail(studentDetails.getEmail());
                Student updatedStudent = studentRepository.save(existingStudent);
                return ResponseEntity.ok(updatedStudent);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        return studentRepository.findById(id)
            .map(student -> {
                studentRepository.delete(student);
                return ResponseEntity.ok().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}