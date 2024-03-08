package com.example.chess.model;

public class Move {
    private Cell startCell;
    private Cell endCell;

    public Move(Cell startCell, Cell endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public Cell getStartCell() {
        return startCell;
    }

    public void setStartCell(Cell startCell) {
        this.startCell = startCell;
    }

    public Cell getEndCell() {
        return endCell;
    }

    public void setEndCell(Cell endCell) {
        this.endCell = endCell;
    }

    public boolean isValid() {
        if (this.endCell.getPiece() == null)
            return true;
        else return this.startCell.getPiece().isWhite() != this.endCell.getPiece().isWhite();
    }
}

