package Model;

import Controller.*;
import Helpers.SavingLoading;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Board extends AbstractTableModel implements Observer{
    private final int[][] board;
    EventStarterToGraphic eventStarterToGraphic;
    public Board(EventStarterToGraphic eventStarterToGraphic){
        board = new int[25][16];
        this.eventStarterToGraphic = eventStarterToGraphic;
    }
    public int[][] getBoard(){
        return board;
    }
    public void setPieceAtPosition(int x, int y, int value){
        board[x][y] = value;
    }

    @Override
    public int getRowCount() {
        return this.board.length;
    }

    @Override
    public int getColumnCount() {
        return this.board[1].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.board[rowIndex][columnIndex];
    }


    @Override
    public void foodConsumption(FoodConsumptionEvent event) {
        eventStarterToGraphic.fireUpdateScorePanel();
    }

    @Override
    public void ownCollision(OwnCollisionEvent event) {
        System.out.println("collision own data");
        eventStarterToGraphic.fireAddPanel();
    }

    @Override
    public void wallCollision(WallCollisionEvent event) {
        System.out.println("collision wall data");
        eventStarterToGraphic.fireAddPanel();
    }
    @Override
    public void updateBoard(UpdateEvent event){
        fireTableDataChanged();
    }
}
// TODO: 15.06.2023 add events(fire) to implement appearance of listPlayer panel, and to update score panel when food consumed