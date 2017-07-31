package myPack;

/*
 * Write a program that will compute an Employee's salary and manage their leave details.
 */

public class Assignment3 {
	public static void main(String[] args) {// Main methods starts
		PermenantEmp p=new PermenantEmp(1, "subra", 50000);
		p.calculate_salary();
		p.avail_leave(2, 'p');
		p.avail_leave(14, 'p');
		p.print_leave_details();
		p.calculate_balance_leaves();
		
		
		TemporaryEmp t = new TemporaryEmp(12, "Rohit", 20000);
		t.calculate_salary();
		t.avail_leave(5, 'p');
		t.calculate_balance_leaves();
		
		
	}

}

abstract class Employee{
	int empId;
	String empName;
	int total_leaves;
	double total_salary;
	
	abstract void calculate_balance_leaves();
	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	abstract void calculate_salary();
}

class PermenantEmp extends Employee{
	int paid_leave, sick_leave, casual_leave;
	double basic, hra,pfa;
	
	
	public PermenantEmp(int empId, String empName, double basic) {
		this.empId=empId;
		this.empName=empName;
		this.basic = basic;
		paid_leave=10;
		sick_leave=4;
		casual_leave=5;
		total_leaves=10+4+5;//19
		// different type of leaves are set to each employee
	}

	
	void calculate_balance_leaves() {
		System.out.println("Total avalable leaves are: "+(paid_leave+sick_leave+casual_leave));
		
	}

	
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		if (type_of_leave=='p'){
			if(paid_leave-no_of_leaves>=0){
				total_leaves-=no_of_leaves;
				paid_leave-=no_of_leaves;
				return true;
			}
			else { System.out.println("You can't get leave!! ");
				return false;
			}
		}
		else if(type_of_leave=='s'){
			if(sick_leave-no_of_leaves>=0){
				total_leaves-=no_of_leaves;
				sick_leave-=no_of_leaves;
				return true;
			}
			else{ System.out.println("You can't get leave!! ");
			return false;
		}
		}
		else if(type_of_leave=='c'){
			if(casual_leave-no_of_leaves>=0){
				casual_leave-=no_of_leaves;
				total_leaves-=no_of_leaves;
				return true;
			}
				
			else{ System.out.println("You can't get leave!! ");
			return false;
		}
		}
		System.out.println("You can't get leave!! ");
		return false;
	}

	
	void calculate_salary() {
		pfa = .12*basic;
		hra = .5 *basic;
		total_salary = basic + (.5 *basic)-(.12*basic);
		System.out.println("Total salary of "+this.empName+ "'s is :"+ total_salary);
		
	}


	void print_leave_details(){
		System.out.println("PermenantEmp [paid_leave=" + paid_leave + ", sick_leave=" + sick_leave + ", casual_leave="
				+ casual_leave + "]");
	}
	
}

class TemporaryEmp extends Employee{
	public TemporaryEmp(int empId, String empName, double total_salary) {
		this.empId=empId;
		this.empName=empName;
		this.total_salary=total_salary;
		this.total_leaves=14;
		// there is only 14 leaves available for the Temporary employees 
	}

	
	void calculate_balance_leaves() {
		System.out.println("Total available leaves are:"+total_leaves);
		
	}

	
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		if (no_of_leaves<=total_leaves){
			total_leaves-=no_of_leaves;
			return true;
		}
		return false;
	}

	
	void calculate_salary() {
		double total_sal = total_salary + (.5 *total_salary)-(.12*total_salary);
		System.out.println("Total salary of "+this.empName+ "'s is :"+ total_sal);
		
	}
	
}//class closed