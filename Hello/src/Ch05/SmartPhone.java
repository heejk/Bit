package Ch05;

public class SmartPhone extends PDA implements MP3Interface, MobilePhoneInterface {

	//MobilePhoneInterface 메소드 
	@Override
	public void sendCall() {
		System.out.println("전화 걸기");
	}

	@Override
	public void receiveCall() {
		System.out.println("전화 받기");
	}

	@Override
	public void sendSMS() {
		System.out.println("SMS 보내기");
	}

	@Override
	public void receiveSMS() {
		System.out.println("SMS 받기");
	}

	// MP3Interface 메소드 
	@Override
	public void play() {
		System.out.println("음악 재생");
	}

	@Override
	public void stop() {
		System.out.println("재생 중지");
	}
	
	// 새로운 메소드 추가 
	public void schedule() { 
		System.out.println("일정 관리");
	}

}
