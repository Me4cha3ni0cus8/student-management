package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void testGetAllStudents() {
        Student student = new Student("1", "Ivan", "Ivanov", "Ivanovich", "A1", 4.5);
        List<Student> studentList = Arrays.asList(student);
        when(studentRepository.findAll()).thenReturn(studentList);

        List<Student> result = studentService.getAllStudents();

        assertEquals(1, result.size());
        assertEquals(student, result.get(0));
    }

    @Test
    public void testGetStudentById() {
        Student student = new Student("1", "Ivan", "Ivanov", "Ivanovich", "A1", 4.5);
        when(studentRepository.findById("1")).thenReturn(Optional.of(student));

        Optional<Student> result = studentService.getStudentById("1");

        assertEquals(true, result.isPresent());
        assertEquals(student, result.get());
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student("1", "Ivan", "Ivanov", "Ivanovich", "A1", 4.5);
        when(studentRepository.save(student)).thenReturn(student);

        Student result = studentService.saveStudent(student);

        assertEquals(student, result);
    }

    @Test
    public void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById("1");

        studentService.deleteStudent("1");

        verify(studentRepository, times(1)).deleteById("1");
    }
}
