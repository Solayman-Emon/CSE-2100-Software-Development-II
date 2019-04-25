package githubNahid244;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MonteCarlo extends JPanel{
    private Mxcel mxcel;
     private JTextField textfield,textfield1,textfield2,textfield3;
    private JLabel label,label1,label2,label3;
    private Font font;
    private JButton but;
  // Random r=new Random();
    public MonteCarlo(Mxcel mxcel){
         init();
        this.mxcel=mxcel;
    }
     public void init(){
         font=new Font("Arial",Font.BOLD,20);
        
         
           textfield=new JTextField();
        textfield.setBounds(100,0,200,25);
      
      
      textfield1=new JTextField();
      
      textfield1.setBounds(100,40,100,25);
      
        
       textfield2=new JTextField();
      
      textfield2.setBounds(350,40,100,25);
      
      
         
      
       label=new JLabel();
        label.setFont(font);
        label.setText("Start:");
        label.setBounds(10,0,150,20);
        
         label1=new JLabel();
        label1.setFont(font);
        label1.setText("Number:");
        label1.setBounds(10,40,100,25);
        
        label2=new JLabel();
        label2.setFont(font);
        label2.setText("Volatility:");
        label2.setBounds(230,40,150,25);
        
        
       but=new JButton("Ok");
          but.setBounds(500,40,100,25);
      but.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 try{
                 double start=Double.parseDouble(textfield.getText().toString());
                 int num=Integer.parseInt(textfield1.getText().toString());
                 double vol=Double.parseDouble(textfield2.getText().toString());
                 
                 double vol1=(vol*start)/100;
                 
                 System.out.println(vol1);
                 mxcel.getRowHeader().table.setValueAt("Month",0 , 1);
                  mxcel.getRowHeader().table.setValueAt("Simulated Price",0 , 2);
                 for(int i=1;i<=num;i++){
                     mxcel.getRowHeader().table.setValueAt(i,i , 1);
                      mxcel.getRowHeader().table.setValueAt(Mnt(vol1,start),i , 2);
                 }
                 
                 
                  textfield.setText("");
                   textfield1.setText("");
                   textfield2.setText("");
                 
                 
                 }
                 catch(Exception el){
                     
                 }
             }
      
      });
      
      this.add(label);
      this.add(label1);
      this.add(label2);
      
      this.add(but);
       this.add(textfield);  
      this.add(textfield1);   
      this.add(textfield2);
      
         
          this.setBounds(10, 0, 720, 90);
        this.setBackground(new Color(130,168,180));
      this.setVisible(false);
        this.setLayout(null);
    }
    public double Mnt(double prc,double strt){
        
          Random r=new Random();
         double x=r.nextInt(100)*(0.1);
         double y=r.nextInt(200)*(0.1);
         
         
       double xx=(1/(prc*Math.sqrt(2*3.1416)))*Math.exp((-0.5)*Math.pow((x/prc), 2));
        double yy=(1/(prc*Math.sqrt(2*3.1416)))*Math.exp((-0.5)*Math.pow(y/prc, 2));
         
         
         return ((xx-yy)+1)*strt;
        
    }
}
