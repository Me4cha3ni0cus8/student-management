package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @Test
    public void testGetAllStudents() {
        Student student = new Student("1", "Ivan", "Ivanov", "Ivanovich", "A1", 4.5);
        List<Student> studentList = Arrays.asList(student);
        when(studentService.getAllStudents()).thenReturn(studentList);

        List<Student> result = studentController.getAllStudents();

        assertEquals(1, result.size());
        assertEquals(student, result.get(0));
    }

    @Test
    public void testGetStudentById() {
        Student student = new Student("1", "Ivan", "Ivanov", "Ivanovich", "A1", 4.5);
        when(studentService.getStudentById("1")).thenReturn(Optional.of(student));

        ResponseEntity<Student> result = studentController.getStudentById("1");

        assertEquals(200, result.getStatusCodeValue());
        assertEquals(student, result.getBody());
    }

    @Test
    public void testAddOrUpdateStudent() {
        Student student = new Student("1", "Ivan", "Ivanov", "Ivanovich", "A1", 4.5);
        when(studentService.saveStudent(student)).thenReturn(student);

        Student result = studentController.addOrUpdateStudent(student);

        assertEquals(student, result);
    }

    @Test
    public void testDeleteStudent() {
        doNothing().when(studentService).deleteStudent("1");

        studentController.deleteStudent("1");

        verify(studentService, times(1)).deleteStudent("1");
    }
}
