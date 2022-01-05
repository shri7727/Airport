package com.project;


// some changes


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;

public class Test {
	Scanner scr=new Scanner(System.in);
	void disp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			PreparedStatement ps=con2.prepareStatement("select * from test");
			ResultSet rs=ps.executeQuery();
			
			System.out.println("********************Test Details**********************");
			System.out.println("Test id\t\tTest type\t\tVarient\t\tResult\t\tPassport Number");
			while(rs.next()) {
				
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	void ad() {
		try {
			String uid1=null;
			String pass1=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			//System.out.println("class found");
			
				System.out.println(".....Welcome....");
				System.out.println("press 1 for Test Details");
				System.out.println("press 2 for Updating Test details");
				System.out.println("press 3 for Deleting Test details");
				System.out.println("press 4 for Adding new Test details");
				System.out.println("press 5 to return on main page");
				int ch=scr.nextInt();
				switch (ch) {
				case 1:disp();
					break; 
				case 2:
					
					System.out.println("press 1 for Updating Test type");
					System.out.println("press 2 for Updating Varient");
					System.out.println("press 3 for Updating Result");
					int ch1=scr.nextInt();
					switch (ch1) {
					case 1:
						PreparedStatement pst1=con.prepareStatement("update test set testType=? where testId=?  ");
						System.out.println("Enter the test Id");
						String testId=scr.next();
						System.out.println("Enter new test type for test "+testId);
						String testType=scr.next();
						pst1.setString(1, testType);
						pst1.setString(2, testId);
						int rs1=pst1.executeUpdate();
						if(rs1>0) {
							System.out.println("Updated successfully.....");
						}
						else {
							System.out.println("Something went wrong!!!");
						}
						break;
					case 2:PreparedStatement pst2=con.prepareStatement("update test set varient=? where testId=?  ");
						System.out.println("Enter the test Id");
						String testid1=scr.next();
						System.out.println("Enter new varient for test "+testid1);
						String varient=scr.next();
						pst2.setString(1, varient);
						pst2.setString(2, testid1);
						int rs2=pst2.executeUpdate();
						if(rs2>0) {
							System.out.println("Updated successfully.....");
						}
						else {
							System.out.println("Something went wrong!!!");
						}
						break;
						
					case 3:
						PreparedStatement pst3=con.prepareStatement("update test set result=? where testId=?  ");
						System.out.println("Enter the test Id");
						String testid2=scr.next();
						System.out.println("Enter new result for test "+testid2);
						String  result=scr.next();
						pst3.setString(1,  result);
						pst3.setString(2, testid2);
						int rs3=pst3.executeUpdate();
						if(rs3>0) {
							System.out.println("Updated successfully.....");
						}
						else {
							System.out.println("Something went wrong!!!");
						}
						break;
						
							
					default:
						break;
					}
					break;
				case 3:
					PreparedStatement pst6=con.prepareStatement("delete from test where testId=?  ");
					System.out.println("Enter the test id to delete the record");
					String testid7=scr.next();
					int rs6=pst6.executeUpdate();
					if(rs6>0) {
						System.out.println("Record deleted successfully.....");
					}
					else {
						System.out.println("Something went wrong!!!");
					}
					break;
				case 4:
					PreparedStatement pst7=con.prepareStatement("insert into test values(?,?,?,?,?)");
					System.out.println("Enter test id");
					String testId9=scr.next();
					System.out.println("Enter test type");
					String testType=scr.next();
					System.out.println("Enter Varient");
					String varient=scr.next();
					System.out.println("Enter the result");
					String result=scr.next();
					System.out.println("Enter Passport number");
					String pno=scr.next();
					
					pst7.setString(1, testId9);
					pst7.setString(2, testType);
					pst7.setString(3, varient);
					pst7.setString(4, result);
					pst7.setString(5, pno);
					int rs7=pst7.executeUpdate();
					if(rs7==1) {
						System.out.println("Record Added successfully.....");
					}
					else {
						System.out.println("Something went wrong!!!");
					}
					break;
				case 5:
						Project p=new Project();
						p.adminPage();
						break;
				default:
					System.out.println("Enter valid choice");
					break;
					//throw new IllegalArgumentException("Unexpected value: " + ch);
				}
			
		
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
}



