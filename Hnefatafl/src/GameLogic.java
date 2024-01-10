import java.util.ArrayList;

public class GameLogic implements PlayableLogic {

    private ConcretePiece[][] board;
    private final int boardSize = 11;
    private ConcretePlayer player1;
    private ConcretePlayer player2;
    private boolean isPlayar1turn = true;
    private final ConcretePiece[] ConcretePieceArr;
    private Position kingPosition;

    public GameLogic(){
        board = new ConcretePiece[11][11];
        ConcretePieceArr = new ConcretePiece[37];
        player1 = new ConcretePlayer(true);
        player2 = new ConcretePlayer(false);
        isPlayar1turn = false;
        player1Pieces();
        player2Pieces();
    }

    private void player1Pieces(){
        King king1 = new King(player1,"♔",7);
        ConcretePieceArr[6] = king1;
        for (int i = 0; i < 13; i++) {
            if(i == 6 )continue;
            ConcretePieceArr[i] = new Pawn(player1,"♙",i+1); {
            }
        }
        board[3][5] = ConcretePieceArr[0];
        ConcretePieceArr[0].addMove(new Position(5,3));
        System.out.println("Pawn number "+board[3][5].getNumber()+ " created");
        board[4][4] = ConcretePieceArr[1];
        ConcretePieceArr[1].addMove(new Position(4,4));
        board[4][5] = ConcretePieceArr[2];
        ConcretePieceArr[2].addMove(new Position(5,4));
        board[4][6] = ConcretePieceArr[3];
        ConcretePieceArr[3].addMove(new Position(6,4));
        board[5][3] = ConcretePieceArr[4];
        ConcretePieceArr[4].addMove(new Position(3,5));
        board[5][4] = ConcretePieceArr[5];
        ConcretePieceArr[5].addMove(new Position(4,5));
        board[5][5] = ConcretePieceArr[6];
        ConcretePieceArr[6].addMove(new Position(5,5));
        board[5][6] = ConcretePieceArr[7];
        ConcretePieceArr[7].addMove(new Position(6,5));
        board[5][7] = ConcretePieceArr[8];
        ConcretePieceArr[8].addMove(new Position(7,5));
        board[6][4] = ConcretePieceArr[9];
        ConcretePieceArr[9].addMove(new Position(4,6));
        board[6][5] = ConcretePieceArr[10];
        ConcretePieceArr[10].addMove(new Position(5,6));
        board[6][6] = ConcretePieceArr[11];
        ConcretePieceArr[11].addMove(new Position(6,6));
        board[7][5] = ConcretePieceArr[12];
        ConcretePieceArr[12].addMove(new Position(5,7));
        System.out.println("Pawn number "+board[7][5].getNumber()+ " created");
    }

    private void player2Pieces(){
        for (int i = 13; i < 37; i++) {
            ConcretePieceArr[i] = new Pawn(player2, "♟", i + 1);
        }
        board[0][3] = ConcretePieceArr[13];
        ConcretePieceArr[13].addMove(new Position(3,0));
        System.out.println("Pawn number "+board[0][3].getNumber()+ " created");
        board[0][4] = ConcretePieceArr[14];
        ConcretePieceArr[14].addMove(new Position(4,0));
        board[0][5] = ConcretePieceArr[15];
        ConcretePieceArr[15].addMove(new Position(5,0));
        board[0][6] = ConcretePieceArr[16];
        ConcretePieceArr[16].addMove(new Position(6,0));
        board[0][7] = ConcretePieceArr[17];
        ConcretePieceArr[17].addMove(new Position(7,0));
        board[1][5] = ConcretePieceArr[18];
        ConcretePieceArr[18].addMove(new Position(5,1));
        board[3][0] = ConcretePieceArr[19];
        ConcretePieceArr[19].addMove(new Position(0,3));
        board[3][10] = ConcretePieceArr[20];
        ConcretePieceArr[20].addMove(new Position(10,3));
        board[4][0] = ConcretePieceArr[21];
        ConcretePieceArr[21].addMove(new Position(0,4));
        board[4][10] = ConcretePieceArr[22];
        ConcretePieceArr[22].addMove(new Position(10,4));
        board[5][0] = ConcretePieceArr[23];
        ConcretePieceArr[23].addMove(new Position(0,5));
        board[5][1] = ConcretePieceArr[24];
        ConcretePieceArr[24].addMove(new Position(1,5));
        board[5][9] = ConcretePieceArr[25];
        ConcretePieceArr[25].addMove(new Position(9,5));
        board[5][10] = ConcretePieceArr[26];
        ConcretePieceArr[26].addMove(new Position(10,5));
        board[6][0] = ConcretePieceArr[27];
        ConcretePieceArr[27].addMove(new Position(0,6));
        board[6][10] = ConcretePieceArr[28];
        ConcretePieceArr[28].addMove(new Position(10,6));
        board[7][0] = ConcretePieceArr[29];
        ConcretePieceArr[29].addMove(new Position(0,7));
        board[7][10] = ConcretePieceArr[30];
        ConcretePieceArr[30].addMove(new Position(10,7));
        board[9][5] = ConcretePieceArr[31];
        ConcretePieceArr[31].addMove(new Position(5,9));
        board[10][3] = ConcretePieceArr[32];
        ConcretePieceArr[32].addMove(new Position(3,10));
        board[10][4] = ConcretePieceArr[33];
        ConcretePieceArr[33].addMove(new Position(4,10));
        board[10][5] = ConcretePieceArr[34];
        ConcretePieceArr[34].addMove(new Position(5,10));
        board[10][6] = ConcretePieceArr[35];
        ConcretePieceArr[35].addMove(new Position(6,10));
        board[10][7] = ConcretePieceArr[36];
        ConcretePieceArr[36].addMove(new Position(7,10));
        System.out.println("Pawn number "+board[10][7].getNumber()+ " created");
    }

    @Override
    public boolean move(Position a, Position b) {
        if(b.getY() != a.getY() && b.getX() != a.getX()) return false;
        if(board[b.getY()][b.getX()] == null && board[a.getY()][a.getX()] != null){
            board[b.getY()][b.getX()] = board[a.getY()][a.getX()];
            board[a.getY()][a.getX()] = null;
        }
        return true;
    }

    @Override
    public Piece getPieceAtPosition(Position position) {
        return board[position.getY()][position.getX()];
    }

    @Override
    public Player getFirstPlayer() {
        return player1;
    }

    @Override
    public Player getSecondPlayer() {
        return player2;
    }

    @Override
    public boolean isGameFinished() {
        return false;
    }

    @Override
    public boolean isSecondPlayerTurn() {
        return !isPlayar1turn;
    }

    @Override
    public void reset() {
    }

    @Override
    public void undoLastMove() {
    }

    @Override
    public int getBoardSize() {

        return boardSize;
    }
}
