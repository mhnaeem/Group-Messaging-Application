import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Write a description of class Chat_GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
*/
public class Forum_GUI extends JFrame {
    private JMenu editMenu, optionsMenu, helpMenu;
    private JMenuBar menuBar;
    private JTextArea mainMessages, msgWriter;
    private JPanel mainPanel;
    private JButton sendBtn;
    private JMenuItem exitMenuItem, aboutMenuItem, cutMenuItem, copyMenuItem, joinGroupMenuItem;
    private JMenuItem pasteMenuItem, logOutMenuItem, newUserMenuItem, signInMenuItem, createGroupMenuItem;
    private User currentUser;
    private JScrollPane scPane1, scPane2;
    
    /**
     * Creates new form Frame
     */
    public Forum_GUI(User usr) {
        currentUser = usr;
        initialiazeComponents();
        createLayout();
        addMenu();
        addMenuFunctionalities();
        addButtonFunctionalities();
        pack();
        setVisible(true);
        
        Runnable msgBoardRunnable = new Runnable() {
            public void run() {
                StringBuilder stB = new StringBuilder();
                for (Post pos : Group.userInGroup(currentUser).getGroupPosts()){
                    stB.append(pos.getPost());   
                }
                mainMessages.setText(stB.toString());                 
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(msgBoardRunnable, 0, 3, TimeUnit.SECONDS);

    }
                         
    private void initialiazeComponents() {
        mainPanel = new JPanel();
        sendBtn = new JButton("Send");
        msgWriter = new JTextArea();
        mainMessages = new JTextArea();
        scPane1 = new JScrollPane(mainMessages,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scPane2 = new JScrollPane(msgWriter,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        msgWriter.setLineWrap(true);   
        mainMessages.setLineWrap(true);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        mainMessages.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainMessages.setEditable(false);
               
        setTitle("Group Posts");
    } 
    private void addButtonFunctionalities(){
        sendBtn.addActionListener(
        (ActionEvent ev) -> {
            Post ps = new Message_Post(currentUser, msgWriter.getText());
            StringBuilder stB = new StringBuilder();
            for (Post pos : Group.userInGroup(currentUser).getGroupPosts()){
                System.out.println(pos.getPost());
                stB.append(pos.getPost());   
            }
            mainMessages.setText(stB.toString());                    
        });
    }
    private void addMenu(){
        menuBar = new JMenuBar();
        optionsMenu = new JMenu("Options");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");
        exitMenuItem = new JMenuItem("Exit");
        aboutMenuItem = new JMenuItem("About");
        cutMenuItem = new JMenuItem("Cut");
        copyMenuItem = new JMenuItem("Copy");
        pasteMenuItem = new JMenuItem("Paste");
        logOutMenuItem = new JMenuItem("Log Out"); 
        newUserMenuItem = new JMenuItem("Create a new user");
        signInMenuItem = new JMenuItem("Sign in");
        joinGroupMenuItem = new JMenuItem("Join Group");
        createGroupMenuItem = new JMenuItem("Create new group");

        optionsMenu.add(joinGroupMenuItem);
        optionsMenu.add(createGroupMenuItem);
        optionsMenu.add(newUserMenuItem);
        optionsMenu.add(signInMenuItem);        
        optionsMenu.add(logOutMenuItem);
        optionsMenu.add(exitMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(cutMenuItem);
        editMenu.add(pasteMenuItem);
        helpMenu.add(aboutMenuItem);
        menuBar.add(optionsMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);        
    }
    private void addMenuFunctionalities(){
        joinGroupMenuItem.addActionListener(
        (ActionEvent ev) -> {
            String gName = JOptionPane.showInputDialog("Group Name: ");
            for (Group grp: Group.getGroupList()){
                if ( grp.getGroupName().equals(gName)){
                    grp.addUser(currentUser);
                }
            }
        });
        createGroupMenuItem.addActionListener(
        (ActionEvent ev) -> {
            String gName = JOptionPane.showInputDialog("Group Name: ");
            new Group(gName);
        });
        logOutMenuItem.addActionListener(
        (ActionEvent ev) -> {
            Forum_GUI.this.dispose();
            new Application_GUI();
        });
        newUserMenuItem.addActionListener(
        (ActionEvent ev) -> {
            new UserProfile_GUI();
        });
        signInMenuItem.addActionListener(
        (ActionEvent ev) -> {
            new Application_GUI();
        });
        exitMenuItem.addActionListener(
        (ActionEvent ev) -> {
            System.exit(0);
        });
        copyMenuItem.addActionListener(
        (ActionEvent ev) -> {
            String str = "Working on it";
            JOptionPane.showMessageDialog(null, str, "Error!",JOptionPane.ERROR_MESSAGE);
        });
        cutMenuItem.addActionListener(
        (ActionEvent ev) -> {
            String str = "Working on it";
            JOptionPane.showMessageDialog(null, str, "Error!",JOptionPane.ERROR_MESSAGE);
        });
        pasteMenuItem.addActionListener(
        (ActionEvent ev) -> {
            String str = "Working on it";
            JOptionPane.showMessageDialog(null, str, "Error!",JOptionPane.ERROR_MESSAGE);
        }); 
        aboutMenuItem.addActionListener(
        (ActionEvent ev) -> {
            //Add content
            String str = "About the application";
            JOptionPane.showMessageDialog(null, str, "About",JOptionPane.ERROR_MESSAGE);
        });        
    }
    private void createLayout(){
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(scPane1)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(scPane2, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scPane1, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(sendBtn, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(scPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );        
    }
}

