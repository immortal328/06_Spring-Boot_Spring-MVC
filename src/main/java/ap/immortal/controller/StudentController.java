package ap.immortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ap.immortal.model.Student;

@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String>  countries;
	
	@Value("${languages}")
	private List<String>  languages;
	
	
	@GetMapping("/showStudentForm")
	public String showStudentsForm(Model model) {	
		model.addAttribute("student", new Student());
		model.addAttribute("countries",countries);
		model.addAttribute("languages",languages);
		return "student/student-form";
	}
	
	
	@PostMapping("/processStudentForm")
	public String processStudentForm(@ModelAttribute("student") Student student) {		
		System.out.println("Student Details : " + student.getFirstName()+" "+student.getLastName());		
		return "student/student-confirmation";
	}

}
