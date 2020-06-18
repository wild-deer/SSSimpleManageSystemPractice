package StudentManagementSystem;

import javax.swing.*;

import java.sql.*;


public class Delete extends JFrame {
    String tableName;
    Transact transact;
    JTextField field[] = null;
    String a[] = null;


    public void setTableName(String s) {
        tableName = s.trim();
    }

    public void setField(JTextField s[]) {
        field = s;
    }

    public void setA(String e[]) {
        a = e;
    }

    public Delete() {

    }

    public void Execute_Delete(int n) {
        String SQL = "";
        Connection con;
        Statement sql;
        String filename = transact.TransactSQLInjection(field[n].getText().toString());//正则表达式过滤掉
        SQL = "delete from " + tableName + " where " + a[n] + " ='" + filename + "'";
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
            sql.executeUpdate(SQL);
            con.close();
            JOptionPane.showMessageDialog(this, "删除成功", "消息对话框", JOptionPane.WARNING_MESSAGE);
            for (int i = 0; i < field.length; i++)
                field[i].setText(null);
            ;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}