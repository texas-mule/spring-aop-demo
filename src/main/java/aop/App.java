package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
		StockTradeService sts = ac.getBean("stockTradeService", StockTradeService.class);
		sts.trade();
		// sts.log();
		((AbstractApplicationContext) ac).close();
	}

}
