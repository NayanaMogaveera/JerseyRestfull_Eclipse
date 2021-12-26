package net.codejava.ws;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/students")
public class studentrecord1 
{
	private studentrecord stdr = studentrecord.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<student> list()
	{
		return stdr.listAll();
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(student stud) throws URISyntaxException
	{
		int newstudentid = stdr.add(stud);
		URI uri = new URI("/students/"+newstudentid);
		return Response.created(uri).build();
	}
	@GET
	@Path("{id}")
	public Response get(@PathParam("id")int id)
	{
		student stud = stdr.get(id);
		if(stud!=null)
		{
			return Response.ok(stdr,MediaType.APPLICATION_JSON).build();
		}
		else
		{
			return Response.status(Response.Status.NOT_FOUND).build();
			
		}
		
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id")int id, student stud)
	{
		stud.setId(id);
		if(stdr.update(stud))
		{
			return Response.ok().build();
		}
		else
		{
			return Response.notModified().build();
		}
	}
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id")int id)
	{
		if(stdr.delete(id))
		{
			return Response.ok().build();
		}
		else
		{
			return Response.notModified().build();
		}
	}
		
	}
	
