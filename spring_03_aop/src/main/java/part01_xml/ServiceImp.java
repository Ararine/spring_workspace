package part01_xml;

import java.util.Random;

//핵심 로직만 구현해 놓은 클래스 - Target
public class ServiceImp implements Service{

	public ServiceImp() {

	}

	@Override
	public void prn1() {
		System.out.println("prn");
	}

	@Override
	public void prn1(int x) {
		System.out.println("x:" + x);
	}

	@Override
	public void prn1(Random ran) {
		System.out.println(ran.nextDouble());
	}

	@Override
	public void prn1(int a, int b) {
		System.out.printf("a=%d, b=%d\n", a, b);
	}

	@Override
	public void prn2() {
		
	}

	@Override
	public String prn3() {
		return null;
	}

	@Override
	public void prn4() {
		
	}

	@Override
	public void prn5() {
		
	}
	
	
}
