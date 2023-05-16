package gdu.kr.chap2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		//ApplicationContext : 컨테이너.
		//annotation.xml 에 정의된 객체를 미리 생성함.
		/* ctx에 저장된 객체
		 * 1. SmartPhoneView 객체 => Viewer @Component
		 * 2. SmsAlarmDevice 객체 => AlarmDevice @Component
		 * 3. DisplayMode 객체 => xml에서 설정
		 * 4. Camera 객체 => 4개 객체. xml에서 설정
		 * 5. InfraredRaySensor 객체 => 3개.  xml 설정
		 * 6. HomeController 객체 => 1개. @Component
		 * 7. Executor 객체 =>1개 @Component
		 * 8. Worker 객체 => 1개 @Component
		 * 
		 * GenericXmlApplicationContext : ApplicationContext의 구현클래스
		 * ApplicationContext : 인터페이스. 객체를 미리 생성
		 * 						annotation.xml 정으된 객체들을 미리 생성하여 저장
		 * WebApplicationContext : ApplicationContext 의 하위 인터페이스
		 * 						=> ApplicationContext + Web 기능
		 */
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:annotation.xml");
		Executor exec = ctx.getBean("executor",Executor.class);
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
		HomeController home = ctx.getBean("homeController", HomeController.class);
		home.checkSensorAndAlrm(); // consloe 출력 부분없음
		System.out.println("창문에 침입자 발견");
		InfraredRaySensor sensor 
		= ctx.getBean("windowSensor", InfraredRaySensor.class);
		sensor.foundObject(); // windowSensor objectFound=true
		home.checkSensorAndAlrm(); // 창문센서
		System.out.println("현관에 침입자 발견");
//		InfraredRaySensor doorsensor = new InfraredRaySensor("현관센서");
		InfraredRaySensor doorsensor 
		= ctx.getBean("doorSensor", InfraredRaySensor.class);
		doorsensor.foundObject();
		home.checkSensorAndAlrm(); // 창문센서에서 침입자 탐지. 신고요망
									// 현관센서에서 침입자 탐지. 신고요망			
	}	
}
