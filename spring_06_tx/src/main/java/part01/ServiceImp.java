package part01;

import model.MemDAO;
import model.MemDTO;

public class ServiceImp implements Service{

	private MemDAO memDAO;
	
	public ServiceImp() {

	}

	public void setMemDAO(MemDAO memDAO) {
		this.memDAO = memDAO;
	}
	
	@Override
	public void insertProcess() {
		memDAO.insertMethod(new MemDTO(41, "용팔이", 50, "경기"));
		memDAO.insertMethod(new MemDTO(42, "유대위", 20, "대전"));
	}
}
