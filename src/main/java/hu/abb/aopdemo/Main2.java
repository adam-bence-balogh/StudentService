package hu.abb.aopdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hu.abb.aopdemo.entity.Device;
import hu.abb.aopdemo.entity.DeviceType;
import hu.abb.aopdemo.entity.Producer;

public class Main2 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hu.abb");
		Device galaxyS7 = applicationContext.getBean(Device.class);
		galaxyS7.setDeviceType(DeviceType.PHONE);
		galaxyS7.setProducer(Producer.SAMSUNG);
		galaxyS7.setOperatingSystem("KitKat");
	}
}
