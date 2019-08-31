
/**
 * Write a description of class Message_Post here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Message_Post extends Post
{
    private String messageTxt;           
    /**
     * Constructor for objects of class Message_Post
     */
    public Message_Post(User usr)
    {
        super(usr);
    }
    public Message_Post(User usr, String msg){
        super(usr);
        setMessage(msg);
    }
    public void setMessage(String msg){
        messageTxt = msg;
    }
    public String getPost(){
        String toReturn = super.getPost();
        toReturn += messageTxt + "\n\n";
        return toReturn;
    }
}
