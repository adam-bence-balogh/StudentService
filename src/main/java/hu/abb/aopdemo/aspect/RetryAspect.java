package hu.abb.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import hu.abb.aopdemo.util.Utils;

@Component
@Aspect
public class RetryAspect {
	@Around("execution(* hu.abb.aopdemo.service.PersonDataSenderService.*(..)))")
	public void retrySending(ProceedingJoinPoint proceedingJoinPoint){
		boolean sendedSuccessfully = false;
		while(sendedSuccessfully != true) {
			try {
				proceedingJoinPoint.proceed();
				sendedSuccessfully = true;
				System.out.println("Data has beent sent");
			} catch(Throwable t) {
				System.out.println(t);
				Utils.sleep(1000);
			}
		}
	}
}
