
package StudentManagementSystem;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class CommFrame extends JFrame implements ActionListener {

    JMenuBar bar;
    JMenu menu, menu1,menu2,menu3;
    JMenuItem scanItem, deleteItem, updateItem, insertItem, searchItem;
    JMenuItem scanItem1, deleteItem1, updateItem1, insertItem1, searchItem1;
    JMenuItem scanItem2, deleteItem2, updateItem2, insertItem2, searchItem2;
    JMenuItem scanItem3, deleteItem3, updateItem3, insertItem3, searchItem3;
    Scan_stu scan;    //查看所有学生信息
    Delete_stu delete;//删除学生信息
    Update_stu update;//更新学生信息
    Insert_stu insert;//插入学生信息
    Search_stu search;//查找学生信息

    Scan_grade scan_grade;    //查看所有学生成绩
    Delete_grade delete_grade;//删除学生成绩
    Update_grade update_grade;//更新学生成绩
    Insert_grade insert_grade;//插入学生成绩
    Search_grade search_grade;//查找学生成绩

    Scan_course scan_course;//查看所有课程信息
    Delete_course delete_course;//删除所有课程信息
    Update_course update_course;//更新课程信息
    Insert_course insert_course;//插入课程信息
    Search_course search_course;//查找课程信息

    Scan_login scan_login;//查看所有登录信息
    Delete_login delete_login;//删除登录信息
    Update_login update_login;//更新登录信息
    Insert_login insert_login;//插入登录信息
    Search_login search_login;//查找登录信息
    CardLayout card = null;

    JPanel pCenter;

    CommFrame() {
        ImageIcon tibiae=new ImageIcon("src/icon.png");
        setIconImage(tibiae.getImage());
        setLayout(new FlowLayout());
        scanItem = new JMenuItem("浏览");
        deleteItem = new JMenuItem("删除");
        updateItem = new JMenuItem("修改");
        insertItem = new JMenuItem("添加");
        searchItem = new JMenuItem("查找");

        scanItem1 = new JMenuItem("浏览");
        deleteItem1 = new JMenuItem("删除");
        updateItem1 = new JMenuItem("修改");
        insertItem1 = new JMenuItem("添加");
        searchItem1 = new JMenuItem("查找");

        scanItem2 = new JMenuItem("浏览");
        deleteItem2 = new JMenuItem("删除");
        updateItem2 = new JMenuItem("修改");
        insertItem2 = new JMenuItem("添加");
        searchItem2 = new JMenuItem("查找");

        scanItem3 = new JMenuItem("浏览");
        deleteItem3 = new JMenuItem("删除");
        updateItem3 = new JMenuItem("修改");
        insertItem3 = new JMenuItem("添加");
        searchItem3 = new JMenuItem("查找");

        bar = new JMenuBar();
        menu = new JMenu("信息管理菜单");
        menu1 = new JMenu("成绩管理菜单");
        menu2 = new JMenu("课程管理菜单");
        menu3 = new JMenu("登录管理菜单");
        menu.add(scanItem);
        menu.add(deleteItem);
        menu.add(updateItem);
        menu.add(insertItem);
        menu.add(searchItem);

        menu1.add(scanItem1);
        menu1.add(deleteItem1);
        menu1.add(updateItem1);
        menu1.add(insertItem1);
        menu1.add(searchItem1);

        menu2.add(scanItem2);
        menu2.add(deleteItem2);
        menu2.add(updateItem2);
        menu2.add(insertItem2);
        menu2.add(searchItem2);

        menu3.add(scanItem3);
        menu3.add(deleteItem3);
        menu3.add(updateItem3);
        menu3.add(insertItem3);
        menu3.add(searchItem3);

        bar.add(menu);
        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        setJMenuBar(bar);
        scanItem.addActionListener(this);
        deleteItem.addActionListener(this);
        updateItem.addActionListener(this);
        insertItem.addActionListener(this);
        searchItem.addActionListener(this);

        scanItem1.addActionListener(this);
        deleteItem1.addActionListener(this);
        updateItem1.addActionListener(this);
        insertItem1.addActionListener(this);
        searchItem1.addActionListener(this);

        scanItem2.addActionListener(this);
        deleteItem2.addActionListener(this);
        updateItem2.addActionListener(this);
        insertItem2.addActionListener(this);
        searchItem2.addActionListener(this);

        scanItem3.addActionListener(this);
        deleteItem3.addActionListener(this);
        updateItem3.addActionListener(this);
        insertItem3.addActionListener(this);
        searchItem3.addActionListener(this);

        scan = new Scan_stu();
        update = new Update_stu();
        delete = new Delete_stu();
        insert = new Insert_stu();
        search = new Search_stu();
        card = new CardLayout();

        scan_grade = new Scan_grade();
        update_grade = new Update_grade();
        delete_grade = new Delete_grade();
        insert_grade = new Insert_grade();
        search_grade = new Search_grade();
        card = new CardLayout();

        scan_course = new Scan_course();
        update_course = new Update_course();
        delete_course = new Delete_course();
        insert_course = new Insert_course();
        search_course = new Search_course();
        card = new CardLayout();

        scan_login = new Scan_login();
        update_login = new Update_login();
        delete_login = new Delete_login();
        insert_login = new Insert_login();
        search_login = new Search_login();
        card = new CardLayout();

        pCenter = new JPanel();
        pCenter.setLayout(card);
        pCenter.add("scanItem", scan);
        pCenter.add("deleteItem", delete);
        pCenter.add("updateItem", update);
        pCenter.add("insertItem", insert);
        pCenter.add("searchItem", search);

        pCenter.add("scanItem1", scan_grade);
        pCenter.add("deleteItem1", delete_grade);
        pCenter.add("updateItem1", update_grade);
        pCenter.add("insertItem1", insert_grade);
        pCenter.add("searchItem1", search_grade);

        pCenter.add("scanItem2", scan_course);
        pCenter.add("deleteItem2", delete_course);
        pCenter.add("updateItem2", update_course);
        pCenter.add("insertItem2", insert_course);
        pCenter.add("searchItem2", search_course);

        pCenter.add("scanItem3", scan_login);
        pCenter.add("deleteItem3", delete_login);
        pCenter.add("updateItem3", update_login);
        pCenter.add("insertItem3", insert_login);
        pCenter.add("searchItem3", search_login);

        add(pCenter, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(400, 150, 550, 400);
        setTitle("学生信息管理系统");
        validate();
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == scanItem)
            card.show(pCenter, "scanItem");
        else if (e.getSource() == deleteItem)
            card.show(pCenter, "deleteItem");
        else if (e.getSource() == updateItem)
            card.show(pCenter, "updateItem");
        else if (e.getSource() == insertItem)
            card.show(pCenter, "insertItem");
        else if (e.getSource() == searchItem)
            card.show(pCenter, "searchItem");

        if (e.getSource() == scanItem1)
            card.show(pCenter, "scanItem1");
        else if (e.getSource() == deleteItem1)
            card.show(pCenter, "deleteItem1");
        else if (e.getSource() == updateItem1)
            card.show(pCenter, "updateItem1");
        else if (e.getSource() == insertItem1)
            card.show(pCenter, "insertItem1");
        else if (e.getSource() == searchItem1)
            card.show(pCenter, "searchItem1");

        if (e.getSource() == scanItem2)
            card.show(pCenter, "scanItem2");
        else if (e.getSource() == deleteItem2)
            card.show(pCenter, "deleteItem2");
        else if (e.getSource() == updateItem2)
            card.show(pCenter, "updateItem2");
        else if (e.getSource() == insertItem2)
            card.show(pCenter, "insertItem2");
        else if (e.getSource() == searchItem2)
            card.show(pCenter, "searchItem2");

        if (e.getSource() == scanItem3)
            card.show(pCenter, "scanItem3");
        else if (e.getSource() == deleteItem3)
            card.show(pCenter, "deleteItem3");
        else if (e.getSource() == updateItem3)
            card.show(pCenter, "updateItem3");
        else if (e.getSource() == insertItem3)
            card.show(pCenter, "insertItem3");
        else if (e.getSource() == searchItem3)
            card.show(pCenter, "searchItem3");
    }
}