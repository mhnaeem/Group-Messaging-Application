import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
* Write a description of class Application_GUI here.
*
*
* @author (your name)
* @version (a version number or a date)
*/
public class Application_GUI extends JFrame {
    static private String userNameRem, passwordRem;
    private JButton cancelBtn, createBtn, signInBtn;
    private JMenu optionsMenu, helpMenu;
    private JMenuBar menuBar;
    private JLabel mainLbl, passwordLbl, usrNameLbl;
    private JTextField passwordFld, usrNameFld;
    private JCheckBox rememberBtn;
    private JMenuItem aboutMenuItem, exitMenuItem, howToUseMenuItem, newUserMenuItem;
    
    /**
     * Creates new form main
     */
    public Application_GUI() {
        setTitle("Group Messaging Application");
        addLabel();
        addButtons();
        addButtonFunctionalities();
        addMenu();
        addMenuFunctionalities();
        createLayout();
        pack();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    private void addLabel() {
        usrNameLbl = new JLabel("Username:");
        usrNameFld = new JTextField(userNameRem);
        passwordLbl = new JLabel("Password:");
        passwordFld = new JTextField(passwordRem);
        mainLbl = new JLabel("Welcome to Group Messaging Application");
        mainLbl.setFont(new Font("Tahoma", 0, 18));
        mainLbl.setHorizontalAlignment(SwingConstants.CENTER);
    }                   
    private void addButtons(){
        createBtn = new JButton("New User");
        signInBtn = new JButton("Sign In");
        cancelBtn = new JButton("Cancel");    
        rememberBtn = new JCheckBox("Remeber Sign In");        
    }
    private void addButtonFunctionalities(){
         createBtn.addActionListener(
         (ActionEvent ev) -> {
             new UserProfile_GUI();    
         });
         cancelBtn.addActionListener(
         (ActionEvent ev) -> {
             System.exit(0);    
         });
         signInBtn.addActionListener(
         (ActionEvent ev) -> {
             String usr = usrNameFld.getText();
             String pass = passwordFld.getText();
             if (User.userVerification(usr, pass)){
                 new Forum_GUI(User.returnUser(usr));
                 Application_GUI.this.dispose();
             }
         });
         rememberBtn.addActionListener(
         (ActionEvent ev) -> {
             userNameRem = usrNameFld.getText();
             passwordRem = passwordFld.getText();
         });
    }
    private void addMenu(){
        menuBar = new JMenuBar();
        optionsMenu = new JMenu("Options");
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About"); 
        exitMenuItem = new JMenuItem("Exit");        
        howToUseMenuItem = new JMenuItem("How to use");
        newUserMenuItem = new JMenuItem("New User");  
        
        menuBar.add(optionsMenu);
        optionsMenu.add(newUserMenuItem);
        optionsMenu.add(exitMenuItem);
        
        menuBar.add(helpMenu);
        helpMenu.add(howToUseMenuItem);
        helpMenu.add(aboutMenuItem);
    
        setJMenuBar(menuBar);        
    }
    private void addMenuFunctionalities(){
         newUserMenuItem.addActionListener(
         (ActionEvent ev) -> {
             new UserProfile_GUI();
         });
         exitMenuItem.addActionListener(
         (ActionEvent ev) -> {
             System.exit(0);
         });
         howToUseMenuItem.addActionListener(
         (ActionEvent ev) -> {
             //Add content here
             String htuStr = "Usage Instructions";
             JOptionPane.showMessageDialog(null, htuStr, "How to use", JOptionPane.INFORMATION_MESSAGE);        
         });
         aboutMenuItem.addActionListener(
         (ActionEvent ev) -> {
             //Add content here
             String abtStr = "Group Messaging Application";
             JOptionPane.showMessageDialog(null, abtStr, "About", JOptionPane.INFORMATION_MESSAGE);                     
         });
    }
    private void createLayout(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(mainLbl, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createBtn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signInBtn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(usrNameLbl, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(usrNameFld, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(passwordLbl, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(passwordFld, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rememberBtn, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainLbl, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(usrNameLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usrNameFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rememberBtn)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(signInBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }
    public static void main(String args[]){
        new Application_GUI();
    }
}

