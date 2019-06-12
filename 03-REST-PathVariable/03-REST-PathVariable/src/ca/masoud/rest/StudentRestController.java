package ca.masoud.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.masoud.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	//.....................................
	private List<Student> theStudents;
	
	// We want to create the list of students only one time
	// in previous approach by each request every time new array of students was built
	// with @PostConstruct student initialization will happened only one time
	@PostConstruct
	public void loadData() {

		theStudents = new ArrayList<>();

		theStudents.add(new Student("Sheldon", "Couper"));
		theStudents.add(new Student("Penny", "Rossi"));
		theStudents.add(new Student("Leonard", "Smith"));
	}
	
	// define end point for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	

	// http://localhost:8080/03-REST-PathVariable/api/students/1
	// One at the end of URL is studentId and can be changed to other numbers
	// define end point for "/students/{studentId}" - return one student based on Id
	// {studentId} is a path variable
	// studentId in the path at @GetMapping should be the same as method argument
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return theStudents.get(studentId);
	}
	//.....................................
}
