package part01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * preHandle() - 요청 컨트롤러에 들어가기전 접근
 * postHanlde() - 요청 컨트롤러 접근 후 View 페이지 접근 전
 * afterCompletion() - 요청 컨트롤러 접근 후 View 페이지 접근 후 response 하기 전
 */
public class SampleInterceptor extends HandlerInterceptorAdapter{

	public SampleInterceptor() {

	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle...");
		return true; //정상적으로 작동하면 다음 동작을 실행하기 위해 true 값을 준다.
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle...");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion...");
	}
		
}
