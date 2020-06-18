package StudentManagementSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class LLogin {

    public static void main(String[] args) {
        new loginFrame();
    }
}

class loginFrame extends JFrame implements ActionListener{

    Box box1,box2,baseBox;
    JLabel userName,userPwd,tubiao;
    JTextField nameField;
    JPasswordField pwdField;
    JButton button;
    JTabbedPane choose;
    JPanel panel1,panel2;
    loginFrame(){
        setBackground(Color.orange);
        tubiao=new JLabel(new ImageIcon("src/b2.jpg"));  //图片在原有基础上要调整大小
        add(tubiao,BorderLayout.NORTH);
        userName=new JLabel("账号",JLabel.CENTER);
        userPwd=new JLabel("密码",JLabel.CENTER);
        nameField=new JTextField(8);
        pwdField=new JPasswordField(8);
        panel1=new JPanel();
        panel2=new JPanel();
        choose=new JTabbedPane();
        choose.add("请输入用户名和密码",panel1);
        panel1.setLayout(new GridLayout(2,2));
        panel1.add(userName);panel1.add(nameField);
        panel1.add(userPwd);panel1.add(pwdField);
        add(choose,BorderLayout.CENTER);
        button=new JButton("登陆");
        add(button,BorderLayout.SOUTH);
        button.addActionListener(this);
        //小图标
        ImageIcon tubiao=new ImageIcon("src/icon.png");
        setIconImage(tubiao.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(400,150,550,400);
        setTitle("学生学籍信息管理系统");
        validate();
    }


    public void actionPerformed(ActionEvent e){
        String name,pwd;
        name=nameField.getText();
        pwd=pwdField.getText();


        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //加载数据库驱动
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
        try{
            Connection con;
            Statement sql;
            ResultSet rs,rs1;
            String url,userName,userPwd;
            // 连接数据库的语句
            url="jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&serverTimezone=UTC";
            userName="root";
            userPwd="YJLs13981383032";
            con=DriverManager.getConnection(url,userName,userPwd);
            sql=con.createStatement();
            rs=sql.executeQuery("select * from login where name ='"+name+"' and pwd='"+pwd+"'");//对应自己数据库建的表填写
            int q=0;
            while(rs.next()){

                q++;
            }
            int p = 0;
            rs1=sql.executeQuery("select * from root where name ='"+name+"' and pwd='"+pwd+"'");//对应自己数据库建的表填写
            while (rs1.next()){
                p++;
            }

            if(q>0||p>0){
                JOptionPane.showMessageDialog(this, "登陆成功！","消息对话框",JOptionPane.WARNING_MESSAGE);
                this.dispose();
                if(p > 0){
                    new CommFrame();
                }
                if(q > 0){
                    new CommFrame1();
                }
            }
            else
                JOptionPane.showMessageDialog(this, "账号或者密码错误!","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
        catch(SQLException exp){
            System.out.println(exp);
        }

    }
}