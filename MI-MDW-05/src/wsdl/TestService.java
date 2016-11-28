package wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class TestService {

	@WebMethod(operationName="h")
	public String hello(@WebParam(name="name") String name) {
		return "Hello " + name;
	}
	
	public int compute(int a, int b) {
		return a + b/2;
	}
	
}
