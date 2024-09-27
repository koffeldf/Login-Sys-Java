import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main 
{
    static ImageIcon lo = new ImageIcon("bankicon.jpg");
    static ImageIcon anig = new ImageIcon("borg.jpg");
    public static void main (String[] args) throws IOException
    {
        
        JLabel dop = new JLabel();
        dop.setBounds(150,0,300,300);
        dop.setText("DO YOU HAVE A PASSWORD");

        JButton yido = new JButton("YES");
        JButton nido = new JButton("NO");
        JFrame pc = new JFrame("Create Password");
        pc.setLayout(null);
        pc.setSize(500,400);
        pc.setVisible(true);
        pc.getContentPane().setBackground(Color.BLACK);
        pc.setIconImage(lo.getImage());
        pc.add(yido);
        pc.add(nido);
        pc.add(dop);
 
        yido.setFocusable(false);
        yido.setBorderPainted(false);
        yido.setBounds(250, 170, 300, 300);
        yido.setSize(80, 60);
        yido.setBackground(Color.DARK_GRAY);
        yido.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.out.println("Button clicked!");
                pc.setVisible(false);
                try 
                {
                    login();
                } catch (FileNotFoundException e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        nido.setFocusable(false);
        nido.setBorderPainted(false);
        nido.setBounds(150,170, 300, 300);
        nido.setSize(80, 60);
        nido.setBackground(Color.DARK_GRAY);
        nido.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.out.println("Button clicked!");
                pc.setVisible(false);
                try 
                {
                    MakePass();
                } 
                catch (IOException e1) 
                {
                    e1.printStackTrace();
                }
                
            }
        });
    }

    public static void login() throws FileNotFoundException 
    {
        FileReader fr = new FileReader("inf.txt");
        ImageIcon er = new ImageIcon("rb.jpg");
        ImageIcon va = new ImageIcon("gb.jpg");
        JButton enter = new JButton("ENTER");
        
        JLabel twi = new JLabel();
        twi.setText("Password");
        twi.setIconTextGap(100);
        twi.setBounds(80,50,500,50);

        JTextField PI = new JTextField();
        PI.setBackground(Color.GRAY);
        PI.setBounds(150,65,200,20);
        PI.setVisible(true);

        JFrame window = new JFrame("LOGIN");  
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.darkGray);
        window.add(twi);
        window.add(enter);
        window.add(PI);
        window.setSize(400,200);
        window.setIconImage(lo.getImage());

        enter.setFocusable(false);
        enter.setBorderPainted(false);
        enter.setBounds(200,90, 300, 300);
        enter.setSize(100, 30);
        enter.setBackground(Color.gray);
        enter.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                int key = 4;
                String ep = PI.getText().toString();
                char[] rp = new char[ep.toString().length()];

                    try 
                    {
                        fr.read(rp);
                        fr.close();
                    } 
                    catch (IOException e1) 
                    {
                        e1.printStackTrace();

                    }

                for (int i = 0; i < rp.length; i++)
                {
                rp[i] -= key;
                }
                String decryptedPassword = new String(rp);
                if(decryptedPassword.equals(ep))
                {
                    PI.setVisible(false);
                    JLabel corec = new JLabel("you're logged in");
                    corec.setBounds(150,65,200,20);
                    window.add(corec);
                    window.setIconImage(va.getImage());
                }
                else
                {
                    window.setIconImage(er.getImage());
                    try 
                    {
                        window.setVisible(false);
                        main(null);
                    } 
                    catch (IOException e1) 
                    {
                        e1.printStackTrace();
                    }
                }

            }
        });
    } 

    public static void MakePass() throws IOException
    {
        FileWriter fn = new FileWriter("inf.txt");
        JButton set = new JButton("Set");
        JLabel twi = new JLabel();
        twi.setText("NewPassword");
        twi.setIconTextGap(100);
        twi.setBounds(60,50,500,50);

        JPasswordField NI = new JPasswordField();
        NI.setBackground(Color.GRAY);
        NI.setBounds(150,65,200,20);
        NI.setVisible(true);
    

        JFrame wind = new JFrame("MAKE_PASS");  
        wind.setVisible(true);
        wind.setLayout(null);
        wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wind.getContentPane().setBackground(Color.darkGray);
        wind.setSize(400,200);
        wind.add(NI);
        wind.add(set);
        wind.add(twi);
        wind.setIconImage(lo.getImage());

        set.setFocusable(false);
        set.setBorderPainted(false);
        set.setBounds(200,90, 300, 300);
        set.setSize(100, 30);
        set.setBackground(Color.gray);
        set.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                int key = 4;
                char[] stbe = NI.getPassword();
                for (char w : stbe )
                {
                  w += key;
                    try 
                    {
                    fn.write(w);
                    } 
                    catch (IOException e1) 
                    {
                      e1.printStackTrace();
                    }
                    
                }
                    try 
                    {
                        fn.close();
                    } 
                    catch (IOException e1) 
                    {
                    
                        e1.printStackTrace();
                    }
                System.exit(0);

            }
        });
    }
}
