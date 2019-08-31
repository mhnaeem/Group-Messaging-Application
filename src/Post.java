import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Abstract class Post - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class Post
{
    private User poster;
    //dd-mmm-yyyy hh:mm
    private String dateAndTimeStamp;
    
    public Post(User postUsr){
        setPoster(postUsr);
        setDateAndTimeStamp();
        addPostToGroup();
    }
    
    public User getPoster(){
        return poster;
    }
    public String getDateAndTime(){
        return dateAndTimeStamp;
    }
    
    private void setPoster(User usr){
        poster = usr;
    }
    private void setDateAndTimeStamp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();  
        dateAndTimeStamp = dtf.format(now);
    }
    public String getPost(){
        String toReturn = "Username: " + poster.getUserName() + "\n";
        toReturn += "\t" + dateAndTimeStamp + "\n" ;
        return toReturn;
    }
    private void addPostToGroup(){
        Group gp = Group.userInGroup(poster);
        gp.addGroupPost(this);
    }
}
