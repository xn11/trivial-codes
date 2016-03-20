package loanP191;

import java.util.Date;

public class Loan {
	private double annualIterestGate,loanAmount;
	private int numberOfYears;
	private Date loanDate;
	
	public Loan(){
		this(7.5,30,100);
	}
	
	public Loan(double annualIterestGate,int numberOfYears,double loanAmount){
		this.annualIterestGate=annualIterestGate;
		this.numberOfYears=numberOfYears;
		this.loanAmount=loanAmount;
		loanDate=new Date();
	}

	public double getAnnualIterestGate() {
		return annualIterestGate;
	}

	public void setAnnualIterestGate(double annualIterestGate) {
		this.annualIterestGate = annualIterestGate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	

}
