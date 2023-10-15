import javafx.scene.control.Labeled;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;


public class PizzaGUIFrame {
    private JFrame window;
    private JCheckBox Pepperoni;
    private JCheckBox Pineapple;
    private JCheckBox extraCheese;
    private JCheckBox sausage;
    private JCheckBox Bacon;
    private JCheckBox Ham;
    private ButtonGroup group;
    private JComboBox pizzaSize;
    private int cost;
    private double tax;
    private double total;


    private JTextArea displayTA = new JTextArea(20, 50);;

    public PizzaGUIFrame() {

    }


    public void initialize() {
        window = new JFrame();
        window.setTitle("Pizza Form");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1440, 1000);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout(10, 5));
        window.setVisible(true);
    }

    public void createDisplayPanel() {
        JPanel displayPnl = new JPanel();
        JPanel controlPnl = new JPanel();
        displayTA.setEditable(false);
        displayTA. setFont(new Font("Serif", Font. PLAIN, 24));
        JScrollPane scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
        controlPnl.setLayout(new GridLayout(1, 3));
        JButton Order = new JButton("Order");
        JButton clear = new JButton("Clear");
        JButton Quit = new JButton("Quit");
        Quit.addActionListener(((ActionEvent ae) -> quit()));
        clear.addActionListener(((ActionEvent ae) -> clear()));
        Order.addActionListener(((ActionEvent ae) -> order()));
        controlPnl.add(Order);
        controlPnl.add(clear);
        controlPnl.add(Quit);
        window.add(displayPnl, BorderLayout.EAST);
        window.add(controlPnl, BorderLayout.SOUTH);



    }



    public void createImageIcon() {
        JPanel crust = new JPanel();
        crust.setLayout(new GridLayout(1, 3));
        crust.setBorder(new TitledBorder(new EtchedBorder(), "Crust Type"));
        JRadioButton thin = new JRadioButton("Thin");
        crust.add(thin);
        JRadioButton Regular = new JRadioButton("Regular");
        crust.add(Regular);
        JRadioButton Deep = new JRadioButton("Deep-dish");
        crust.add(Deep);
        group = new ButtonGroup();
        group.add(thin);
        group.add(Regular);
        group.add(Deep);
        window.add(crust, BorderLayout.NORTH);

        JPanel size = new JPanel();
        size.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Size"));
        pizzaSize = new JComboBox();
        pizzaSize.addItem("Small");
        pizzaSize.addItem("Medium");
        pizzaSize.addItem("Large");
        pizzaSize.addItem("Super");
        size.add(pizzaSize);
        window.add(size, BorderLayout.WEST);

        JPanel topings = new JPanel();
        topings.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Toppings"));
        topings.setLayout(new GridLayout(2, 3));
        Pepperoni = new JCheckBox("Pepperoni");
        Pineapple = new JCheckBox("Pineapple");
        extraCheese = new JCheckBox("Extra Cheese");
        Ham = new JCheckBox("Ham");
        Bacon = new JCheckBox("Bacon");
        sausage = new JCheckBox("Sausage");
        topings.add(Pepperoni);
        topings.add(Pineapple);
        topings.add(extraCheese);
        topings.add(Ham);
        topings.add(Bacon);
        topings.add(sausage);
        window.add(topings, BorderLayout.CENTER);


    }

    public void quit(){
        int answer = JOptionPane.showConfirmDialog(window, "Would you like to quit?");
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void clear(){
        Ham.setSelected(false);
        extraCheese.setSelected(false);
        sausage.setSelected(false);
        Pineapple.setSelected(false);
        Pepperoni.setSelected(false);
        Bacon.setSelected(false);

        group.clearSelection();

        pizzaSize.setSelectedIndex(0);
        displayTA.setText("");
    }


    public void order(){
        pizzaSize.getSelectedIndex();
        if(pizzaSize.getSelectedIndex() == 0){
            cost = 8;
            tax = cost * .07;
            total = cost + tax;
        }
        else if (pizzaSize.getSelectedIndex() == 1){
            cost = 12;
            tax = cost * .07;
            total = cost + tax;
        }
        else if (pizzaSize.getSelectedIndex() == 2){
            cost = 16;
            tax = cost * .07;
            total = cost + tax;
        }
        else if (pizzaSize.getSelectedIndex() == 3){
            cost = 20;
            tax = cost * .07;
            total = cost + tax;
        }
        displayTA.append("=============================================================" + "\n" + "\n"+ "\n" +
                "cost               " + cost + "\n" + "\n" + "\n" +
                "tax               " + tax + "\n" + "\n" + "\n" +
                "total             " + total + "\n" + "\n" + "\n" +
                "=============================================================");

    }



}
