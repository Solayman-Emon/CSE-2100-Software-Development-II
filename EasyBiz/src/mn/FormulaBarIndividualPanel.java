package githubNahid244;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Character.isDigit;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FormulaBarIndividualPanel extends JPanel{
    private Mxcel mxcel;
    private FormulaBar formulabar;
    private JButton but;
    private JTextField textfield,textfield1,textfield2;
    private JLabel label,label1,label2;
     private Font font;
    
    public FormulaBarIndividualPanel(Mxcel mxcel){
        init();
        this.mxcel=mxcel;
    }
    public void init(){
        
      formulabar=new FormulaBar();
        
         font=new Font("Arial",Font.BOLD,20);
        
        textfield=new JTextField();
        textfield.setBounds(100,0,200,25);
      
      
      textfield1=new JTextField();
      
      textfield1.setBounds(90,40,100,25);
     
        
       textfield2=new JTextField();
      
      textfield2.setBounds(290,40,100,25);
      
       label=new JLabel();
        label.setFont(font);
        label.setText("Formula:");
        label.setBounds(10,0,150,20);
        
         label1=new JLabel();
        label1.setFont(font);
        label1.setText("RowNo:");
        label1.setBounds(10,40,100,25);
        
        label2=new JLabel();
        label2.setFont(font);
        label2.setText("ColNo:");
        label2.setBounds(220,40,100,25);
      
         but=new JButton("ok");
        but.setBounds(500,40,100,25);
      
        
        but.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              try{
              String s=textfield.getText().toString();
              int a= Integer.parseInt(textfield1.getText().toString());
                 int b=Integer.parseInt(textfield2.getText().toString());
              
               Stack<String> val=new Stack<String>();
               int A[]={3,2,8,1,0,6};
              int i=0;
               s+="?";
               char []tokens=s.toCharArray();
              while(i!=tokens.length){
                  String sw;
                     if(tokens[i]>='A' && tokens[i]<='Z'){
                      sw=String.valueOf(tokens[i]);
                          while(isDigit(tokens[i+1]) && i<tokens.length){
                                  i++;
                            sw+=String.valueOf(tokens[i]);
                     }
           
                   System.out.println(sw);
                  val.push(sw);
                     } 
                       i++;
                          } 
                         s=s.substring(0,s.length()-1);
                      while(!val.empty()){
                          String x=val.pop();
                          String []y=x.split("[A-Z]");
                          String []z=x.split("[0-9]");
                          char c=z[0].charAt(0);
                          System.out.println(c);
                          s=s.replaceAll(x, String.valueOf(mxcel.getRowHeader().table.getValueAt(Integer.parseInt(y[1]),c-'A' )));
                          
                      }
   
              System.out.println(s);
              Double Ans=formulabar.eval(s);
                  //System.out.println(Ans);
                  mxcel.getRowHeader().table.setValueAt(Ans, a, b);
               textfield.setText("");
                   textfield1.setText("");
                   textfield2.setText("");
                   
                   
              }catch(NumberFormatException er){
              }
                   
                   
          }
        
        
        
        
        });
        
        
        
        
        
      this.add(but);
       this.add(textfield);
         this.add(textfield1);
           this.add(textfield2);
      
        this.add(label);
        this.add(label1);
        this.add(label2);
           
           
        this.setBounds(10, 0, 720, 90);
        this.setBackground(new Color(130,168,180));
      this.setVisible(false);
        this.setLayout(null);
    }
}


