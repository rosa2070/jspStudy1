package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FirstListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		// 웹 컨테이너 삭제시 발생
		System.out.println( "FirstListener contextDestroyed 호출");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub


		// 웹 컨테이너 시작시 발생
		System.out.println( "FirstListener contextInitialized 호출");
	}
	
}
