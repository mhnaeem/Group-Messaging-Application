
/**
 * Write a description of class Picture_Post here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Picture_Post extends Post
{
    private String msgPicLocation;     
    /**
     * Constructor for objects of class Picture_Post
     */
    public Picture_Post(User usr)
    {
       super(usr);     
    }
    public Picture_Post(User usr, String picLocation){
        super(usr);
        setPost(picLocation);
    }
    public void setPost(String picLoc){
        msgPicLocation = picLoc;
    }    
}
