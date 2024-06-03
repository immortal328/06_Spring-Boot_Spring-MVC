package ap.immortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	
	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	/**
	 * Using ${param.studentName} to print
	 * */
	@GetMapping("/processForm")
	public String processForm() {
		return "helloworlds";	
	}
	
	/**
	 * Method to process values of form
	 * using @HttpServletRequest req. and Set in @Model
	 * */
	@GetMapping("/v2/processForm")
	public String processFormV2(HttpServletRequest req , Model model) {		
		String name = req.getParameter("studentName");
		name = name.toUpperCase();
		String msg = "Yoo...! "+ name;
		model.addAttribute("msg", msg);		
		return "helloworlds";
	}
	
	/**
	 * Method to process values of form
	 * using @RequestParam and Set in @Model
	 * */
	@PostMapping("/requestParam/v2/processForm")
	public String processFormV2(@RequestParam String studentName , Model model) {		
		studentName = studentName.toUpperCase();
		String msg = "Yoo...! "+ studentName;
		model.addAttribute("msg", msg);	
			
		return "helloworlds";
	}

}
