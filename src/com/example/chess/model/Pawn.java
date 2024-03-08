package com.example.chess.model;

public class Pawn extends Piece {
    public Pawn(boolean white){
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
        // The pawn moves forward one square, but can also capture diagonally one square
        int dx = Math.abs(newRow - currentRow);
        int dy = newCol - currentCol;
        return (dx == 1 && dy == 0) || (dx == 1 && dy == 1);
    }


}
