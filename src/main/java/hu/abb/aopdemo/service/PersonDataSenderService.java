package hu.abb.aopdemo.service;

import java.util.concurrent.TimeoutException;
import org.springframework.stereotype.Service;
import hu.abb.aopdemo.util.Utils;

@Service
public class PersonDataSenderService {
	public void send(Object object) throws TimeoutException{
		if(Math.random() > 0.7){
			System.out.println("Data has been sent successfully");
		}else{
			Utils.sleep(1000);
			throw new TimeoutException("Connection timed out");
		}
	}
}
