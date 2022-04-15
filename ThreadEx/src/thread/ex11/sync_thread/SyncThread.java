package thread.ex11.sync_thread;

class Anum {
	int accuNum = 0;
	int diffNum = 0;

	/* 
	t0/t1 thread는 accuNum 공유
	t2/t3 thread는 diffNum 공유
	>> 동기화 할 부분이 2개
	 */

	// lock키 객체를 2개 생성 (자물쇠)
	Object key0 = new Object();
	Object key1 = new Object();

	void accumulate (int val) {
		synchronized (key0) {
			accuNum += val;	
		}
	}

	void calcDiff (int val) {
		synchronized (key1) {
			diffNum -= val;
		}
	}

}

class Sum implements Runnable {
	Anum aNum;
	int start, end;

	Sum(Anum aNum, int start, int end) {
		this.aNum = aNum;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = start; i <= end; i++) 
			aNum.accumulate(i);
	}
}

class Minus implements Runnable {
	Anum aNum;
	int start, end;

	Minus(Anum aNum, int start, int end) {
		this.aNum = aNum;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = start; i <= end; i++) 
			aNum.calcDiff(i);
	}
}

public class SyncThread {

	public static void main(String[] args) throws InterruptedException {
		Anum aNum = new Anum();

		// 누적 합을 구하기 위한 thread
		Sum sum0 = new Sum(aNum, 1, 50);
		Sum sum1 = new Sum(aNum, 51, 100);
		Thread t0 = new Thread(sum0);
		Thread t1 = new Thread(sum1);

		// 누적 차를 구하기 위한 thread
		Minus minum0 = new Minus(aNum, 1, 50);
		Minus minum1 = new Minus(aNum, 51, 100);
		Thread t2 = new Thread(minum0);
		Thread t3 = new Thread(minum1);

		t0.start();
		t1.start();
		t2.start();
		t3.start();

		t0.join();
		t1.join();
		t2.join();
		t3.join();

		System.out.println("1 ~ 100 accum = " + aNum.accuNum);
		System.out.println("1 ~ 100 diff = " + aNum.diffNum);
	}

}
