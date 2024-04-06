/**
 * This class implements the game we all love to
 * not play.
 *
 * @author (M Rasamny)
 * @version (03 / 13 / 2018)
 */
public class TicTacToe {
    // instance variables
    private GamePiece[][] board;
    private GamePiece[] player;
    private int nextPlayerIndex;
    private int numOfMoves;

    public TicTacToe(GamePiece p1, GamePiece p2) {
        board = new GamePiece[3][3];
        clear();
        player = new GamePiece[2];
        player[0] = new GamePiece(p1);
        player[1] = new GamePiece(p2);
        nextPlayerIndex = 0;
        numOfMoves = 0;
    }


    /**
     * Returns true if the location is an integer that represents one of the squares on the board ; false otherwise
     *
     * @param location the integer representation of the square.
     * @return true if the location is an integer that represents one of the squares on the board ; false otherwise
     */
    public boolean isValid(int location) {
        // TODO: add code here
        return location < 9 && location >= 0;
    }

    /**
     * Returns true if the location is NOT occupied by a game piece; false otherwise
     *
     * @param location the integer representation of the square.
     * @return true if the location is NOT occupied by a game piece; false otherwise
     */
    public boolean isEmpty(int location) {
        // TODO: add code here
        if (isValid(location)) {
            if (board[location / board[0].length][location % board[0].length] == null) {
                return true;
            }
        }return false;
    }

    /**
     * Returns the number of moves remaining on the board
     *
     * @return the number of moves remaining on the board
     */
    public int movesRemaining() {
        // TODO: add code here
        int moves = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    moves ++;
                }
            }
        }
        return moves;
    }

    /**
     * Returns the game piece at the provided location
     *
     * @param location the integer representation of the square
     * @return the game piece at the provided location
     */
    public GamePiece getPiece(int location) {
        // TODO: add code here
        if (isValid(location)){
            return new GamePiece(board[location / board[0].length][location % board[0].length]);
        }
        return null;
    }

    /**
     * Returns the winner's GamePiece or null if there is no winner at the time the method is invoked
     *
     * @return the winner's GamePiece or null if there is no winner at the time the method is invoked
     */
    public GamePiece getWinner() {
        GamePiece winner = null;
        boolean win = true;
        int index;
        int[][] combos = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // horizontal winning combinations
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // vertical winning combinations
                {0, 4, 8}, {2, 4, 6}             // diagonal winning combinations
        };

        // TODO: add code here
        for (int i = 0; i < combos.length; i++){
            if(winner != null){
                break;
            }
            for(int m = 0; m < combos[i].length; m++){
                index = combos[i][m];
                if (board[index / board[0].length] [index % board[0].length] == null){
                    winner = null;
                    break;
                }
                if(m == 0){
                    winner = board[index / board[0].length] [index % board[0].length];
                }
                else if(!(board[index / board[0].length][index % board[0].length].equals(winner))){
                winner = null;
                break;
                }
            }

        }

        return winner;
    }

    /**
     * Indicates the current player by returning the current player's game piece
     * @return the current player's game piece.
     */
    public GamePiece getCurrentPlayer() {
        return new GamePiece(player[nextPlayerIndex]);
    }

    /**
     * Places a game piece at the provided location if and only if the location is valid and is empty.  Returns
     * true if the operation is successful; false otherwise
     * @param location the integer representation of the square.
     * @return true if it is able to place a game piece at the specified location; false otherwise
     */
    public boolean add(int location) {
        if (isValid(location) && isEmpty(location)) {
            board[location / board.length][location % board.length] = player[nextPlayerIndex];
            nextPlayerIndex = nextPlayerIndex > 0 ? 0 : 1;
            numOfMoves++;
            return true;
        }
        return false;
    }

    /**
     * Clears the board of all game pieces
     */
    public void clear() {
        // set all elements of 2d array to null
        // TODO: add code here
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = null;
            }
        }
    }

    /**
     * Returns a string representation of the board
     * @return a string representation of the board
     */
    @Override
    public String toString() {
        String s = "";
        // TODO: add code here
        return s;
    }
}