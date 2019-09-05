package fr.formation.inti.entities;

public class ShortEmpInfo_PetitEmployee {

	  private Long empId;
	    private String empNo;
	    private String empName;
	 
	    public ShortEmpInfo_PetitEmployee(Long empId, String empNo, String empName) {
	        this.empId = empId;
	        this.empNo = empNo;
	        this.empName = empName;
	    }
	 
	    public Long getEmpId() {
	        return empId;
	    }
	 
	    public void setEmpId(Long empId) {
	        this.empId = empId;
	    }
	 
	    public String getEmpNo() {
	        return empNo;
	    }
	 
	    public void setEmpNo(String empNo) {
	        this.empNo = empNo;
	    }
	 
	    public String getEmpName() {
	        return empName;
	    }
	 
	    public void setEmpName(String empName) {
	        this.empName = empName;
	    }
	 
	}
