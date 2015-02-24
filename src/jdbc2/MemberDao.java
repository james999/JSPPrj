package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.Member;

public class MemberDao {

	public List<Member> getMembers(String name) throws SQLException, ClassNotFoundException {
    String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
    //String sql = "SELECT*FROM MEMBERS"; 전부를 가져온다
     //FACESHOP을 가져온다.
    String sql = String.format(
    		"SELECT*FROM MEMBERS WHERE NAME LIKE '%s'","%"+name+"%");       
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    
    Connection con = DriverManager.getConnection(url, "HR", "class6"); //연결 객체 생성하기
    Statement st = con.createStatement(); //실행 객체
    ResultSet rs = st.executeQuery(sql); //결과 객체
    
    List<Member> list = new ArrayList<Member>();
    //rs.next(); //next를 통해 한줄 받아온다.
    //System.out.println(rs.getString("mid"));
    
    while(rs.next())
    {
       //System.out.println(rs.getString("MID")+"\t"+rs.getString("NAME")+"\t"+rs.getString("AGE"));
    	Member m = new Member();
    	m.setMid(rs.getString("mid"));
    	
    	list.add(m);
    }
    
    //순서대로 close해주면서 나온다.
    rs.close();
    st.close();
    con.close();
    
    return list;
	}
}

