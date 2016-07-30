package com.xml.thread2;

public class Stage extends Thread {
	@Override
	public void run() {
		System.out.println("欢迎观看隋唐演义");
		//先等几分钟广告咯
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("嘘嘘大幕拉开");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("话说隋唐末年。中原大乱。。。。");
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		//使用Runnable接口创建线程
		Thread armySuiDynasty =new Thread(armyTaskOfSuiDynasty,"隋军");
		Thread armyofRevolt = new Thread(armyTaskOfRevolt,"农民起义军");
		
		//启动线程，让军队开始作战
		armySuiDynasty.start();
		armyofRevolt.start();
		
		//舞台线程休眠，大家请观看吧
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("正当双方激战正酣的时候，半路杀出了一个成牙惊");
		
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		System.out.println("程胖子的志向就是推翻隋朝统治");
		
		//停止军队作战
		//停止线程的方法
		armyTaskOfSuiDynasty.keeprunning = false;
		armyTaskOfRevolt.keeprunning = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * 历史大戏留给关键人物哟
		 */
		mrCheng.start();
		
		//万众瞩目，等待程先生完成使命
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The war was end");
		System.out.println("Thank you");
	}
	public static void main(String[] args) {
		new Stage().start();
	}
}
