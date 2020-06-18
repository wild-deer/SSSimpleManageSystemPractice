package StudentManagementSystem;

import javax.swing.*;

import java.sql.*;


public class Update extends JFrame {
    String tableName;
    JTextField field[] = null;
    String a[] = null;
    Transact transact;

    public void setTableName(String s) {
        tableName = s.trim();
    }

    public void setField(JTextField s[]) {
        field = s;
    }

    public void setA(String e[]) {
        a = e;
    }

    public Update() {

    }

    public void Execute_Update(int mark) {
        String SQL[] = new String[a.length];
        Connection con;
        Statement sql;
        String fieldnamei,fieldnamemark ;
        for (int i = 0; i < a.length; i++) {
            fieldnamei = field[i].getText().toString();
            fieldnamemark = field[mark].getText().toString();
            if (i != mark)
                SQL[i] = "update " + tableName + " set " + a[i] + " ='" + fieldnamei + "' where " + a[mark] + " ='" + fieldnamemark + "'";
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exp) {
            System.out.println(exp);
        }
        try {
            String url, userName, userPwd;
            url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&serverTimezone=UTC";
            userName = "root";
            userPwd = "YJLs13981383032";
            con = DriverManager.getConnection(url, userName, userPwd);
            sql = con.createStatement();
            for (int i = 0; i < field.length; i++)
                if (i != mark && field[i].getText().toString().equals("") == false)
                    sql.executeUpdate(SQL[i]);
            con.close();
            for (int i = 0; i < field.length; i++)
                field[i].setText(null);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}