package ap.immortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	
	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@GetMapping("/processForm")
	public String processForm() {
		return "helloworlds";
	}
	
	@GetMapping("/v2/processForm")
	public String processFormV2(HttpServletRequest req , Model model) {		
		String name = req.getParameter("studentName");
		name = name.toUpperCase();
		String msg = "Yoo...! "+ name;
		model.addAttribute("msg", msg);		
		return "helloworlds";
	}

}
