package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class EncodingFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * Request 처리 
		 */
		request.setCharacterEncoding("utf-8");
		
		System.out.println("EncodingFilter.doFilter()");
		chain.doFilter(request, response);	//필터체인 - 관심의 분리 
		
		/*
		 * Response 처리 
		 */
	}


}
