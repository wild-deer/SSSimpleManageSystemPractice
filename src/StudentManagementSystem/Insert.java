package StudentManagementSystem;

import javax.swing.*;

import java.sql.*;


public class Insert extends JFrame {
    String tableName;
    Transact transact;
    JTextField field[] = null;
    String a[] = null;
    Update update;

    public void setTableName(String s) {
        tableName = s.trim();
    }

    public void setField(JTextField s[]) {
        field = s;
    }

    public void setA(String e[]) {
        a = e;
    }

    public Insert() {

    }

    public void Execute_Insert(int mark) {
        String SQL;
        Connection con;
        Statement sql;
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
            String filename = transact.TransactSQLInjection( field[mark].getText().toString());
            SQL = "insert " + tableName + "(" + a[mark] + ") values ('" + filename+ "')";
            con = DriverManager.getConnection(url, userName, userPwd);
            sql = con.createStatement();
            sql.execute(SQL);
            con.close();
            update = new Update();
            update.setTableName(tableName);
            update.setField(field);
            update.setA(a);
            update.Execute_Update(mark);
            JOptionPane.showMessageDialog(this, "添加成功！！！", "消息对话框", JOptionPane.WARNING_MESSAGE);
            for (int i = 0; i < field.length; i++)
                field[i].setText(null);
            ;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}