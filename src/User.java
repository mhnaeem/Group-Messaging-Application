import java.util.HashMap;
import java.util.ArrayList;
/**
 * An abstract class representing a user for the messaging application
 *
 * @author (Muhammad Hammad)
 * @version (23-Aug-2019)
 */
public class User
{
    //A static variable storing all the usernames and passwords
    static private HashMap<String, String> userMap = new HashMap<String,String>();
    static private ArrayList<User> usersList = new ArrayList<>();
    
    // Username is only created once and cannot be changed
    private String USERNAME;  
    
    private String firstName, lastName, password;
    
    //DD-MMM-YYYY
    private Date dob;
    
    private boolean admin = false;
    
    public User(String usrNm, String pass, String fName, String lName){
        setUserAndPassword(usrNm, pass);
        firstName = fName;
        lastName = lName;
        usersList.add(this);
    }
    
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getUserName(){
        return USERNAME;
    }
    public String getPassword(){
        return password;
    }
    public String getDOB(){
        return dob.getDateString();
    }
    public boolean getAdminStatus(){
        return admin;
    }
    
    public void setFirstName(String nm){
        firstName = nm;
    }
    public void setLastName(String nm){
        lastName = nm;
    }
    private void setUserAndPassword(String usrNm, String pass){
        if (!userMap.containsKey(usrNm)){
            userMap.put(usrNm, pass);
            USERNAME = usrNm;
            password = pass;
        }
        else{
            System.out.println("Username already exists. Try Again!");
        }
    }
    public void setPassword(String usrNm, String oldPass, String newPass){
        if (userMap.containsKey(usrNm) && userMap.get(usrNm).equals(oldPass)){
            userMap.put(usrNm, newPass);
        }
        else if(!userMap.get(usrNm).equals(oldPass)){
            System.out.println("Old password is incorrect.");
        }
        else{
            System.out.println("New Password Cannot Be Set. Try Again!");
        }        
    }
    public void setDOB(int dd, int mm, int yyyy){
        dob = new Date(dd,mm,yyyy);
    }
    static public boolean userVerification(String usrNm, String pass){
        if ( userMap.containsKey(usrNm) ){
            String psd = userMap.get(usrNm);
            if (psd.equals(pass)){
                return true;    
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    static public User returnUser(String usrNm){
        for (User usr : usersList){
            if (usr.getUserName().equals(usrNm)){
                return usr;
            }
        }
        //Throw error later
        System.out.println("Username isn't valid");
        return usersList.get(0);
    }
    public void setAdminStatus(boolean st){
        admin = st;
    }
    public boolean equals(User usr){
        if ( (usr.getUserName().equals(USERNAME)) && 
        usr.getFirstName().equals(firstName) && 
        usr.getLastName().equals(lastName) &&
        usr.getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }   
}
