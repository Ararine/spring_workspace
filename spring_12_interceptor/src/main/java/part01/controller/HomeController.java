package part01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {

	}

	//http://localhost:8090/myapp/list.do
	@RequestMapping(value="/list.do")
	public String listProcess() {
		System.out.println("list controller");
		return "part01/list";
	}//end listProcess()
	
	//http://localhost:8090/myapp/view.do
	@RequestMapping(value="/view.do")
	public String viewProcess() {
		System.out.println("view controller");
		return "part01/view";
	}//end viewProcess()
	
	//http://localhost:8090/myapp/write.do
	@RequestMapping(value="/write.do")
	public String writeProcess() {
		System.out.println("write controller");
		return "part01/write";
	}//end writeProcess()
	
}//end class
