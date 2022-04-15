package thread.ex01.no_thread;

public class NoThread {

	public static void study() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println("studing in caffe");
			Thread.sleep(500);
		}
	}
	
	public static void music() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println("hearing the music in caffe");
			Thread.sleep(500);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		study();
		music();
	}

}
