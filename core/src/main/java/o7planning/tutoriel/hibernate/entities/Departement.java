package o7planning.tutoriel.hibernate.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="DEPARTEMENT", uniqueConstraints = {@UniqueConstraint(columnNames = {"DEPT_NO"})})
public class Departement {

	private int deptId;
	private String deptNo;	
	private String deptName;
	private String location;
	
	private Set<Employee> employees = new HashSet<Employee>(0);
	
	public Departement() {
		
	}

	public Departement(int deptId, String deptName, String location) {
		this.deptId = deptId;
		this.deptNo = "D" + this.deptId;
		this.deptName = deptName;
		this.location = location;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departement")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	
	
	@Id
	@Column(name = "DEPT_ID")
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	
	@Column(name = "DEPT_NO", length = 20, nullable = false)
	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	
	@Column(name = "DEPT_NAME", nullable = false)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	
	@Column(name = "LOCATION")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}
