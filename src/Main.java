import com.example.chess.model.*;
import com.example.chess.enums.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Board board;
    private ArrayList<Player> players;
    boolean isWhiteTurn;
    private Status status;

    private ArrayList<Object[]> logs;

    Main(){
        this.board = new Board();
        this.players=new ArrayList<>();
        players.add(new Player(1,"white","Shifali"));
        players.add(new Player(2,"black","Nikhil"));
        this.isWhiteTurn=true;
        this.status=Status.ACTIVE;
        this.logs = new ArrayList<>();

    }
    public void startGame() throws Exception {
       
        while(this.status==Status.ACTIVE){

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a Piece start position x : ");
            int x=sc.nextInt();
            System.out.println("Enter a Piece start position y : ");
            int y=sc.nextInt();
            System.out.println("Enter a Piece end position x1 : ");
            int x1=sc.nextInt();
            System.out.println("Enter a Piece end position y1 : ");
            int y1=sc.nextInt();
            Cell startCell = this.board.getBox(x,y);
            Cell endCell = this.board.getBox(x1,y1);
            if(isWhiteTurn){
                makeMove(new Move(startCell,endCell),players.get(0));

            }
            else
                makeMove(new Move(startCell,endCell),players.get(1));
        }
    }
    public void makeMove(Move move, Player player) throws Exception {

        System.out.println("current player "+player);
        //if end block piece is not of same color as we can't cut same color piece
        if(move.isValid()){
            Piece sourcePiece = move.getStartCell().getPiece();
            System.out.println("Piece chosen for making move : "+sourcePiece);
            if(sourcePiece.canMove(this.board,move.getStartCell(),move.getEndCell())){
                Piece destinationPiece = move.getEndCell().getPiece();

                if(destinationPiece!=null){
                    if(destinationPiece instanceof King  && isWhiteTurn) {
                        System.out.println("King killed by White "+sourcePiece.getClassName() + " so White WINS!!");
                        this.status = Status.WHITE_WIN;
                        return;
                    }
                    if(destinationPiece instanceof King && !isWhiteTurn){
                        System.out.println("King killed by Black "+sourcePiece.getClassName() + " so Black WINS!!");
                        this.status = Status.BLACK_WIN;
                        return;
                    }
                    destinationPiece.setKilled(true);
                }
                Object[] object = new Object[2];
                object[0]=sourcePiece;
                object[1]=move;
                logs.add(object);
                move.getEndCell().setPiece(sourcePiece);
                move.getStartCell().setPiece(null);
                //checking for checkmate of king.  if checkmate then give check to opponent
                if(checkMate(move, sourcePiece,isWhiteTurn,this.board))
                {
                    if(isWhiteTurn)
                        System.out.println("CHECKMATE!! SAVE YOUR BLACK KING");
                    else
                        System.out.println("CHECKMATE!! SAVE YOUR WHITE KING");
                }
                isWhiteTurn= !isWhiteTurn;

                for(int i=0 ;i<logs.size() ;i++)
                {
                    String str= ((Piece)logs.get(i)[0]).isWhite() ? "white" : "black";
                    System.out.println(((Piece) logs.get(i)[0]).getClassName() + " - " + str  + " " +((Move)logs.get(i)[1]).getEndCell().getX() + " " +((Move)logs.get(i)[1]).getEndCell().getY());
                }
            }
        }
        else System.out.println("Destination cell has same color piece so  invalid move");

    }
    public boolean checkMate(Move move, Piece sourcePiece, boolean isWhiteTurn, Board board) throws Exception {
        int finalPosOfSourcePiece_x = move.getEndCell().getX();
        int finalPosOfSourcePiece_y=move.getEndCell().getY();
        Cell startCell = this.board.getBox(finalPosOfSourcePiece_x,finalPosOfSourcePiece_y);
        //will give checkmate to black opponent for black king
        Cell endCell =new Cell();
        if(isWhiteTurn)
        {
            //get current position for black king

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(board.getBox(i,j).getPiece() instanceof King && !board.getBox(i,j).getPiece().isWhite()){
                        endCell = this.board.getBox(i,j);
                        break;
                    }
                }
            }
        }
        else{
            //get current position for white king as checkmate given by black piece
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(board.getBox(i,j).getPiece() instanceof King && board.getBox(i,j).getPiece().isWhite()){
                        endCell = this.board.getBox(i,j);
                        break;
                    }
                }
            }

        }
        if(sourcePiece.canMove(this.board,startCell,endCell))
            return true;

        return false;
    }
    public static void main(String[] args) throws Exception {
        Main chess = new Main();
        chess.startGame();
    }

}