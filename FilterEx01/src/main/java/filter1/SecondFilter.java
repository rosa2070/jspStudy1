package filter1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("SecondFilter init(FilterConfig filterConfig) 호출");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// 전처리 구간
		System.out.println("전처리 2");
		// jsp, 서블릿 실행
		arg2.doFilter(arg0, arg1);
		
		// 후처리 구간	
		System.out.println("후처리 2");
	}

}
