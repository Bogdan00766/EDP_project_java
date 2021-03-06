package Database;
import com.example.edp_project.Events.DbSavingDoneEvent;
import com.google.common.eventbus.EventBus;
import config.PropertiesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbContext extends Thread{
    private final Object executioner;
    String url;
    Connection con = null;
    private String type;
    public DbContext(Object o){
        executioner = o;
    }
    @Override
    public void start(){
        SetConnection();
    }

    private LoveHistoryDto CreateLoveHistoryDto(ResultSet rs){
        LoveHistoryDto lhd = new LoveHistoryDto();
        try {
            lhd.setId(rs.getInt("Id"));
            lhd.setName1(rs.getString("Name1"));
            lhd.setName2(rs.getString("Name2"));
            lhd.setPercentage(rs.getInt("Percentage"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return lhd;
    }
    public List<LoveHistoryDto> Read(){
        if (con == null) return null;
        List<LoveHistoryDto> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM LoveHistory;"
            );

            while (rs.next()){
                list.add(CreateLoveHistoryDto(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        CloseConnection();
        return list;

    }

    public void Insert(String name1, String name2, int percentage)  {
        try {
            if (con == null) return;

            String sqlString = "INSERT INTO LoveHistory (name1, name2, percentage) VALUES (" + '"' + name1 + '"' + ',' + '"' + name2 + '"' + ',' + percentage+ ")";
            Statement st = con.createStatement();
            st.executeUpdate(sqlString);
            DbSavingDoneEvent event = new DbSavingDoneEvent();
            EventBus eb = new EventBus();
            eb.register(executioner);
            eb.post(event);
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
