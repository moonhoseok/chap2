package gdu.kr.chap2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SmartPhoneView implements Viewer{

	@Autowired
	private DisplayMode displayMode; //DisplayMode 객체 주입
	
	@Override
	public void add(Camera camera) {
		System.out.println("모니터에"+ camera + "영상추가");
	}
	
	@Override
	public void draw() {
		System.out.println(displayMode.getType()+"모드로 카메라 이미지 출력");
	}
}
