import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;

public class calenderGUI {

   private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
   private JList<String> list = new JList<String>(months); 
   private JTextField year = new JTextField(4); 
   private JButton button = new JButton("Get Calendar"); 
   
   public static void main(String[] args) {
   
      new calenderGUI().go();
   }
   
   public void go() {
      
      JFrame frame = new JFrame(); 
      JPanel p = new JPanel(); 
      JPanel p2 = new JPanel(); 
      
      //JList list = new JList(months);
      list.setVisibleRowCount(6);
      list.setForeground(Color.black);
      list.setBackground(Color.white);
      list.setSelectionForeground(Color.white);
      list.setSelectionBackground(Color.black); 
      list.addListSelectionListener(new getCalendar());
      p.add(new JScrollPane(list)); 
      JLabel label = new JLabel("Please enter a year");
      label.setForeground(Color.white);
      p2.add(label);
      p2.add(year, BorderLayout.CENTER); 
      p2.add(button, BorderLayout.SOUTH);
      p.setBackground(Color.black);
      p2.setBackground(Color.black);
      year.setBackground(Color.white);
      button.addActionListener(new getCalendar2());
      frame.add(p); 
      frame.add(p2, BorderLayout.SOUTH);
      frame.setSize(800, 200);
      //frame.pack();
      frame.setTitle("Calendar");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
      
      
   }
   
   class getCalendar implements ListSelectionListener {
      public void valueChanged(ListSelectionEvent e) {
         System.out.println(list.getSelectedIndex());
      
      }
   }
   
   
   class getCalendar2 implements ActionListener {
      public void  actionPerformed(ActionEvent event){
         int yearNsheeit = Integer.parseInt(year.getText());
         showCalendar(list.getSelectedIndex(), yearNsheeit); 
      
      }
   }
   
   public void showCalendar(int month, int year) {
      JFrame frame = new JFrame();
      String monthName = "";
      int numDays = 0; 
      GregorianCalendar calendar = new GregorianCalendar(year, month, 1);
      frame.setLayout(new BorderLayout());
      JPanel panel3 = new JPanel(new BorderLayout());
      JPanel panel2 = new JPanel(new GridLayout(1, 7));
      Border lineBorder = new LineBorder(Color.BLACK, 1);
      panel2.setBorder(lineBorder);
      
      panel2.add(new JLabel("Sunday", 0));
      panel2.add(new JLabel("Monday", 0));
      panel2.add(new JLabel("Tuesday", 0));
      panel2.add(new JLabel("Wednesday", 0));
      panel2.add(new JLabel("Thursday", 0));
      panel2.add(new JLabel("Friday", 0));
      panel2.add(new JLabel("Saturday", 0));
     
     switch(month){
      case 0:
         monthName = "January";
         numDays = 31;
         break;
      
      case 1:
         monthName = "February";
         if(year % 4 == 0)
            numDays = 29;
         else
            numDays = 28;
         break;
       
      case 2:
         monthName = "March";
         numDays = 31;
         break;
       
       case 3:
         monthName = "April";
         numDays = 30;
         break;
       
       case 4:
         monthName = "May";
         numDays = 31;
         break;
       
       case 5:
         monthName = "June";
         numDays = 30;
         break;
       
       case 6:
         monthName = "July";
         numDays = 31;
         break;
         
        case 7:
         monthName = "August";
         numDays = 31;
         break;
         
         case 8:
         monthName = "September";
         numDays = 30;
         break;
         
         case 9:
         monthName = "October";
         numDays = 31;
         break;
         
         case 10:
         monthName = "November";
         numDays = 30;
         break;
         
         case 11:
         monthName = "December";
         numDays = 31;
         break;
        }
        
     JLabel label = new JLabel(monthName + " " + year, 0);
     
     panel3.add(label, BorderLayout.NORTH);
     panel3.add(panel2, BorderLayout.CENTER);
     
      JPanel panel = new JPanel(new GridLayout(0, 7));
      
      for(int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++){
         panel.add(new JLabel());
      }
      
      for(int i = 1; i <= numDays; i++){
         panel.add(addLabel(i));
      }
      
      panel.setBackground(Color.white);
      frame.add(panel3, BorderLayout.NORTH);
      frame.add(panel, BorderLayout.CENTER);
      
      frame.setSize(800, 400);
      frame.setTitle("Calendar");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
   
   }
   
    public JLabel addLabel(int num) {
      JLabel label = new JLabel("" + num);
      Border lineBorder = new LineBorder(Color.BLACK, 1);
      label.setBorder(lineBorder);
      label.setForeground(Color.blue);
      return label;
   }


}//end main class
