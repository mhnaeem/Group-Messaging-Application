import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.util.ArrayList; 
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
    static protected int totalPosts = 1;
    private int POST_NUMBER;
    
    public Post(User postUsr){
        setPoster(postUsr);
        setPostNumber();
        incrementTotalPosts();
        setDateAndTimeStamp();
        addPostToGroup();
    }
    
    public User getPoster(){
        return poster;
    }
    public String getDateAndTime(){
        return dateAndTimeStamp;
    }
    static public int getTotalPosts(){
        return totalPosts;
    }
    public int getPostNumber(){
        return POST_NUMBER;
    }
    
    private void setPoster(User usr){
        poster = usr;
    }
    private void setDateAndTimeStamp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();  
        dateAndTimeStamp = dtf.format(now);
    }
    private void setPostNumber(){
        POST_NUMBER = totalPosts;
    }
    private void incrementTotalPosts(){
        totalPosts += 1;
    }
    public String getPost(){
        String toReturn = "Username: " + poster.getUserName() + "\n";
        toReturn += "Post No#: " + POST_NUMBER + "\t" + dateAndTimeStamp + "\n" ;
        return toReturn;
    }
    private void addPostToGroup(){
        Group gp = Group.userInGroup(poster);
        gp.addGroupPost(this);
    }
}
