package com.example.chess.model;


public class King extends Piece {
    public King(boolean white){
        super(white);

    }
    public boolean canMove(Board board, Cell startBlock, Cell endBlock) {

        //king can move one square horizontaly, vertically, diagonally
        int newRow = endBlock.getX();
        int newCol = endBlock.getY();
        int currentRow =startBlock.getX();
        int currentCol = startBlock.getY();

        if (newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            return false;
        }

        int dx = Math.abs(newRow - currentRow);
        int dy = Math.abs(newCol - currentCol);
        return (dx <= 1 && dy <= 1);
    }
}
