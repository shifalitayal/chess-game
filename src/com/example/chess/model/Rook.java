package com.example.chess.model;

public class Rook extends Piece {
    public Rook(boolean white){
        super(white);

    }
    public boolean canMove(Board board, Cell startBlock, Cell endBlock) {
        int newRow = endBlock.getX();
        int newCol = endBlock.getY();
        int currentRow =startBlock.getX();
        int currentCol = startBlock.getY();

        if (newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            return false;
        }

        //horizontall movement(haathi)
        if(newRow == currentRow && newCol!=currentCol)
            return true;

        //vertical movement
        if(newRow != currentRow && newCol==currentCol)
            return true;

        return false;
    }
}
