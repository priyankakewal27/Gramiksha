
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
public class subtopic implements Serializable {
    int SUBID;
    String subtopic_name;
    String volunteername;
    String desc;
    int no;
    public subtopic()
    {
        
    }

    public int getSUBID() {
        return SUBID;
    }

    public void setSUBID(int SUBID) {
        this.SUBID = SUBID;
    }

    public String getSubtopic_name() {
        return subtopic_name;
    }

    public void setSubtopic_name(String subtopic_name) {
        this.subtopic_name = subtopic_name;
    }

    public String getVolunteername() {
        return volunteername;
    }

    public void setVolunteername(String volunteername) {
        this.volunteername = volunteername;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public subtopic(int SUBID, String subtopic_name, String volunteername, String desc, int no) {
        this.SUBID = SUBID;
        this.subtopic_name = subtopic_name;
        this.volunteername = volunteername;
        this.desc = desc;
        this.no = no;
    }
    
}
