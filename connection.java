import java.sql.*;  
public class connection {  
    public static void main(String[] args) {  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbtest2", "root", "1234");  
            Statement s = con.createStatement();  
            s.execute("create table emp2 ( stud_id integer,stud_name varchar(20),stud_address varchar(30) )"); 
            s.execute("insert into emp2 values(001,'ARman','Delhi')");   
            s.execute("insert into emp2 values(002,'Robert','Canada')"); 
            s.execute("insert into emp2 values(003,'Ahuja','Karnal')");  
	    s.execute("insert into emp2 values(004,'Ahujam','Karnal')");  
            ResultSet rs = s.executeQuery("select * from emp2");  
            if (rs != null) 
                while (rs.next()) 
            {  
                System.out.println("Id of the student: " + rs.getString(1));  
                System.out.println("Name of student: " + rs.getString(2));  
                System.out.println("Address of student: " + rs.getString(3));  
             }  
            s.close();  
            con.close();  
        } catch (SQLException err) {  
            System.out.println("ERROR: " + err);  
        } catch (Exception err) {  
            System.out.println("ERROR: " + err);  
        }  
    }  
}  
