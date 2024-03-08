package com.example.chess.model;



public class Bishop extends Piece {
    public Bishop(boolean white){
        super(white);

    }
    //move diagonally
    public boolean canMove(Board board, Cell startBlock, Cell endBlock) {

        int newRow = endBlock.getX();
        int newCol = endBlock.getY();
        int currentRow =startBlock.getX();
        int currentCol = startBlock.getY();

        if (newRow < 0 || newRow >= 8 || newCol < 0 || newCol >= 8) {
            return false;
        }
        return (Math.abs(newRow - currentRow) == Math.abs(newCol - currentCol));
    }
}
