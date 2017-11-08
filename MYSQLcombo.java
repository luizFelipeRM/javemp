package emp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;

public class MYSQLcombo {
    String conString = "jdbc:mysql://localhost:3306/empresa";
    String DBusr = "root";
    String DBpass = "";
    //INSERT INTO DB
    public Boolean add(String usuario, String senha) {
        //SQL STMT
        String sql = "INSERT INTO funcionarios(usuario, senha) VALUES('" + usuario + senha + "')";
        try {
            //CONNECTION"
            Connection con = DriverManager.getConnection(conString, DBusr, DBpass);
            //STATEMENT
            Statement s=con.prepareStatement(sql);
            //EXECUTE
            s.execute(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
             return false;
        }
    }
    //RETRIEVE DATA
    public DefaultComboBoxModel retrieve()
    {
        DefaultComboBoxModel dm=new DefaultComboBoxModel();
        //SQL
        String sql="SELECT Name FROM empresa";
        try
        {
            Connection con=DriverManager.getConnection(conString, DBusr, DBpass);
            //STATEMENT
            Statement s=con.prepareStatement(sql);
            ResultSet rs=s.executeQuery(sql);
            //LOOP THRU GETTING ALL VALUES
            while(rs.next())
            {
                //GET VALUES
                String name=rs.getString(1);
                dm.addElement(name);
            }
            return dm;
        }catch (SQLException ex) {
            ex.printStackTrace();
             return null;
        }
    }
    //UPDATE DATA
    public Boolean update(String id,String value)
    {
        String sql="UPDATE empresa SET Name ='" + value + "' WHERE Name='" + id + "'";
        try
        {
            //GET COONECTION
            Connection con=DriverManager.getConnection(conString, DBusr, DBpass);
            //STATEMENT
            Statement s=con.prepareStatement(sql);
            //EXECUTE
            s.execute(sql);
            return true;
        }catch (SQLException ex) {
            ex.printStackTrace();
             return false;
        }
    }
    //DELETE
    public Boolean delete(String id)
    {
        String sql="DELETE FROM empresa WHERE Name ='"+id+"'";
        try
        {
            //GET COONECTION
            Connection con=DriverManager.getConnection(conString, DBusr, DBpass);
             //STATEMENT
            Statement s=con.prepareStatement(sql);
            //EXECUTE
            s.execute(sql);
            return true;
        }catch (SQLException ex) {
            ex.printStackTrace();
             return false;
        }
    }
}