package StudentManagementSystem;

import javax.swing.*;

import java.sql.*;


public class Search extends JFrame {
    String tableName;
    Transact transact;
    JTextField field[] = null;
    String a[] = null;
    Object object[][];
    String b[];

    public void setTableName(String s) {
        tableName = s.trim();
    }

    public void setField(JTextField s[]) {
        field = s;
    }

    public void setA(String e[]) {
        a = e;
    }

    public Search() {

    }

    public void Execute_Search() {
        String SQL = "select * from " + tableName + " where ";
        Connection con;
        Statement sql;
        ResultSet rs;
        String fieldname;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (field[i].getText().toString().equals("") == false) {
                fieldname =transact.TransactSQLInjection(field[i].getText().toString());
                if (sum == 0)

                    SQL = SQL + a[i] + " = '" + fieldname + "'";
                else
                    SQL = SQL + " and " + a[i] + " = '" + fieldname + "'";
                sum++;
            }

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
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery(SQL);
            rs.last();
            object = new Object[rs.getRow()][a.length];
            rs.beforeFirst();
            int ncase = 0;
            while (rs.next()) {
                for (int i = 1; i <= a.length; i++) {
                    object[ncase][i - 1] = rs.getString(i);
                }
                ncase++;
            }
            con.close();
            for (int i = 0; i < field.length; i++)
                field[i].setText(null);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Object[][] getRecord() {
        return object;
    }
}