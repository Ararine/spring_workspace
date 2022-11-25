package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.MemDAO;
import dto.MemDTO;

//http://localhost:8090/myapp/mem/list


//@RestController = @Controller + @ResponseBody

//@CrossOrigin("*")	모든 포트 번호 허용//@CrossOrigin("http://localhost:3000") 3000번에 해당하는 포트 번호 허용
//포트 번호가 다르면 허용시킬 수 없다.

//@RestController
@Controller
public class MemController {

	private MemDAO dao;
	
	public MemController() {

	}
	
	public void setDao(MemDAO dao) {
		this.dao = dao;
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET) //검색 기능을 사용할 때는 method = get
	public List<MemDTO> listMethod() {
		System.out.println("list");
		return dao.list();
	}//end listMethod()
	
	////http://localhost:8090/myapp/mem/list/22
	@ResponseBody
	@RequestMapping(value="/list/{ss}", method=RequestMethod.GET) //{ss}에 해당하는 값을 받아
	public MemDTO listMethod(@PathVariable("ss") int num) { //num에 넣어줌
		return dao.list(num);
	}
	
////http://localhost:8090/myapp/mem/list/22/돌쟁이
	@ResponseBody
	@RequestMapping(value="/list/{ss}/{name}", method=RequestMethod.GET) //{ss}에 해당하는 값을 받아
	public MemDTO listMethod(@PathVariable("ss") int num, @PathVariable("name") String name) { //num에 넣어줌
		return dao.list(new MemDTO(num, name));
	}
	
	//{"name":"홍길동", "age":"30", "loc":"서울"}
	//http://localhost:8090/myapp/mem/insert
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ResponseEntity<String> insertMethod(@RequestBody MemDTO dto) {
		ResponseEntity<String> entity = null;
		try {
			dao.register(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK); //HttpStatus.OK = 200
		}catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); //HttpStatus.BAD_REQUEST = 400
		}
		return entity;
	}//end insertMethod()
	
	//{"num":22,"name":"Steven"}
	//http://localhost:8090/myapp/mem/update
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<String> updateMethod(@RequestBody MemDTO dto) {
		ResponseEntity<String> entity = null;
		
		try {
			dao.update(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//end updateMethod()
	
	//http://localhost:8090/myapp/mem/delete/22
	@RequestMapping(value="/delete/{num}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteMethod(@PathVariable("num") int num) {
		ResponseEntity<String> entity = null;
		
		try {
			dao.delete(num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}//end class
