package ap.immortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ap.immortal.model.Student;
import jakarta.validation.Valid;

@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String>  countries;
	
	@Value("${languages}")
	private List<String>  languages; 
	
	@Value("${systems}")
	private List<String>  systems; 
	
	
	/*
	 * This Methid handle empty String validation
	 * Added an initbinder ... to convert trim input strings
     * Remove leading and trailing whitespace
     * Resolve issue for our validation
	 **/
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	
	@GetMapping("/")
	public String showStudentsForm(Model model) {	
		model.addAttribute("student", new Student());
		model.addAttribute("countries",countries);
		model.addAttribute("languages",languages);
		model.addAttribute("systems",systems);
		return "student/student-form";
	}
	
	
	@PostMapping("/processStudentForm")
	public String processStudentForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("-->"+ bindingResult);
            return "student/student-form";
        }
        else {
    		System.out.println("Student Details : " + student.getFirstName()+" "+student.getLastName());
            return "student/student-confirmation";
        }
	}

}
