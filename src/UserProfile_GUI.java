import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.WindowConstants;
import javax.swing.LayoutStyle;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Write a description of class UserProfile_GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserProfile_GUI extends JFrame {
    private JCheckBox agreeBox;
    private JButton cancelBtn, sendBtn;
    private JTextField fNameFld, lNameFld, passwordFld, usrNameFld;
    private JLabel fNameLbl, lNameLbl, passwordLbl, title, usrNameLbl;
    private boolean agreeBoxState = false;
    
    /**
     * Creates new form newUser
     */
    public UserProfile_GUI() {
        initComponents();
        addButtons();
        addButtonFunctionalities();
        createLayout();
        pack();
        setVisible(true);
    }
    private void addButtons(){
        agreeBox = new JCheckBox("I Accept the Terms and Conditions");
        sendBtn = new JButton("Send");
        cancelBtn = new JButton("Cancel");        
    }
    private void addButtonFunctionalities(){
        cancelBtn.addActionListener(
        (ActionEvent ev) -> {
            UserProfile_GUI.this.dispose();    
        });
        sendBtn.addActionListener(
        (ActionEvent ev) -> {
            if (agreeBoxState){
                new User(usrNameFld.getText(), passwordFld.getText(),fNameFld.getText(), lNameFld.getText());
                UserProfile_GUI.this.dispose();
                agreeBoxState = false;
            }
            else {
                JOptionPane.showMessageDialog(null, "Select the agree box", "Error!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        agreeBox.addActionListener(
        (ActionEvent ev) -> {
            agreeBoxState = true;
        });
    }
    private void initComponents() {

        title = new JLabel("New User Account");
        usrNameLbl = new JLabel("Username: ");
        usrNameFld = new JTextField();
        fNameLbl = new JLabel("First Name: ");
        fNameFld = new JTextField();
        lNameLbl = new JLabel("Last Name: ");
        lNameFld = new JTextField();
        passwordLbl = new JLabel("Password: ");
        passwordFld = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create a new account");
        setAlwaysOnTop(true);

        title.setAlignmentX(JLabel.CENTER);
        title.setFont(new Font("Dialog", 0, 32));
    }
    private void createLayout(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(agreeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lNameLbl, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lNameFld, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fNameLbl, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fNameFld, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(usrNameLbl, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(usrNameFld, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(sendBtn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(passwordLbl, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(passwordFld, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(usrNameLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usrNameFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fNameLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fNameFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(lNameLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lNameFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(agreeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sendBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
        );        
    }
}

