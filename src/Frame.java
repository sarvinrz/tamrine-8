

         import javax.swing.*;
         import javax.swing.*;
         import java.awt.*;
         import java.sql.Connection;
         import java.sql.DriverManager;
         import java.sql.PreparedStatement;
         import java.sql.SQLException;


         public class Frame {
     JFrame frame = new JFrame("انتخاب واحد");
     JPanel panel = new JPanel(new BorderLayout(5,2));
     JPanel centerpanel = new JPanel(new GridLayout(6,1));
     JLabel title = new JLabel("انتخاب واحد ",JLabel.CENTER);
     JTextField name = new JTextField();
     JTextField vahed = new JTextField();
     JButton ok = new JButton("ok ! ");


             public void Startup(){
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setSize(600, 800);
                 frame.setLocationRelativeTo(null);
                 frame.setVisible(true);
                 frame.add(panel);
                 panel.add(centerpanel,BorderLayout.CENTER);
                 panel.add(title,BorderLayout.NORTH);
                 title.setFont(new Font("aa",Font.PLAIN,40));
                 centerpanel.add(name);
                 name.setBorder(BorderFactory.createTitledBorder("اسم حود را وارد کنید "));
                 centerpanel.add(vahed);
                 centerpanel.add(ok);
                 vahed.setBorder(BorderFactory.createTitledBorder("واحدهای حود را بنویسید"));
                 ok.addActionListener(e-> {
                         try {
                                 sender();
                            } catch (SQLException ex) {
                                 ex.printStackTrace();
                             } catch (ClassNotFoundException ex) {
                                 ex.printStackTrace();
                             }
                   });
             }
     public void sender() throws SQLException, ClassNotFoundException {
                 String Name=name.getText();
                 String Vahed=vahed.getText();
                 Name=Name+" "+Vahed;
                 System.out.println(Name);
                 database(Name);
     }
     public void database(String a ) throws SQLException, ClassNotFoundException {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                 Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sarvin","myjava123");
                 PreparedStatement preparedStatement = connection.prepareStatement("insert into Vahed (vahed) values (?)");
                 preparedStatement.setString(1, a);
                 preparedStatement.executeUpdate();
                 preparedStatement.close();
                 connection.close();
     }
         }


