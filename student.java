package net.codejava.student;

import java.util.Objects;

public class student {
	
	private int id;
	private String name;
	private String DOB;
	private String DOJ;
	
	public student()
	{
	}
	
	public student(int id)
	{
		
		this.id = id;
		
	}
	public student(int id, String name, String DOB, String DOJ)
	{
		this.id=id;
		this.name=name;
		this.DOB=DOB;
		this.DOJ=DOJ;
	}
	public student( String name, String DOB, String DOJ)
	{
		
		this.name=name;
		this.DOB=DOB;
		this.DOJ=DOJ;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		student other = (student) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", DOB=" + DOB + ", DOJ=" + DOJ + "]";
	}

}

