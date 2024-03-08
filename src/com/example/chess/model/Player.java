package com.example.chess.model;

public class Player {

    private int id;
    private String pieceColor;
    private String name;

    public Player(int id, String pieceColor, String name) {
        this.id = id;
        this.pieceColor = pieceColor;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(String pieceColor) {
        this.pieceColor = pieceColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", pieceColor='" + pieceColor + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
