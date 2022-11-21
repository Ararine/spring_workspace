package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8090/myapp/menu1.do

@Controller
public class Menu1Controller {

	@RequestMapping("/menu1.do")
	public String execute() {
		return "menu1";
	}
}
