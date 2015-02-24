package jdbc2;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.newlecture.Member;

public class Program{
	public static void main(String[] args)throws SQLException, ClassNotFoundException{
		System.out.println("검색어를 입력하세요");
		Scanner scan=new Scanner(System.in);
		String name=scan.nextLine();
		
		MemberDao memberDao= new MemberDao();
		List<Member> list = memberDao.getMembers(name);
		
		for(Member m : list)
			System.out.println(m.getMid()+","+m.getName()+","+m.getAge());
		
	}
}

/*import java.sql.Connection;
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
      System.out.println("검색어 입력 :");
      String name= scan.nextLine();
      String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
      //String sql = "SELECT*FROM MEMBERS"; 전부를 가져온다
       //FACESHOP을 가져온다.
      String sql = "SELECT*FROM MEMBERS WHERE NAME LIKE '"+name+"%'";       
      
      Class.forName("oracle.jdbc.driver.OracleDriver");
      
      Connection con = DriverManager.getConnection(url, "HR", "class6"); //연결 객체 생성하기
      Statement st = con.createStatement(); //실행 객체
      ResultSet rs = st.executeQuery(sql); //결과 객체
      
      
      //rs.next(); //next를 통해 한줄 받아온다.
      //System.out.println(rs.getString("mid"));
      
      
      System.out.println("아이디\t" + "이름\t" + "나이");
      while(rs.next())
      {
         
         System.out.println(rs.getString("MID")+"\t"+rs.getString("NAME")+"\t"+rs.getString("AGE"));
      }
      
      //순서대로 close해주면서 나온다.
      rs.close();
      st.close();
      con.close();
      }
   }

}*/