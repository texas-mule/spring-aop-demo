package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StockTradeAspect {
	@Before("execution(* aop.StockTradeService.trade(..))")
	public void payFee() {
		System.out.println("You paid the broker a fee!");
	}
	
	@After("within(aop.*)")
	public void portfolioUpdate(JoinPoint jp) {
		StockTradeService sts = (StockTradeService) jp.getTarget();
		sts.log();
		System.out.println("You've updated your portfolio!");
	}
	
	//@AfterThrowing(pointcut="execution(* *ade(..))")
	public void oops() {
		System.out.println("OOPS");
	}
	
	@AfterReturning("execution(* *(..))")
	public void success() {
		System.out.println("SUCCESS!");
	}
	
	@Around("execution(* *ade(..))")
	public void aroundTrade(ProceedingJoinPoint jp) {
		System.out.println("You're about to trade!");
		try {
			jp.proceed();
		} catch (Throwable ex) {
			oops();
		}
		System.out.println("You've traded!");
	}
}
