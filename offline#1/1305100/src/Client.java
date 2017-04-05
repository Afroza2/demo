/**
 * Created by senjuti on 19-Mar-17.
 */

import java.io.*;
import java.net.Socket;

public class Client {

    Client_gui cob;
    private Socket s;
    public static String host;
    public static int port;
    public static String path;
    private int id;
    private String root;
    private BufferedReader br;
    private PrintWriter pr;

    public Client() {
        cob=new Client_gui(this);
    }

    public void connect(String host, int port,int s_id){
        this.host = host;
        this.port = port;
        this.id = s_id;
        //this.root = root_directory;
        try {
            s = new Socket(host, port);
            br = new BufferedReader(new InputStreamReader(s.getInputStream())); //tcp er io
            pr = new PrintWriter(s.getOutputStream());
            pr.println(s_id);
            //send(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String file) throws IOException {
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[512];

        while (fis.read(buffer) > 0) {
            dos.write(buffer);
        }

        fis.close();
        dos.close();
    }

    public static void main(String[] args) {
        //Client fc = new Client("localhost", 1988, "F:\\CSE-322\\Offline#1\\1305100\\codes\\capture1.jpg");
        Client fc = new Client();
    }

}

