package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.EventObject;

public class MyPanel extends JPanel implements TableCellRenderer, TableCellEditor {
    public MyPanel() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(gbl);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int cellVariable = (int) value;
        if ((row + column) % 2 == 0) {

            if (cellVariable == 0) {
                this.setBackground(new Color(170, 150, 218, 242));
                this.setBorder(new LineBorder(new Color(190, 170, 238), 0));

            } else if (cellVariable == 1) {
                this.setBackground(new Color(250, 0, 142));
                this.setBorder(new LineBorder(new Color(190, 170, 238), 1));

            } else if (cellVariable == 2) {
                this.setBackground(new Color(120, 100, 168));
                this.setBorder(new LineBorder(new Color(190, 170, 238), 1));

            } else if (cellVariable == 3) {
                this.setBackground(new Color(255, 255, 210));
                this.setBorder(new LineBorder(new Color(190, 170, 238), 1));
            }
        } else{
            if (cellVariable == 0) {
                this.setBackground(new Color(170, 150, 218, 205));
                this.setBorder(new LineBorder(new Color(190, 170, 238, 205), 3));

            } else if (cellVariable == 1) {
                this.setBackground(new Color(250, 0, 142));
                this.setBorder(new LineBorder(new Color(190, 170, 238, 203), 1));

            } else if (cellVariable == 2) {
                this.setBackground(new Color(120, 100, 168));
                this.setBorder(new LineBorder(new Color(190, 170, 238, 203), 1));

            } else if (cellVariable == 3) {
                this.setBackground(new Color(255, 255, 210));
                this.setBorder(new LineBorder(new Color(190, 170, 238, 203), 1));
            }
        }
        return this;
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return null;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return false;
    }

    @Override
    public boolean stopCellEditing() {
        return false;
    }

    @Override
    public void cancelCellEditing() {

    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {

    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {

    }
}