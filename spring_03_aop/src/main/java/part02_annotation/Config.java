package part02_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //환경설정을 java로 설정하기 위해 사용
@EnableAspectJAutoProxy
public class Config {
	public Config() {

	}
	
	@Bean //(name="svc") - 설정 방법
	public ServiceImp svc() {
		return new ServiceImp();
	}
	
	@Bean
	public AdviceCommon common() {
		return new AdviceCommon();
	}
}
