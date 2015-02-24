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
    //String sql = "SELECT*FROM MEMBERS"; ���θ� �����´�
     //FACESHOP�� �����´�.
    String sql = String.format(
    		"SELECT*FROM MEMBERS WHERE NAME LIKE '%s'","%"+name+"%");       
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    
    Connection con = DriverManager.getConnection(url, "HR", "class6"); //���� ��ü �����ϱ�
    Statement st = con.createStatement(); //���� ��ü
    ResultSet rs = st.executeQuery(sql); //��� ��ü
    
    List<Member> list = new ArrayList<Member>();
    //rs.next(); //next�� ���� ���� �޾ƿ´�.
    //System.out.println(rs.getString("mid"));
    
    while(rs.next())
    {
       //System.out.println(rs.getString("MID")+"\t"+rs.getString("NAME")+"\t"+rs.getString("AGE"));
    	Member m = new Member();
    	m.setMid(rs.getString("mid"));
    	
    	list.add(m);
    }
    
    //������� close���ָ鼭 ���´�.
    rs.close();
    st.close();
    con.close();
    
    return list;
	}
}

