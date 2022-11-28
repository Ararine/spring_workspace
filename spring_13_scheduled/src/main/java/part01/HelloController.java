package part01;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	public HelloController() {

	}
	
	//http://localhost:8090/myapp/main.do
	@RequestMapping(value="/main.do")
	public String execute() {
		return "part01/form";
	}//end execute
	
//	@Scheduled(fixedDelay=1000)
	public void scheduledProcess() {
		System.out.println(new Date() + "스케줄링 처리완료");
	}//end scheduledProcess()
}//end class
