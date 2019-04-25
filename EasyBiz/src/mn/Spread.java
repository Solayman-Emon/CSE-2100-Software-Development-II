package githubNahid244;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Spread extends JPanel{
    private Mxcel mxcel;
     private JTextField textfield,textfield1,textfield2,textfield3,textfield4;
    private JLabel label,label1,label2,label3,label4;
    private Font font;
    private JButton but;
    public Spread(Mxcel mxcel){
        init();
        this.mxcel=mxcel;
    }
    public void init(){
         font=new Font("Arial",Font.BOLD,20);
          textfield=new JTextField();
        textfield.setBounds(120,0,100,25);
      
      
      textfield1=new JTextField();
      
      textfield1.setBounds(80,40,100,25);
     
       textfield2=new JTextField();
      
      textfield2.setBounds(250,40,100,25);
      
       textfield3=new JTextField();
      
      textfield3.setBounds(560,00,100,25);
      
      
       textfield4=new JTextField();
      
      textfield4.setBounds(320,00,100,25);
      
      
      
        label=new JLabel();
        label.setFont(font);
        label.setText("ColumnNo:");
        label.setBounds(10,0,150,20);
        
         label1=new JLabel();
        label1.setFont(font);
        label1.setText("From:");
        label1.setBounds(10,40,100,25);
        
        label2=new JLabel();
        label2.setFont(font);
        label2.setText(",To:");
        label2.setBounds(200,40,100,25);
        
         label3=new JLabel();
        label3.setFont(font);
        label3.setText("Difference:");
        label3.setBounds(450,0,120,25);
        
        
         label4=new JLabel();
        label4.setFont(font);
        label4.setText("Start:");
        label4.setBounds(250,0,100,25);
        
        
          but=new JButton("Ok");
          but.setBounds(500,40,100,25);
      but.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 try{
                 int col=Integer.parseInt(textfield.getText().toString());
                 int from=Integer.parseInt(textfield1.getText().toString());
                 int to=Integer.parseInt(textfield2.getText().toString());
                 int dif=Integer.parseInt(textfield3.getText().toString());
                 int strt=Integer.parseInt(textfield4.getText().toString());
                 
                 
                 for(int i=from;i<=to;i++){
                     mxcel.getRowHeader().table.setValueAt(strt, i, col);
                     strt+=dif;
                 }
                 
                 
                 
                 
                 
                 textfield.setText("");
                  textfield1.setText("");
                   textfield2.setText("");
                    textfield3.setText("");
                     textfield4.setText("");
                 
                 
                 
                 
                 }
                 catch(Exception el){
                     
                 }
             }
      
      });
      
        
        
        
        
        
        
         this.add(textfield);
          this.add(textfield1);
           this.add(textfield2);
            this.add(textfield3);
            this.add(textfield4);
         
            
            this.add(label);
            this.add(label1);
            this.add(label2);
            this.add(label3);
             this.add(label4);
            
             this.add(but);
             
          this.setBounds(10, 0, 720, 90);
        this.setBackground(new Color(130,168,180));
      this.setVisible(false);
        this.setLayout(null);
    }
}

