package Database;
import config.PropertiesManager;

import java.sql.*;

public class DbContext extends Thread{
    String url;
    Connection con = null;
    private String type;
    @Override
    public void start(){
        SetConnection();
    }

    public void Read(){
        if (con == null) return;

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM LoveHistory;"
            );

            while (rs.next()){
                System.out.println((rs.getString("name1")));
            }
            System.out.println("DONE");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        CloseConnection();
    }
    public void Insert(String name1, String name2, int percentage)  {
        try {
            if (con == null) return;

            String sqlString = "INSERT INTO LoveHistory (name1, name2, percentage) VALUES (" + '"' + name1 + '"' + ',' + '"' + name2 + '"' + ',' + percentage+ ")";
            Statement st = con.createStatement();
            st.executeUpdate(sqlString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        CloseConnection();
    }
    private void SetConnection() {
        try {
            String Dname = PropertiesManager.getInstance().getProperty("Dname");
            String url = PropertiesManager.getInstance().getProperty("URL");
            //Class.forName(Dname);
            con = DriverManager.getConnection(url);
            System.out.println("connected to database");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void CloseConnection(){
        try{
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
