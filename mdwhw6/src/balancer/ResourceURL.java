package balancer;

public class ResourceURL {
	private String url;
	private int status;
	
	public ResourceURL(String url, int status) {
		super();
		this.url = url;
		this.status = status;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
