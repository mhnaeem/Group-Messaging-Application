import java.util.ArrayList;
/**
 * Write a description of class Group here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Group
{
    private String groupName;  
    static private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<User> userList;
    private ArrayList<Post> groupPosts = new ArrayList<>();
    
    /**
     * Constructor for objects of class Group
     */
    public Group(String grpNm)
    {
        if (!groupExist(grpNm)){
            groupName = grpNm;
            groups.add(this);
            userList = new ArrayList<>();            
        }
        else{
            //TODO: Group already exists error, dialog box
            System.out.println("Group Constructor Error!");    
        }
    }

    public boolean groupExist(String nm){
        boolean exist = false;
        for (Group grp: groups){
            if (grp.getGroupName().equals(nm)){
                exist = true;
            }
        }
        return exist;
    }
    public String getGroupName(){
        return groupName;
    }
    public ArrayList<User> getUserList(){
        return userList;    
    }
    static public ArrayList<Group> getGroupList(){
        return groups;    
    }
    public void addUser(User usr){
        userList.add(usr);    
    }
    public void removeUser(User usr){
        userList.removeIf(us -> us.getUserName().equals(usr.getUserName()));
    }
    public ArrayList<Post> getGroupPosts(){
        return groupPosts;
    }
    public void addGroupPost(Post ps){
        groupPosts.add(ps);
    }
    static public Group userInGroup(User usrNm){
        for (Group grp: groups){
            for (User usr : grp.getUserList()){
                if (usr.equals(usrNm)){
                    return grp;
                }
            }
        }
        //TODO: Fix if no group found
        System.out.println("Group not found");
        return groups.get(0);
    }
}
