package part03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	public IndexController() {

	}
	
	//http://localhost:8090/myapp/index.do
	@RequestMapping(value="index.do")
	public String process() {
		return "part03/index";
	}//end process()
}//end class
