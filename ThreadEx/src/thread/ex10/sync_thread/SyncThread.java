package thread.ex10.sync_thread;

class Anum {
	int num = 0;

	/*
	메서드에 synchronized를 주면 메서드 전체 연산이 끝날 때까지 동기화
	but, 일부 변수만 공유되고 있다면 공유 변수 연산 부분만 동기화 하는 것이 속도면에서 바람직 >> 해당 부분만 동기화  
	*/
	
	void accumulate (int val) {
		// 동기화 전 부분
		synchronized(this) {
			num += val;
		}
		// 동기화 후 부분
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

public class SyncThread {

	public static void main(String[] args) throws InterruptedException {
		Anum aNum = new Anum();
		Sum sum0 = new Sum(aNum, 1, 50);
		Sum sum1 = new Sum(aNum, 51, 100);
		Thread t0 = new Thread(sum0);
		Thread t1 = new Thread(sum1);
		
		t0.start();
		t1.start();
		
		t0.join();
		t1.join();
		
		
		System.out.println("1 ~ 100 accum = " + aNum.num);
	}

}
