package githubNahid244;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


public class Mxcel extends JFrame{
    private Container c;
    
    private Sums sum;
    
    private SaveAs saveas;
    private Open open;
    private Save save;
   // private JFrame jf=this;
    
    //button
    private JButton but1,but2,but3,but4;
    ///icon
    private ImageIcon icon1,icon2,icon3;
    
    private Spread spread;
    
    private MonteCarlo mcarlo;
    
    
    
    private RowHeader rtable;
    private TableColumn tl; 
    private ListSelectionModel cellSelection;
   private FormulaBarPanel fbarpanel;
    
   private FormulaBarIndividualPanel fbarpanelInd;
   
    //menu
    private JMenuBar menubar;
    private JMenu filemenu,filemenu1;
    private JMenuItem newMenuitem,newMenuitem1,newMenuitem2,newMenuitem3,newMenuitem4,newMenuitem5,newMenuitem6,newMenuitem7,newMenuitem8,newMenuitem9,newMenuitem10;
    public Mxcel(){
        init();
       
    }
    public void init(){
        c=this.getContentPane();
        c.setLayout(null);
        
        c.setBackground(new Color(195,195,195));
        
       
        sum=new Sums(this);
        
        rtable=new RowHeader();
        
         open=new Open(this);
         saveas= new SaveAs(this);
         save=new Save(this);
         spread=new Spread(this);
         mcarlo=new MonteCarlo(this);
       // tl=rtable.table.getColumnModel().getColumn(0);
//      cellSelection=rtable.table.getSelectionModel();
//      cellSelection.addListSelectionListener(new ListSelectionListener(){
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//             String data=null;
//             int a[]=rtable.table.getSelectedRows();
//             int b[]=rtable.table.getSelectedColumns();
//            for(int i=0;i<a.length;i++){
//                for(int j=0;j<b.length;j++){
//                    data=(String)rtable.table.getValueAt(a[i], b[j]);
//            }
//            }
//            
//            
//            }
//      
//      });
        
      
      
     
      
        c.add(rtable);
      // c.add(tx);
       
       
       //menu
       menubar=new JMenuBar();
       filemenu=new JMenu("File");
       filemenu1=new JMenu("Tool");
       
       
       newMenuitem=new JMenuItem("Open");
       
       newMenuitem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            
             open.init();
                
            }   
       
           
       
       });
       
       
      newMenuitem1=new JMenuItem("Save");
      newMenuitem1.setEnabled(false);
      newMenuitem1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                save.init();
            }
      
      
      });
      
       newMenuitem2=new JMenuItem("SaveAs");
       
       newMenuitem2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            
               saveas.init();
                
            }   
       
           
       
       });
       
       
       newMenuitem3=new JMenuItem("Exit");
       
       newMenuitem3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                
            }
       
       
       });
       newMenuitem4=new JMenuItem("FormulaBar(Column wise)");
       newMenuitem5=new JMenuItem("Sum(Column wise)");
       
       newMenuitem5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             sum.setVisible(true);
               fbarpanel.setVisible(false);
               fbarpanelInd.setVisible(false);
               spread.setVisible(false);
               but1.setVisible(false);
               but2.setVisible(false);
               but3.setVisible(false);
               mcarlo.setVisible(false);
               
               
            }
         
       
       });
       
        newMenuitem6=new JMenuItem("FormulaBar(Individually)"); 
        newMenuitem6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fbarpanelInd.setVisible(true);
                 sum.setVisible(false);
               fbarpanel.setVisible(false);
               spread.setVisible(false);
                but1.setVisible(false);
               but2.setVisible(false);
               but3.setVisible(false);
               mcarlo.setVisible(false);
                
            }
        
            
        
        });
       newMenuitem7=new JMenuItem("Spread"); 
       
       newMenuitem7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fbarpanel.setVisible(false);
                sum.setVisible(false);
                fbarpanelInd.setVisible(false);
                spread.setVisible(true);
                 but1.setVisible(false);
               but2.setVisible(false);
               but3.setVisible(false);
               mcarlo.setVisible(false);
                
            }
       
       
       });
       
       
        newMenuitem8=new JMenuItem("Clear Table"); 
       
        newMenuitem8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                for(int i=0;i<100;i++){
                    for(int j=0;j<26;j++){
                        rtable.table.setValueAt("", i,j );
                    }
                }
            }
            
        });
        
        
        newMenuitem9=new JMenuItem("Main menu"); 
        newMenuitem9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fbarpanelInd.setVisible(false);
                 sum.setVisible(false);
               fbarpanel.setVisible(false);
               spread.setVisible(false);
                but1.setVisible(true);
               but2.setVisible(true);
               but3.setVisible(true);
               mcarlo.setVisible(false);
                
            }
        
        });
        
         newMenuitem10=new JMenuItem("MonteCarlo"); 
        newMenuitem10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fbarpanelInd.setVisible(false);
                 sum.setVisible(false);
               fbarpanel.setVisible(false);
               spread.setVisible(false);
                but1.setVisible(false);
               but2.setVisible(false);
               but3.setVisible(false);
               mcarlo.setVisible(true);
                
            }
        
        });
        
        
       filemenu.add(newMenuitem);
       filemenu.add(newMenuitem1);
       filemenu.add(newMenuitem2);
       filemenu.add(newMenuitem3);
       filemenu1.add(newMenuitem4);
         filemenu1.add(newMenuitem5);
         filemenu1.add(newMenuitem6);
          filemenu1.add(newMenuitem7);
           filemenu1.add(newMenuitem8);
           filemenu1.add(newMenuitem9);
            filemenu1.add(newMenuitem10);
       
       menubar.add(filemenu);
       menubar.add(filemenu1);
       
       
       
       
       this.setJMenuBar(menubar);
       /////
      fbarpanel=new FormulaBarPanel(this);
       
      newMenuitem4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 fbarpanel.setVisible(true);
                sum.setVisible(false);
                fbarpanelInd.setVisible(false);
                spread.setVisible(false);
                 but1.setVisible(false);
               but2.setVisible(false);
               but3.setVisible(false);
            }
        
        
        
        });
      
      
      
       c.add(fbarpanel);
       
       fbarpanelInd=new FormulaBarIndividualPanel(this);
       
       
       c.add(mcarlo);
       
       c.add(fbarpanelInd);
       c.add(spread);
       c.add(sum);
       
       icon1=new ImageIcon(getClass().getResource("open.png"));
       icon2=new ImageIcon(getClass().getResource("save.png"));
        icon3=new ImageIcon(getClass().getResource("save_as.png"));
       
       but1=new JButton(icon1);
       but1.setBounds(10, 10, 60, 60);
       but1.setBackground(new Color(195,195,195));
       but1.setBorder(null);
      but1.setVisible(true);
      but1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                open.init();
                
            }
      
      
      });
       c.add(but1);
       
        but2=new JButton(icon2);
        but2.setEnabled(false);
       but2.setBounds(80, 10, 60, 60);
        but2.setBackground(new Color(195,195,195));
       but2.setBorder(null);
        but2.setVisible(true);
         but2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                save.init();
                
            }
      
      
      });
       c.add(but2);
       
         but3=new JButton(icon3);
       but3.setBounds(150, 10, 60, 60);
       
       but3.setBackground(new Color(195,195,195));
       but3.setBorder(null);
        but3.setVisible(true);
         but3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                saveas.init();
                
            }
      
      
      });
        
       c.add(but3);
       
//        but4=new JButton();
//       but4.setBounds(220, 10, 60, 60);
//       c.add(but4);
       
       
        this.setTitle("EasyBiz");
      
       this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
     
      // this.setBounds(20, 20, 750, 630);
      this.setLocation(20, 20);
       this.setPreferredSize(new Dimension(750, 630));
       //this.setSize( 750, 630);
       this.pack();
       this.setVisible(true);
        this.setResizable(false);
    }
    public RowHeader getRowHeader(){
        return rtable;
    }
    public JMenuItem getnewMenuitem1(){
        return newMenuitem1;
    }
    public JButton getBut2(){
        return but2;
    }
}


