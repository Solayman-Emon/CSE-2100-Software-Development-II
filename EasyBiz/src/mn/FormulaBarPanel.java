package githubNahid244;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Character.isAlphabetic;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class FormulaBarPanel extends JPanel{
    private FormulaBar formulabar;
    private JButton but;
    private  Mxcel mxcel;
    private JTextField textfield,textfield1,textfield2,textfield3;
    private JLabel label,label1,label2,label3;
    private Font font;
   // String[] sw={"A","B","C","D"};
    //double A[]={34,5,6};
    public FormulaBarPanel(Mxcel mxcel){
        init();
        this.mxcel=mxcel;
    }
    public void init(){
        
        formulabar=new FormulaBar();
        
         font=new Font("Arial",Font.BOLD,20);
        
        textfield=new JTextField();
        textfield.setBounds(100,0,200,25);
      
      
      textfield1=new JTextField();
      
      textfield1.setBounds(80,40,100,25);
      this.add(textfield1);
        
       textfield2=new JTextField();
      
      textfield2.setBounds(250,40,100,25);
      
       textfield3=new JTextField();
      
      textfield3.setBounds(400,00,100,25);
      
      
      
        label=new JLabel();
        label.setFont(font);
        label.setText("Formula:");
        label.setBounds(10,0,150,20);
        
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
        label3.setText("Col:");
        label3.setBounds(360,0,100,25);
        
        but=new JButton("ok");
        but.setBounds(400,40,100,25);
        but.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 
                 try{
                 int a= Integer.parseInt(textfield1.getText().toString());
                 int b=Integer.parseInt(textfield2.getText().toString());
                 int col=Integer.parseInt(textfield3.getText().toString());
                 
                 
                for(int i=a;i<=b;i++){
                     String s=textfield.getText().toString();
                     ////srt
                     char [] tokens=s.toCharArray();
                      Stack<Character> values = new Stack<Character>();
                     for(int k=0;k<tokens.length;k++){
                          if(tokens[k]>='A' && tokens[k]<='Z'){
                          values.push(tokens[k]);
                          }
                     }
                     while(!values.empty()){
                         char y=values.pop();
                        
                         s=s.replaceAll(String.valueOf(y),String.valueOf(mxcel.getRowHeader().table.getValueAt(i,y-'A')));
                     }
                     
                     ///end
                      //s=s.replace("", " ").trim();
                     //DefaultTableModel model=(DefaultTableModel) rohim.getRowHeader().table.getModel();
                  /*  s=s.replaceAll("A", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 0)));
                     s=s.replaceAll("B", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 1)));
                      s=s.replaceAll("C", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 2)));
                  s=s.replaceAll("D", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 3)));
                     s=s.replaceAll("E", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 4)));
                      s=s.replaceAll("F", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 5)));   
                  s=s.replaceAll("G", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 6)));
                     s=s.replaceAll("H", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 7)));
                      s=s.replaceAll("I", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 8)));     
                   s=s.replaceAll("J", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 9)));
                     s=s.replaceAll("K", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 10)));
                      s=s.replaceAll("L", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 11)));    
                   
                   s=s.replaceAll("M", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 12)));
                     s=s.replaceAll("N", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 13)));
                      s=s.replaceAll("O", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 14)));
                  
                    s=s.replaceAll("P", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 15)));
                     s=s.replaceAll("Q", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 16)));
                      s=s.replaceAll("R", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 17)));
                   
                    s=s.replaceAll("S", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 18)));
                     s=s.replaceAll("T", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 19)));
                      s=s.replaceAll("U", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 20)));  
                    
                   
                    s=s.replaceAll("V", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 21)));
                     s=s.replaceAll("W", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 22)));
                      s=s.replaceAll("X", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 23)));
                   
                    s=s.replaceAll("Y", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 24)));
                     s=s.replaceAll("Z", String.valueOf(rohim.getRowHeader().table.getValueAt(i, 25)));
                         
                    */  
                      
                  Double Ans=formulabar.eval(s);
                  //System.out.println(Ans);
                 
                  mxcel.getRowHeader().table.setValueAt(Ans, i, col);
                  
                 }
                 
                 
//                 System.out.println(a);
//                 System.out.println(b);
//                   System.out.println(col);
                   textfield.setText("");
                   textfield1.setText("");
                   textfield2.setText("");
                   textfield3.setText("");
                 
                   
                 }catch(NumberFormatException eg){
                           }
                   
             }
             
        
            
        
        });
        
        
        
        this.add(label);
         this.add(label1);
         this.add(label2);
          this.add(label3);
        this.add(textfield);
        this.add(textfield2);
         this.add(textfield3);
         
         this.add(but);
        this.setBounds(10, 0, 720, 90);
        this.setBackground(new Color(130,168,180));
      this.setVisible(false);
        this.setLayout(null);
    }
}


