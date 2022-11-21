package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8090/myapp.menu2.do

@Controller
public class Menu2Controller {

	@RequestMapping(value="/menu2.do")
	public String execute() {
		return "menu2";
	}//end execute()
}//end class
