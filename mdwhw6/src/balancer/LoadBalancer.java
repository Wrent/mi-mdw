package balancer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
	private List<ResourceURL> urls;
	private int it = 0;
	private static LoadBalancer inst = null;
	
	public static LoadBalancer getInstance() {
		if (inst == null) {
			inst = new LoadBalancer();
		}
		return inst;
	}
	
	private LoadBalancer() {
		super();
		this.urls = new ArrayList<ResourceURL>();
		//this.addUrl("http://147.32.233.18:8888/MI-MDW-LastMinute1/list");
		//this.addUrl("http://147.32.233.18:8888/MI-MDW-LastMinute2/list");
		//this.addUrl("http://147.32.233.18:8888/MI-MDW-LastMinute3/list");
	}
	
	public void addUrl(String url) {
		ResourceURL rurl = new ResourceURL(url, -1);
		this.urls.add(rurl);
	}
	
	public String getValidUrl() {
		if (this.it >= this.urls.size()) {
			this.it = 0;
		}
		for (int i = 0; i < this.urls.size();i++) {
			ResourceURL url = urls.get((i + it) % this.urls.size());
			if (url.getStatus() == 1) {
				this.it = i + 1;
				System.out.println("returning "+url.getUrl());
				return url.getUrl();
			}
		}
		return null;
	}
	
	public int getPoolSize() {
		return urls.size();
	}
	
	public void checkResourcesAvailability() throws IOException {
		for (int i = 0; i < urls.size(); i++) {
			 ResourceURL resourceURL = urls.get(i);
			 String url = resourceURL.getUrl();
			 HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
			 connection.setRequestMethod("GET");
			 int code = connection.getResponseCode();
			 if (code == 200) {
				 System.out.println(resourceURL.getUrl() +" is ok");
				 resourceURL.setStatus(1);
			 } else {
				 System.out.println(resourceURL.getUrl() +" is not ok");
				 resourceURL.setStatus(0);
			 }
			 urls.set(i, resourceURL);
		}
	}
	
	
}
