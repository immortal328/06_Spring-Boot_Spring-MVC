package ap.immortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ap.immortal.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/showStudentForm")
	public String showStudentsForm(Model model) {	
		model.addAttribute("student", new Student());
		return "student/student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processStudentForm(@ModelAttribute("student") Student student) {		
		System.out.println("Student Details : " + student.getFirstName()+" "+student.getLastName());		
		return "student/student-display";
	}

}
