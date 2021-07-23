package clean.code.chess.requirements;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {

    private ChessBoard chessBoard;
    private Pawn testSubject;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.testSubject = new Pawn(PieceColor.BLACK);
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() {
        this.chessBoard.add(testSubject, 6, 3, PieceColor.BLACK);
        assertEquals(0, testSubject.getXCoordinate());
    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() {
        this.chessBoard.add(testSubject, 6, 3, PieceColor.BLACK);
        assertEquals(0, testSubject.getYCoordinate());
    }


    @Test
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.add(testSubject, 6, 3, PieceColor.BLACK);
//        testSubject.Move(MovementType.MOVE, 7, 3);
        assertEquals(0, testSubject.getXCoordinate());
        assertEquals(0, testSubject.getYCoordinate());
    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.add(testSubject, 6, 3, PieceColor.BLACK);
//        testSubject.Move(MovementType.MOVE, 4, 3);
        assertEquals(0, testSubject.getXCoordinate());
        assertEquals(0, testSubject.getYCoordinate());
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() {
        chessBoard.add(testSubject, 6, 3, PieceColor.BLACK);
//        testSubject.Move(MovementType.MOVE, 6, 2);
        assertEquals(0, testSubject.getXCoordinate());
        assertEquals(0, testSubject.getYCoordinate());
    }

}