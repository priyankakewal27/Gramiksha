import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Priyanka
 */
@ManagedBean
@SessionScoped

public class teacher implements Serializable {
    
    int VID;
    String name;
    int tempID;
    String className;
    int subjectID;
    private ArrayList<subtopic>topic;

    public ArrayList<subtopic> getTopic() {
        return topic;
    }

    public void setTopic(ArrayList<subtopic> topic) {
        this.topic = topic;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }
    private ArrayList<subject> sub;

    public ArrayList<subject> getSub() {
        return sub;
    }

    public void setSub(ArrayList<subject> sub) {
        this.sub = sub;
    }

    public int getTempID() {
        return tempID;
    }

    public void setTempID(int tempID) {
        this.tempID = tempID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    private ArrayList<Classes> list;

    public ArrayList<Classes> getList() {
        return list;
    }

    public void setList(ArrayList<Classes> list) {
        this.list = list;
    }

   

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    String emailID;
    String password;
    String address;
    int schoolID;
    int classID;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public teacher() {
        
    }


    public int getVID() {
        return VID;
    }

    public void setVID(int VID) {
        this.VID = VID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }
   
    public String login()
    {
        //System.out.println(emailID);
         ResultSet  resultSet = DatabaseConnection.executeQuery("Select * from volunteer where emailID = '" + emailID + "'", false);
             try
             {
            
                 
            if(resultSet.next())
            {
                
                
                
                    //the id is found, check the password
                    if(password.equals(resultSet.getString(2)))
                    {
                        //password is good
                        return "welcome";
                    }
                     else
                    {
                        //password is not correct
                        return "loginnotok";
                    }
            }
            
            else
            {
                    return "loginnotok";
            }
                
        }
       
                    
        
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        finally 
        {
             try
            {
                
                
                //you close it only when resultset is not null
                if(resultSet != null)
                {
                   resultSet.close();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    
    
    
    
    
    public void viewClass()
    { try
    {
        
        ResultSet  resultSet = DatabaseConnection.executeQuery("Select c.classID, c.class_name, c.schoolID from class c, volunteer v where c.schoolID = v.schoolID and emailID ='" + emailID + "'", false);
        list = new ArrayList();
        while(resultSet.next())
        {
           list.add(new Classes(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
           
            
        }
    }
    catch (SQLException e) {
            e.printStackTrace();
        }
            
        /* for(int i = 0; i < list.size(); i++)
         {
             System.out.println(list.get(i).class_name);
         }*/
        
}
    public String getClassID(int id)
    {
        tempID = id;
        System.out.println(tempID);
        
                try
    {
        
        ResultSet  resultSet = DatabaseConnection.executeQuery("Select classID, class_name from class where classID =" + id, false);
        if (resultSet.next())
        {
            className = resultSet.getString(2);
             System.out.println(className);
        return"Assessment";
        }
       
    }
    catch (SQLException e) {
            e.printStackTrace();
        }
                return null;
               
            }
    
   
    public String displaySubjects()
    {
        try
        {
            ResultSet resultSet = DatabaseConnection.executeQuery("Select * from subject where classID =" + tempID , false);
            sub = new ArrayList();
            while (resultSet.next())
                    {
                        sub.add(new subject(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3)));
                        
                        
                    }
            
            return "displaysubjects";
             
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
       
    }
    
    
    public String displaySubtopics(int subID)
    {
        subjectID = subID;
        System.out.println(subjectID);
         try
        {
            ResultSet resultSet = DatabaseConnection.executeQuery("Select * from subtopic where SID =" + subID , false);
            topic = new ArrayList();
            while (resultSet.next())
                    {
                        topic.add(new subtopic(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getInt(5)));
                        
                        
                    }
             
            
            return "displaysubtopics";
             
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
       
        
    }
    public String addSession(String subtop_name, String volunName, String desc, int sessions)
    {
         ResultSet rs = DatabaseConnection.executeQuery("insert into subtopic values (" + subjectID + ",'" + subtop_name + "','" + volunName + "','" + desc + "'," + sessions + ")", true);
        
        return "displaysubjects";
    }
}
     