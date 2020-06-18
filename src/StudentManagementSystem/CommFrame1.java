
package StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommFrame1 extends JFrame implements ActionListener {

    JMenuBar bar;
    JMenu menu, menu1,menu2;
    JMenuItem scanItem,  searchItem;
    JMenuItem scanItem1, searchItem1;
    JMenuItem scanItem2,searchItem2;
    Scan_stu scan;    //查看所有学生信息
    Search_stu search;//查找学生信息

    Scan_grade scan_grade;    //查看所有学生成绩
    Search_grade search_grade;//查找学生成绩

    Scan_course scan_course;    //查看所有学生成绩
    Search_course search_course;//查找学生成绩
    CardLayout card = null;

    JPanel pCenter;

    CommFrame1() {
        ImageIcon tibiae=new ImageIcon("src/icon.png");
        setIconImage(tibiae.getImage());
        setLayout(new FlowLayout());
        scanItem = new JMenuItem("浏览");
        searchItem = new JMenuItem("查找");

        scanItem1 = new JMenuItem("浏览");
        searchItem1 = new JMenuItem("查找");

        scanItem2 = new JMenuItem("浏览");
        searchItem2 = new JMenuItem("查找");

        bar = new JMenuBar();
        menu = new JMenu("学生基本信息查询");
        menu1 = new JMenu("成绩查询");
        menu2 = new JMenu("课程查询");
        menu.add(scanItem);
        menu.add(searchItem);

        menu1.add(scanItem1);
        menu1.add(searchItem1);

        menu2.add(scanItem2);
        menu2.add(searchItem2);

        bar.add(menu);
        bar.add(menu1);
        bar.add(menu2);
        setJMenuBar(bar);
        scanItem.addActionListener(this);
        searchItem.addActionListener(this);

        scanItem1.addActionListener(this);
        searchItem1.addActionListener(this);

        scanItem2.addActionListener(this);
        searchItem2.addActionListener(this);

        scan = new Scan_stu();
        search = new Search_stu();
        card = new CardLayout();

        scan_grade = new Scan_grade();
        search_grade = new Search_grade();
        card = new CardLayout();

        scan_course = new Scan_course();
        search_course = new Search_course();
        card = new CardLayout();

        pCenter = new JPanel();
        pCenter.setLayout(card);
        pCenter.add("scanItem", scan);
        pCenter.add("searchItem", search);

        pCenter.add("scanItem1", scan_grade);
        pCenter.add("searchItem1", search_grade);

        pCenter.add("scanItem2", scan_course);
        pCenter.add("searchItem2", search_course);

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
        else if (e.getSource() == searchItem)
            card.show(pCenter, "searchItem");

        if (e.getSource() == scanItem1)
            card.show(pCenter, "scanItem1");
        else if (e.getSource() == searchItem1)
            card.show(pCenter, "searchItem1");

        if (e.getSource() == scanItem2)
            card.show(pCenter, "scanItem2");
        else if (e.getSource() == searchItem2)
            card.show(pCenter, "searchItem2");
    }
}