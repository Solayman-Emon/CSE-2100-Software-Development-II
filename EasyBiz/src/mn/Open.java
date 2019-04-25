package githubNahid244;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Open extends JFrame{
    private Mxcel mxcel;
   
    public Open(Mxcel mxcel){
        //init();
        this.mxcel=mxcel;
    }
    public void init(){
         JFileChooser file=new JFileChooser();
        file.setDialogTitle("Open");
       
       file.setFileFilter(new FileNameExtensionFilter("*.biz","biz"));
       
    
        int c=file.showOpenDialog(this);
        
//         String s=file.getSelectedFile().getAbsolutePath();
//        Cons.file=s;
       
        if(c==JFileChooser.APPROVE_OPTION){
            mxcel.getnewMenuitem1().setEnabled(true);
            mxcel.getBut2().setEnabled(true);
            String s=file.getSelectedFile().getAbsolutePath();
        Cons.file=s;
           // String s=file.getSelectedFile().getAbsolutePath();
            
            try{
                FileInputStream savefile=new  FileInputStream(s);
                
                ObjectInputStream biz=new ObjectInputStream(savefile);
                
               for(int i=0;i<101;i++){
                   for(int j=0;j<26;j++){
                       //System.out.println(biz.readObject());
                       mxcel.getRowHeader().table.setValueAt(biz.readObject(), i, j);
                  }
               }
                
                biz.close();
                
            }catch(Exception e){
                
            }
               
            
        }
        else  if(JFileChooser.CANCEL_OPTION==c){
             System.out.println("");
         }
        file.setVisible(true);
      
    }
}


