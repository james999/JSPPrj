package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

   public static void main(String[] args) throws SQLException, ClassNotFoundException {
      
      Scanner scan = new Scanner(System.in);
      while(true) {
      System.out.println("�˻��� �Է� :");
      String name= scan.nextLine();
      String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
      //String sql = "SELECT*FROM MEMBERS"; ���θ� �����´�
       //FACESHOP�� �����´�.
      String sql = "SELECT*FROM MEMBERS WHERE NAME LIKE '"+name+"%'";       
      
      Class.forName("oracle.jdbc.driver.OracleDriver");
      
      Connection con = DriverManager.getConnection(url, "HR", "class6"); //���� ��ü �����ϱ�
      Statement st = con.createStatement(); //���� ��ü
      ResultSet rs = st.executeQuery(sql); //��� ��ü
      
      
      //rs.next(); //next�� ���� ���� �޾ƿ´�.
      //System.out.println(rs.getString("mid"));
      
      
      System.out.println("���̵�\t" + "�̸�\t" + "����");
      while(rs.next())
      {
         
         System.out.println(rs.getString("MID")+"\t"+rs.getString("NAME")+"\t"+rs.getString("AGE"));
      }
      
      //������� close���ָ鼭 ���´�.
      rs.close();
      st.close();
      con.close();
      }
   }

}