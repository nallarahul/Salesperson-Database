package Miniprojects;
import java.util.*;
class SalesPerson 
{
    int id;
    double amt;
    public SalesPerson(int id,double amt)
    {
        this.id=id;
        this.amt=amt;
    }
    public int getId()
    {
        return(this.id);
    }
    public double getAmt()
    {
        return(this.amt);
    }
}
class IdComparator implements Comparator<SalesPerson>
{
    public int compare(SalesPerson ob1,SalesPerson ob2)
    {
        if(ob1.id==ob2.id)
            return(0);
        else if(ob1.id>ob2.id)
            return(1);
        else
            return(-1);
    }
}
class SalesComparator implements Comparator<SalesPerson>
{
    public int compare(SalesPerson ob1,SalesPerson ob2)
    {
        if(ob1.amt==ob2.amt)
            return(0);
        else if(ob1.amt>ob2.amt)
            return(-1);
        else
            return(1);
    }
}
public class Application
{
    public static void main(String args[])
    {
        ArrayList<SalesPerson> list=new ArrayList<SalesPerson>();
        Scanner sc=new Scanner(System.in);
        int i,op,temp,index=0;
        double sales;
        char opt='Y';
        System.out.println("*************WELCOME TO SALESPERSON DATABASE*************");
        for(int a=1;a<=5;a++)
        {
            System.out.print("ID = ");
            i=sc.nextInt();
            System.out.print("Sales Amount = ");
            sales=sc.nextDouble();
            list.add(new SalesPerson(i, sales));
        }
        while(opt=='y' || opt=='Y')
        {
            System.out.println("1.Add\n2.Delete\n3.Update\n4.Display");
            System.out.print("Choose your option = ");
            op=sc.nextInt();
            if(op==1)
            {
                temp=0;
                if(list.size()==5)
                    System.out.println("Database is full...New records cannot be added.");
                else
                {
                    System.out.print("ID = ");
                    i=sc.nextInt();
                    for(SalesPerson ob:list)
                    {
                        if(ob.getId()==i)
                        {
                            System.out.println("ID is already present !!");
                            temp=1;
                            break;
                        }
                    }
                    if(temp==0)
                    {
                        System.out.print("Sales Amount = ");
                        sales=sc.nextDouble();
                        list.add(new SalesPerson(i, sales));
                    }
                }
            }
            else if(op==2)
            {
                temp=0;
                if(list.size()==0)
                {
                    System.out.println("Database is already empty !!");
                }
                else
                {
                    System.out.print("ID = ");
                    i=sc.nextInt();
                    for(SalesPerson ob:list)
                    {
                        if(ob.getId()==i)
                        {
                            index=list.indexOf(ob);
                            temp=1;
                            break;
                        }
                    }
                    if(temp==1)
                    {
                        list.remove(index);
                    }
                    else
                        System.out.println("Entered Id is not present in the database.");
                }
            }
            else if(op==3)
            {
                temp=0;
                if(list.size()==0)
                    System.out.println("Database is empty...");
                else
                {
                    System.out.print("ID = ");
                    i=sc.nextInt();
                    for(SalesPerson ob:list)
                    {
                        if(ob.getId()==i)
                        {
                            index=list.indexOf(ob);
                            temp=1;
                            break;
                        }
                    }
                    if(temp==1)
                    {
                        System.out.print("Sales Amount = ");
                        sales=sc.nextDouble();
				list.remove(index);
                        list.add(index,new SalesPerson(i, sales));
                    }
                    else
                    {
                        System.out.println("Entered Id is not present in the database.");
                    }
                }
            }
            else if(op==4)
            {
                Collections.sort(list,new SalesComparator());
                for(SalesPerson ob:list)
                    System.out.println(ob.getId()+" "+ob.getAmt());
		    System.out.println("Do you want to continue ?");
                System.out.println("1.Yes---->Y\n2.No---->N");
                opt=sc.next().charAt(0);
                continue;
            }
            else
            {
                System.out.println("Invalid option...please try again !!");
                continue;
            }
            Collections.sort(list,new IdComparator());
            for(SalesPerson ob:list)
            	System.out.println(ob.getId()+" "+ob.getAmt());
            System.out.println("Do you want to continue ?");
            System.out.println("1.Yes---->Y\n2.No---->N");
            opt=sc.next().charAt(0);	
        }
        System.out.println("*************THANK YOU*************");
        sc.close();
    }
}
