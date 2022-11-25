package part04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:8090/myapp/booksearch.do

@Controller
public class SearchDaumController {

	public SearchDaumController() {

	}

	@RequestMapping(value = "/booksearch.do", method = RequestMethod.GET) 
	public String form() {
		return "part04/form";
	}// end form()

	@ResponseBody
	@RequestMapping(value="/searchOpen.do", method=RequestMethod.GET)
	public String process(String query) throws MalformedURLException, IOException {
		/*curl -v -X GET "https://dapi.kakao.com/v3/search/book?target=title" \
			--data-urlencode "query=미움받을 용기" \
			-H "Authorization: KakaoAK ${REST_API_KEY}"
		*/
		String url = "https://dapi.kakao.com/v3/search/book?target=title&query=" + URLEncoder.encode(query, "UTF-8");
		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection(); //연결
		con.setRequestProperty("Authorization", "KakaoAK 118894c41844b11bc6fc7b443dae0687");
		con.setRequestMethod("GET"); //방식 설정
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input = null;
		String total = "";
		while((input = reader.readLine())!=null) {
			total += input;
		}
		System.out.println(total);
			return total;
	}// end process()

}// end class
