package githubNahid244;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Save {
    
    private Mxcel mxcel;
    
    public Save(Mxcel mxcel){
        this.mxcel=mxcel;
    }
    public void init(){
        
         try{
                
                FileOutputStream savefile=new FileOutputStream(Cons.file);
                
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
}


