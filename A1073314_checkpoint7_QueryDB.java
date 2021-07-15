import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.SQLException;

public class A1073314_checkpoint7_QueryDB {
    //Description : the driver description of mysql
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //Description : the protocol description of mysql
    private static final String PROTOCOL = "jdbc:mysql://140.127.220.220:3306/CHECKPOINT";
    //Description : the obstacle set queried from database.
    private static ArrayList<Integer[]> data;
    //Description : the filename of obstacle image queried from database.
    private static HashMap<Integer, String> typeChar;
    //Description : the ID of the map in database;
    private static String mapID;
    //Description : the sand set queried from database.
    private static ArrayList<Integer[]> sands;

    private static int WIDTH=0;
    private static int HEIGHT=0;
    private static String user = "checkpoint";
    private static String password = "ckppwd";

    public A1073314_checkpoint7_QueryDB(String mapID){
        this.data  = new ArrayList<Integer[]>();
        this.sands = new ArrayList<Integer[]>();
        this.typeChar = new HashMap<Integer, String>();
        this.mapID = mapID;
        queryData(this.data, this.typeChar);
        querySand(this.sands);
    }

    private static void queryData(ArrayList<Integer[]> data,HashMap<Integer, String> typeChar) {
    /*********************************The Past TODO (Checkpoint2)********************************
     * 
     * TODO(Past) Querying the barrier location from the server, and set it into Arraylist.
     * 
     * TODO(Past) Querying the bar_type and the corresponding file_name from the server, and set it into HashMap.
     * 
     * Hint:  for ckp2 to after, you need replace querying  column "file_name" with querying  column "display". 
     * 
     **********************************The End of the TODO***************************************/

     /********************************************************************************************
     START OF YOUR CODE
     ********************************************************************************************/
        Connection conn = null;
        try{
            Class.forName(DRIVER).getDeclaredConstructor().newInstance(); 
        }
        catch(Exception err){
            err.printStackTrace(System.err);
            System.exit(0);
        }
        try{
            conn = DriverManager.getConnection(PROTOCOL,user,password);
            Statement s = conn.createStatement();

            // ResultSet rs1 = s.executeQuery("SELECT * FROM map WHERE map_id="+mapID);
            // while(rs1.next()){
            //     HEIGHT = rs1.getInt("height");
            //     WIDTH = rs1.getInt("width");
            // }
            // rs1.close();

            ResultSet rs2 = s.executeQuery("SELECT bar_type, row_idx, column_idx FROM barrier WHERE map_id="+mapID);
            while(rs2.next()){
                int type = rs2.getInt("bar_type");
                int row_id = rs2.getInt("row_idx");
                int column_id = rs2.getInt("column_idx");
                // if(row_id < HEIGHT+1 && column_id < WIDTH+1){
                    Integer[] temp = {row_id, column_id, type};
                    data.add(temp);
                // }
            }
            rs2.close();

            ResultSet rs3 = s.executeQuery("SELECT bar_type, file_name FROM barrier_type");
            while(rs3.next()){
                typeChar.put(rs3.getInt("bar_type"), rs3.getString("file_name"));               
            }
            rs3.close();

            conn.close();
        }
        catch(SQLException err){
            System.err.println("error");
            err.printStackTrace(System.err);
            System.exit(0);
        }
    /********************************************************************************************
     END OF YOUR CODE
     ********************************************************************************************/
    }
    private static void querySand(ArrayList<Integer[]> sands) {
    /*********************************The TODO This Time (Checkpoint7)***************************
     * 
     * TODO(1) Querying the map size and the sand location from the server, and set it into Arraylist.
     * 
     **********************************The End of the TODO***************************************/

     /********************************************************************************************
     START OF YOUR CODE
     ********************************************************************************************/
        Connection conn = null;
        try{
            Class.forName(DRIVER).getDeclaredConstructor().newInstance(); 
        }
        catch(Exception err){
            err.printStackTrace(System.err);
            System.exit(0);
        }
        try{
            conn = DriverManager.getConnection(PROTOCOL,user,password);
            Statement s = conn.createStatement();
            ResultSet rs1 = s.executeQuery("SELECT * FROM map WHERE map_id="+mapID);
            while(rs1.next()){
                HEIGHT = rs1.getInt("height");
                WIDTH = rs1.getInt("width");
            }
            rs1.close();

            ResultSet rs3 = s.executeQuery("SELECT row_idx, column_idx, sand_id FROM sand WHERE map_id="+mapID);
            while(rs3.next()){
                // int id = rs3.getInt("sand_id");
                int row_id = rs3.getInt("row_idx");
                int column_id = rs3.getInt("column_idx");
                // if(row_id < HEIGHT+1 && column_id < WIDTH+1){
                    Integer[] temp = {row_id, column_id};
                    sands.add(temp);
                // }
            }
            rs3.close();

            conn.close();
        }
        catch(SQLException err){
            System.err.println("error");
            err.printStackTrace(System.err);
            System.exit(0);
        }
    /********************************************************************************************
     END OF YOUR CODE
    ********************************************************************************************/
    }
    public ArrayList getObstacle(){
        return this.data;
    }
    public void setObstacle(ArrayList<Integer[]> data){
        this.data = data;
    }
    public String getMapID(){
        return this.mapID;
    }
    public void setMapID(String mapID){
        this.mapID = mapID;
    }
    public HashMap getObstacleImg(){
        return this.typeChar;
    }
    public void setObstacleImg(HashMap<Integer, String> typeChar){
        this.typeChar = typeChar;
    }
    public ArrayList getSands(){
        return this.sands;
    }
    public void setSands(ArrayList<Integer[]> sands){
        this.sands = sands;
    }
}
