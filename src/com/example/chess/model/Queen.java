package com.example.chess.model;

public class Queen extends Piece {
    public Queen(boolean white){
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
        // The queen can move diagonally, horizontally, or vertically any number of squares
        return (newRow == currentRow || newCol == currentCol || Math.abs(newRow- currentRow) == Math.abs(newCol - currentCol));
    }
}
