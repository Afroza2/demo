import com.sun.org.apache.xpath.internal.operations.String;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 * Created by senjuti on 17-Mar-17.
 */
public class Server_gui extends JFrame implements ActionListener{
    private final Server server;
    private JTextField text1;
    private JTextField text2;
    private JTextField max_f_size;
    private JTextField no_of_files;
    private JTextField dir;
    private JCheckBox c;
    private JCheckBox java;
    private JCheckBox py;
    private JButton jb;
    private JLabel lev1;
    private JLabel lev2;
    private JLabel lev;

    public Server_gui(Server server){
        super("Please choose the file Type(s)");
        this.server = server;
        Container con1=getContentPane();
        con1.setLayout(new FlowLayout());
        c= new JCheckBox(".c");
        con1.add(c);
        java= new JCheckBox(".java");
        con1.add(java);
        py= new JCheckBox(".py");
        con1.add(py);
        lev=new JLabel("Save files here");
        con1.add(lev);
        dir=new JTextField(10);
        con1.add(dir);
        lev1=new JLabel("Max size of file");
        con1.add(lev1);
        text1=new JTextField(10);
        con1.add(text1);
        lev2=new JLabel("No of allowable files");
        con1.add(lev2);
        text2=new JTextField(10);
        con1.add(text2);
        jb=new JButton("Submit");
        con1.add(jb);
        jb.addActionListener(this);
        setSize(200,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(300,300);
        setVisible(true);
        Handlerclass handler=new Handlerclass();
        c.addItemListener(handler);

    }

    public void actionPerformed(ActionEvent ae)
    {
        System.out.println("in actionListener");
        if(ae.getSource()==jb)
        {
            java.lang.String s;
            s = "C: "+c.isSelected() + "Java: " +java.isSelected() + "Python: " + py.isSelected();
            server.setRoot(dir.getText());
            server.start();
            JOptionPane.showMessageDialog(null,s);
        }
        if(ae.getSource()==max_f_size)
        {
             java.lang.String l= max_f_size.getText();

        }
        if(ae.getSource()==no_of_files)
        {
            java.lang.String n=no_of_files.getText();
        }
        if(ae.getSource()==dir)
        {
            java.lang.String d=dir.getText();
        }
    }


    private class Handlerclass implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            Font font=null;
            if(c.isSelected() && java.isSelected() && py.isSelected()) {
                font = new Font("Serif", Font.BOLD, 14);
            }
            else if(c.isSelected()){
                font = new Font("Serif", Font.BOLD,14);
            }
            else if(java.isSelected()){
                font = new Font("Serif", Font.BOLD,14);
            }
            else if(py.isSelected()){
                font = new Font("Serif", Font.BOLD,14);
            }
            else{
                font = new Font("Serif",Font.PLAIN,14);
            }
        }
    }

}
