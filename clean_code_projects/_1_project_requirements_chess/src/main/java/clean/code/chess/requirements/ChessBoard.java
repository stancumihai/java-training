package clean.code.chess.requirements;

import clean.code.chess.requirements.Piece;
import clean.code.chess.requirements.PieceColor;
import clean.code.chess.requirements.Position;


import java.util.HashMap;
import java.util.Map;

public class ChessBoard {

    public static final int MAX_BOARD_WIDTH = 7;
    public static final int MAX_BOARD_HEIGHT = 7;

    private final Map<Position, Piece> mapOfPositionAndPiece;
    private final Map<Piece, Position> mapOfPieceAndPosition;
    private final ChessBoardValidator chessBoardValidator;

    public ChessBoard() {
        this.mapOfPieceAndPosition = new HashMap<>(MAX_BOARD_WIDTH * MAX_BOARD_HEIGHT);
        this.mapOfPositionAndPiece = new HashMap<>(MAX_BOARD_WIDTH * MAX_BOARD_HEIGHT);
        this.chessBoardValidator = new ChessBoardValidator();
    }

    public void add(Piece piece, int xCoordinate, int yCoordinate) {
        if (chessBoardValidator.isValidPieceRow(xCoordinate, piece.getColor())) {
            piece.setPieceOnChessBoard(this, xCoordinate, yCoordinate);
        }
    }

    public void updatePiecePositionOnChessBoard(Piece piece, int xCoordinate, int yCoordinate) {
        Position newPosition = getNewPiecePosition(xCoordinate, yCoordinate);
        this.mapOfPieceAndPosition.put(piece, newPosition);
        this.mapOfPositionAndPiece.put(newPosition, piece);
    }

    private Position getNewPiecePosition(int xCoordinate, int yCoordinate) {
        if (this.isLegalBoardPosition(xCoordinate, yCoordinate)) {
            return new Position(xCoordinate, yCoordinate);
        } else {
            return new Position(-1, -1);
        }
    }

    public Position getPosition(Piece piece) {
        return this.mapOfPieceAndPosition.get(piece);
    }

    public Piece getPiece(Position position) {
        return this.mapOfPositionAndPiece.get(position);
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return chessBoardValidator.isValidCoordinates(xCoordinate, yCoordinate) && chessBoardValidator.isFreePosition(xCoordinate, yCoordinate);
    }

    public void add(Pawn pawn, int i, int i1, PieceColor black) {
    }

    private class ChessBoardValidator {

        public boolean isFreePosition(int xCoordinate, int yCoordinate) {
            return getPiece(new Position(xCoordinate, yCoordinate)) == null;
        }

        public boolean isValidCoordinates(int xCoordinate, int yCoordinate) {
            return this.isInsideTheTable(xCoordinate, MAX_BOARD_WIDTH) && this.isInsideTheTable(yCoordinate, MAX_BOARD_HEIGHT);
        }

        public boolean isInsideTheTable(int coordinate, int tableLimit) {
            return 0 <= coordinate && coordinate < tableLimit;
        }

        public boolean isValidPieceRow(int xCoordinate, PieceColor color) {
            if (color == PieceColor.WHITE) {
                return xCoordinate == 0 || xCoordinate == 1;
            }
            return xCoordinate == MAX_BOARD_HEIGHT - 1 || xCoordinate == MAX_BOARD_HEIGHT;
        }
    }
}
