package githubNahid244;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Sums extends JPanel{
    private Mxcel mxcel;
     private JButton but;
    
    private JTextField textfield,textfield1,textfield2,textfield3,textfield4;
    private JLabel label,label1,label2,label3,label4;
     private Font font;
    
     
     
    public Sums(Mxcel mxcel){
        init();
        this.mxcel=mxcel;
    }
    public void init(){
         font=new Font("Arial",Font.BOLD,20);
        
        textfield=new JTextField();
        textfield.setBounds(180,0,200,25);
      this.add(textfield);
      
      textfield1=new JTextField();
      
      textfield1.setBounds(80,40,100,25);
      this.add(textfield1);
        
       textfield2=new JTextField();
      
      textfield2.setBounds(250,40,100,25);
        
       this.add(textfield2); 
        
       textfield3=new JTextField();
      
      textfield3.setBounds(480,0,100,25);
        
       this.add(textfield3); 
        
        textfield4=new JTextField();
      
      textfield4.setBounds(480,40,100,25);
        
       this.add(textfield4); 
       
       
         label=new JLabel();
        label.setFont(font);
        label.setText("Column Number");
        label.setBounds(10,0,200,20);
        
         label1=new JLabel();
        label1.setFont(font);
        label1.setText("From:");
        label1.setBounds(10,40,100,25);
        
        label2=new JLabel();
        label2.setFont(font);
        label2.setText(",,,To");
        label2.setBounds(200,40,100,25);
        
        label3=new JLabel();
        label3.setFont(font);
        label3.setText("ColNo:");
        label3.setBounds(400,40,100,25);
        
        label4=new JLabel();
        label4.setFont(font);
        label4.setText("RowNo:");
        label4.setBounds(400,0,100,25);
        
        this.add(label);
         this.add(label1);
          this.add(label2);
          this.add(label3);
          this.add(label4);
        
         but=new JButton("ok");
        but.setBounds(600,40,100,25);
       
        but.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 
                 try{
                 
              int a=Integer.parseInt(textfield.getText().toString());
              int b=Integer.parseInt(textfield1.getText().toString());
              int c=Integer.parseInt(textfield2.getText().toString());
               Double Ans=0.0;  
              for(int i=b;i<=c;i++){
                  Ans+=Double.parseDouble((String) mxcel.getRowHeader().table.getValueAt(i, a)) ;
              }
              mxcel.getRowHeader().table.setValueAt(Ans, Integer.parseInt(textfield3.getText().toString()),Integer.parseInt(textfield4.getText().toString()) );
              textfield.setText("");
              textfield1.setText("");
              textfield2.setText("");
              textfield3.setText("");
              textfield4.setText("");
              
                 }catch(Exception ey){
                     
                 }
              
             }
        
        
        });
        
         this.add(but);
          
         this.setBounds(10, 0, 720, 90);
        this.setBackground(new Color(130,168,180));
      this.setVisible(false);
        this.setLayout(null);
    }
}


