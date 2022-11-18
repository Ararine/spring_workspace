package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemController {

	private Service svc;
	
	public MemController() {

	}
	
	public void setSvc(Service svc) {
		this.svc = svc;
	}
	
	@RequestMapping("/firstmain.st")
	public void execute() {
		System.out.println("execute");
		svc.insertProcess();
	}
}
