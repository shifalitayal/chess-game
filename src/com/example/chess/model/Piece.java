package com.example.chess.model;

public abstract class Piece {
    private boolean isWhite = false;
    private boolean isKilled = false;

    private String className;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
        this.className = this.getClass().getName();
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public abstract boolean canMove(Board board,Cell startBlock, Cell endBlock);

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "isWhite=" + isWhite +
                ", isKilled=" + isKilled +
                ", className='" + className + '\'' +
                '}';
    }
}
