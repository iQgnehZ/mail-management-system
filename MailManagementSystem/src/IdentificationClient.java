import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class IdentificationClient {
	private static IdentificationClient  instance=null;
	private HashMap<String, String> clients= new HashMap<String, String>();
	private IdentificationClient(){
		clients.put("a", "a");
		clients.put("b", "b");
		clients.put("c", "c");
    }
	public static IdentificationClient newInstance(){
	   	if (instance==null){
	   		synchronized(IdentificationClient.class){
	   			if(instance == null){
	       			instance=new  IdentificationClient();
				}
	   		}
	 	}	
	   	return instance;       
	}
	
	public HashMap<String, String> getClients() {
		return clients;
	}

	public void addClient(String login, String password) {
		clients.put(login, password);
	}	
	
	public static void main(String[] args){
		IdentificationClient clientInfo = new IdentificationClient();
		clientInfo.addClient("d", "d");
		System.out.println(clientInfo.getClients());
	}
}
