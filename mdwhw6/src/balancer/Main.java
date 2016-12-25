package balancer;

import java.io.IOException;

public class Main implements Runnable {

	@Override
	public void run() {
		LoadBalancer balancer = LoadBalancer.getInstance();
		balancer.addUrl("http://147.32.233.18:8888/MI-MDW-LastMinute1/list");
		balancer.addUrl("http://147.32.233.18:8888/MI-MDW-LastMinute2/list");
		balancer.addUrl("http://147.32.233.18:8888/MI-MDW-LastMinute3/list");
		
		try {
			while (true) {
				//check every five minutes
				balancer.checkResourcesAvailability();
				Thread.sleep(60 * 5 * 1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("error while checking resources availability");
			e.printStackTrace();
		}
	}

}
