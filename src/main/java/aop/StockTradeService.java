package aop;

import org.springframework.stereotype.Service;

@Service
public class StockTradeService {
	public void trade() {
		System.out.println("You bought/sold stock!");
		throw new RuntimeException();
	}
	
	public void log() {
		System.out.println("I'm a log statement!");
	}
}
