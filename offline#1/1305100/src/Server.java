/**
 * Created by senjuti on 19-Mar-17.
 */
import java.io.*;
import java.net.*;

public class Server extends Thread {

    //Server_gui sob=new Server_gui();
    private ServerSocket ss;
    private File rootDirectory;
    private BufferedReader br;
    private PrintWriter pr;
    private int s_id;
    private String savingDirectory;

    public Server(int port) {
        try {
            ss = new ServerSocket(port);
            new Server_gui(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Socket clientSock = ss.accept();
                br = new BufferedReader(new InputStreamReader(clientSock.getInputStream())); //tcp er io
                pr = new PrintWriter(clientSock.getOutputStream());
                s_id = Integer.parseInt(br.readLine());
                System.out.println("Got connection from "+s_id);
                File files[] = rootDirectory.listFiles();
                boolean hit = false;
                for (File t : files) if(t.getName().equals(Integer.toString(s_id))) hit = true;
                if (hit) new File(rootDirectory+"\\"+s_id).mkdir();
                savingDirectory = rootDirectory+"\\"+s_id;
                System.out.println("Saving Directory: "+savingDirectory);
                readFile(clientSock);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readFile(Socket clientSock) throws IOException {
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());
        String fileName = br.readLine();
        FileOutputStream fos = new FileOutputStream(savingDirectory+"\\"+fileName);
        byte[] buffer = new byte[4096];

        int filesize = 15123; // Send file size in separate msg
        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fos.write(buffer, 0, read);
        }

        fos.close();
        dis.close();
    }

    public static void main(String[] args) {
        //new Server_gui(t);
        Server fs = new Server(1988);
        //fs.start();
    }

    public void setRoot(String root) {
        this.rootDirectory = new File(root);
    }
}