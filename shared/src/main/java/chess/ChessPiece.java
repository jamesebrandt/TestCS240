package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private Collection<ChessMove> moves = new ArrayList<>();
    private final ChessGame.TeamColor teamColor = getTeamColor();
    private final PieceType pieceType = getPieceType();


    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.moves = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece piece = (ChessPiece) o;
        return Objects.equals(moves, piece.moves) && teamColor == piece.teamColor && pieceType == piece.pieceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moves, teamColor, pieceType);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "moves=" + moves +
                ", teamColor=" + teamColor +
                ", pieceType=" + pieceType +
                '}';
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return teamColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return pieceType;
    }

    private void AddMove(ChessPosition end, PieceType pieceType) {
  //      moves.add(new ChessMove(, end, pieceType));
    }
    private void AddMove(ChessPosition end) {
        AddMove(end, null);
    }


    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        switch (pieceType) {
            case KING:
                AddMove(new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1));
                AddMove(new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()-1));
                AddMove(new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()));
                AddMove(new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()+1));
                AddMove(new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()-1));
                AddMove(new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()));
                AddMove(new ChessPosition(myPosition.getRow(), myPosition.getColumn()+1));
                AddMove(new ChessPosition(myPosition.getRow(), myPosition.getColumn()-1));

                break;
            case QUEEN:

                break;
            case BISHOP:

                break;
            case KNIGHT:

                break;
            case ROOK:

                break;
            case PAWN:

                break;

            }
        return moves;
    }
}
