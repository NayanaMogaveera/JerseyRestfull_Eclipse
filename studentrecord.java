package net.codejava.ws;

import java.util.List;
import java.util.ArrayList;

public class studentrecord {
	private static studentrecord instance;
	private static List<student> data = new ArrayList<>();
	
	static {
		data.add(new student(101,"Nayana","1998-jan-12","2003-apr-13"));
		data.add(new student(102,"Navya","1998-jan-13","2003-apr-23"));
	}
	private studentrecord() {}
	
	public static studentrecord getInstance() {
		if(instance == null) {
			instance = new studentrecord();
		}
		return instance;
		
	}
	
	public List<student> listAll(){
		
		return new ArrayList<student>(data);
	}
	public int  add(student stud) {
		int newid = data.size()+1;
		stud.setId(newid);
		data.add(stud);
		return newid;
	}
	
	public student get(int id) 
	{
		student studToFind = new student(id);
		int index=data.indexOf(studToFind);
		if(index>=0) {
			return data.get(index);
	
		}
		return null;
	}
	public boolean update(student stud)
	{
		int index = data.indexOf(stud);
		if(index>=0) 
		{
			data.set(index, stud);
			
			return true;
			
		}
		return false;
	}
	public boolean delete(int id)
	{
		student studToFind = new student(id);
		int index=data.indexOf(studToFind);
		if(index>=0)
		{
			
			data.remove(index);
			return true;
	
		}
		return false;
		
	}
}
