import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

public class Customer {

	private int id;
	private String name;
	private String email;
	private String mobile;
	
	public Customer(int id,String name,String email,String mobile)
	{
		this.id=id;
		this.name=name;
		this.email=email;
		this.mobile=mobile;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		Customer[] ch=new Customer[10];
		ch[0]=new Customer(1,"Pratik","vamjapratik@","9739955577");
		ch[1]=new Customer(2,"Abhi","abhivi@","9876543211");
		ch[2]=new Customer(3,"Darshan","abcdarshan@","8763654789");
		ch[3]=new Customer(4,"Sahana","sahanaxyz@","9768798543");
		String loginId,password;
		System.out.println("Enter the Login ID and Password");
		loginId=sc.next();
		password=sc.next();
		if(loginId.equals("ABCCust") && password.equals("abc@123"))
		{
			int sel,l=4;
			System.out.println("1.Add \n 2.Edit \n3.Delete\n4.Display\n5.Exit");
			while(true)
			{
				System.out.println("Enter your choice");
				sel=sc.nextInt();
				switch(sel)
				{
					case 1:
						System.out.println("ADD");
						System.out.println("enter name,emil,mobile number");
						int id=l+1;
						String name=sc.next();
						String email=sc.next();
						String mobile=sc.next();
						l=l+1;
						
						if(l<10)
						{
							ch[l-1]=new Customer(id,name,email,mobile);
						}
						else
							System.out.println("array index out of bound");
						break;
					case 2:
						System.out.println("EDIT");
						System.out.println("Enter the id to be edited");
						int eid=sc.nextInt();
						System.out.println("enter new name,emil,mobile number");
						String ename=sc.next();
						String eemail=sc.next();
						String emobile=sc.next();
						ch[eid-1]=new Customer(eid,ename,eemail,emobile);
						break;
					case 3:
						System.out.println("DELETE");
						System.out.println("Enter the id to be deleted");
						int did=sc.nextInt();
						ch[did-1]=null;
						break;
					case 4:
						System.out.println("DISPLAY");
						System.out.println("The customer details are");
						for(int i=0;i<l;i++)
						{
							try{
								System.out.println(ch[i].getId()+"\t"+ch[i].getName()+"\t"+ch[i].getEmail()+"\t"+ch[i].getMobile()+"\t");
							}
							catch(NullPointerException e){
								continue;}
						}
						break;
					case 5:
						System.out.println("EXIT");
						System.exit(0);
						
						
						
				}
			}
		}
		sc.close();
	}

}
