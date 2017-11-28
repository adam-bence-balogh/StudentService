package hu.bab.aopdemo.studentservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hu.bab.aopdemo.entity.Device;
import hu.bab.aopdemo.entity.DeviceType;
import hu.bab.aopdemo.entity.Producer;

public class Main2 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hu.bab");
		Device galaxyS7 = applicationContext.getBean(Device.class);
		galaxyS7.setDeviceType(DeviceType.PHONE);
		galaxyS7.setProducer(Producer.SAMSUNG);
		galaxyS7.setSerialNumber(12345);
	}
}
