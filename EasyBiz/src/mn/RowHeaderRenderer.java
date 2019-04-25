package githubNahid244;

import java.awt.Color;
import java.awt.Component;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
//import static javax.swing.SwingConstants.CENTER;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

class RowHeaderRenderer extends JLabel implements ListCellRenderer{

    RowHeaderRenderer(JTable table){
        JTableHeader header=table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("tableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(header.getForeground());
        setBackground(Color.GREEN);
        setFont(header.getFont());
        
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
     setText(value==null  ?"":value.toString());
     return this;
        
    }
    
}
 class RowHeader extends JPanel {
    JTable table;
    
    public RowHeader(){
        
        this.setBounds(10,100, 720, 470);
        ListModel lm=new AbstractListModel(){
            String headers[]={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100"};
            @Override
            public int getSize() {
                return headers.length;
            }

            @Override
            public Object getElementAt(int index) {
             return headers[index];   
            }
            
        };
        
        DefaultTableModel dm=new DefaultTableModel(lm.getSize(),26);
        table=new JTable(dm);
       
        table.setCellSelectionEnabled(true);
       table.getTableHeader().setBackground(Color.YELLOW);
        
        JList rowHeader=new JList(lm);
        rowHeader.setFixedCellWidth(40);
        
        rowHeader.setFixedCellHeight(table.getRowHeight());
        rowHeader.setCellRenderer(new RowHeaderRenderer(table));
       
        JScrollPane pane=new JScrollPane(table);
        pane.setRowHeaderView(rowHeader);
        pane.setBounds(0, 0, 720, 460);
        this.add(pane);
        this.setLayout(null);
         table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
}


