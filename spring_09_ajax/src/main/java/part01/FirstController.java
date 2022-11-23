package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8090/myapp/first.do

@Controller
public class FirstController {

	public FirstController() {

	}
	
	@RequestMapping(value="/first.do")
	public String excute() {
		return "part01/first";
	}
}
