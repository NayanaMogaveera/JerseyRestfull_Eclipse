package net.codejava.student;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class studentdetail {
	private static String baseURI="http://localhost/MyWebsite/rest/students";
	
	public static void main(String[] args)
	{
		testList();	
		testAdd();
		testList();
		testUpdate();
		
	}
	static void testAdd()
	{
		WebTarget target = getWebTarget();
		student stud=new student("jhon","1998-jan-17","2003-apr-20");
		Response response = target.request().post(
				Entity.entity(stud,MediaType.APPLICATION_JSON),
		Response.class);
		System.out.println(response);
			
	}
	
	static void testUpdate()
	{
		WebTarget target = getWebTarget();
		String studid="101";
		student stud=new student("Ram","1998-jan-17","2003-apr-20");
		Response response = target.path(studid)
							.request()
							.put(Entity.entity(stud,MediaType.APPLICATION_JSON),
							Response.class);
		System.out.println(response);
			
	}
	static void testDelete()
	{
		WebTarget target = getWebTarget();
		String studid="101";
		Response response = target.path(studid)
							.request().delete(Response.class);
		System.out.println(response);
	}
	
	
	
	static void testGet()
	{
		WebTarget target = getWebTarget();
		String studid = "1";
		student stud = target.path(studid)
						.request()
						.accept(MediaType.APPLICATION_JSON).get(student.class);
		
		System.out.println(stud);
		
	}
	static void testList() {
			WebTarget target = getWebTarget();
			String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
				
			System.out.println(response);
	}
	static WebTarget getWebTarget()
	{
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		return client.target(baseURI);
	}

}
