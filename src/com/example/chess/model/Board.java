package com.example.chess.model;

public class Board {

    private Cell[][] box;

    public Board() {

        box = new Cell[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Setting White Pieces
        box[0][0] = new Cell(0, 0, new Rook(true));
        box[0][1] = new Cell(0, 1, new Knight(true));
        box[0][2] = new Cell(0, 2, new Bishop(true));
        box[0][3] = new Cell(0, 3, new Queen(true));
        box[0][4] = new Cell(0, 4, new King(true));
        box[0][5] = new Cell(0, 5, new Bishop(true));
        box[0][6] = new Cell(0, 6, new Knight(true));
        box[0][7] = new Cell(0, 7, new Rook(true));
        for (int j = 0; j < 8; j++) {
            box[1][j] = new Cell(1, j, new Pawn(true));
        }
        //Setting Black Pieces
        box[7][0] = new Cell(7, 0, new Rook(false));
        box[7][1] = new Cell(7, 1, new Knight(false));
        box[7][2] = new Cell(7, 2, new Bishop(false));
        box[7][3] = new Cell(7, 3, new Queen(false));
        box[7][4] = new Cell(7, 4, new King(false));
        box[7][5] = new Cell(7, 5, new Bishop(false));
        box[7][6] = new Cell(7, 6, new Knight(false));
        box[7][7] = new Cell(7, 7, new Rook(false));
        for (int j = 0; j < 8; j++) {
            box[6][j] = new Cell(6, j, new Pawn(false));
        }
        // Defining rest of the box having no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                box[i][j] = new Cell(i, j, null);
            }
        }
    }

    public Cell getBox(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }

        return box[x][y];
    }

}
