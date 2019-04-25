package githubNahid244;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class SaveAs extends JFrame {
    private Mxcel mxcel;
    public SaveAs(Mxcel mxcel){
        //init();
        this.mxcel=mxcel;
    }
   public void init(){
       JFileChooser file=new JFileChooser();
        file.setDialogTitle("SaveAs");
       
        
        
       file.setFileFilter(new FileNameExtensionFilter("*.biz","biz"));
        int c=file.showSaveDialog(this);
        File fl;
       
         
       
       
        
       
        if(c==JFileChooser.APPROVE_OPTION){
           String s=file.getSelectedFile().getAbsolutePath()+".biz";
           fl=new File(s);
           if(!fl.exists()){
           // String s=file.getSelectedFile().getAbsolutePath()+".biz";
          
            try{
                
                FileOutputStream savefile=new FileOutputStream(s);
                
                ObjectOutputStream biz=new  ObjectOutputStream(savefile);
               
                for(int i=0;i<101;i++){
                    for(int j=0;j<26;j++){
                        biz.writeObject(mxcel.getRowHeader().table.getValueAt(i, j));
                    }
                        
                }
                
                
                biz.close();
                
            }
            catch(Exception e){
                
            }
            
            
           }
           else{
               JOptionPane.showMessageDialog(this, "file already exist");
           }  
        }
        
        file.setVisible(true);
       
   } 
}


