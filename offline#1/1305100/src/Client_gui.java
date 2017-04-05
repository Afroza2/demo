import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by senjuti on 18-Mar-17.
 */
public class Client_gui extends JFrame implements ActionListener{
    private JTextField ip;
    private  JTextField port;
    private JTextField sid;
    private JTextField root;
    private JLabel L1;
    private JLabel L2;
    private JLabel L3;
    private JLabel L4;
    private JButton jb;
    private JFrame jf;
    private Client client;
    public Client_gui(Client client) {
        super("Please Enter Info");
        this.client = client;
        Container con2 = getContentPane();
        con2.setLayout(new FlowLayout());
        L1 = new JLabel("Please Enter IP");
        con2.add(L1);
        ip = new JTextField(20);
        con2.add(ip);
        L2 = new JLabel("Please Enter Port no.");
        con2.add(L2);
        port = new JTextField(20);
        con2.add(port);
        L3 = new JLabel("Your student id");
        con2.add(L3);
        sid = new JTextField(20);
        con2.add(sid);
        //L4 = new JLabel("Root Directory");
        //con2.add(L4);
        //root = new JTextField(20);
        //con2.add(root);
        jb = new JButton("Connect");
        con2.add(jb);
        jb.addActionListener(this);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 300);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jb) {
                String ip_no=ip.getText();
                String port_no=port.getText();
                String s_id = sid.getText();
                //String root_directory = root.getText();
                client.connect(ip_no,Integer.parseInt(port_no),Integer.parseInt(s_id));
                JOptionPane.showMessageDialog(null, "You are connected to the Server ");
            }
            //this.dispose();
        }

}
