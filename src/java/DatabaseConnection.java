
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Priyanka
 */
public class DatabaseConnection {
    public static ResultSet executeQuery(String query,boolean IsUpdate) 
    {
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/gramiksha?zeroDateTimeBehavior=convertToNull";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            connection = DriverManager.getConnection(DATABASE_URL, 
                  "root", "");
            //create statement
            statement = connection.createStatement();
            //search the accountID in the onlineAccount table
            if(IsUpdate == true)
            {
                int r = statement.executeUpdate(query);
            
            }
            else if(IsUpdate == false)
            {
                resultSet = statement.executeQuery(query);
            }
            
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } catch (InstantiationException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       /* finally
        {
            //close the database
            try
            {
                connection.close();
                statement.close();
                //you close it only when resultset is not null
              /*  if(resultSet != null)
                {
                   resultSet.close();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }*/

        return resultSet;
        
    }
    
}
    

