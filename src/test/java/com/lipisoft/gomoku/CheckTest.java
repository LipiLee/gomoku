package com.lipisoft.gomoku;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckTest {
    @Test
    public void checkOverFiveEyes() {
        checkHorizontalWin();
        checkHorizontalReverseWin();
        checkVerticalWin();
        checkVerticalReverseWin();
        checkInclineDiagonalWin();
        checkInclineDiagonalReverseWin();
        checkDeclineDiagonalWin();
        checkDeclineDiagonalReverseWin();
        checkHorizontalWinInTheMiddle();
        checkVerticalWinInTheMiddle();
        checkInclineDiagonalWinInTheMiddle();
        checkDeclineDiagonalWinInTheMiddle();
//        Board notYetWin = new Board();
//        notYetWin = notYetWin.placeStone(Board.Player.BLACK, 0, 0);
//        notYetWin = notYetWin.placeStone(Board.Player.WHITE, 1, 0);
//        notYetWin = notYetWin.placeStone(Board.Player.WHITE, 2, 0);
//        notYetWin = notYetWin.placeStone(Board.Player.WHITE, 3, 0);
//        notYetWin = notYetWin.placeStone(Board.Player.WHITE, 4, 0);
//        Check notYetWinCheck = new Check(notYetWin, 4, 0);
//        assertEquals(false, notYetWinCheck.checkOverFiveEyes());
    }

    private void checkHorizontalWin() {
        Board board = new Board();
        for (int i = 0; i < 5; i++) {
            board = board.placeStone(Board.Player.WHITE, i, 0);
        }
        Check check = new Check(board, 4, 0);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkHorizontalReverseWin() {
        Board board = new Board();
        for (int i = 4; i >= 0; i--) {
            board = board.placeStone(Board.Player.WHITE, i, 0);
        }
        Check check = new Check(board, 0, 0);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkVerticalWin() {
        Board board = new Board();
        for (int i = 0; i < 5; i++) {
            board = board.placeStone(Board.Player.WHITE, 0, i);
        }
        Check check = new Check(board, 0, 4);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkVerticalReverseWin() {
        Board board = new Board();
        for (int i = 4; i >= 0; i--) {
            board = board.placeStone(Board.Player.WHITE, 0, i);
        }
        Check check = new Check(board, 0, 0);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkInclineDiagonalWin() {
        Board board = new Board();
        for (int i = 0, j = 4; i < 5; i++, j--) {
            board = board.placeStone(Board.Player.WHITE, i, j);
        }
        Check check = new Check(board, 4, 0);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkInclineDiagonalReverseWin() {
        Board board = new Board();
        for (int i = 4, j = 0; i >= 0; i--, j++) {
            board = board.placeStone(Board.Player.WHITE, i, j);
        }
        Check check = new Check(board, 0, 4);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkDeclineDiagonalWin() {
        Board board = new Board();
        for (int i = 0, j = 0; i < 5; i++, j++) {
            board = board.placeStone(Board.Player.WHITE, i, j);
        }
        Check check = new Check(board, 4, 4);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkDeclineDiagonalReverseWin() {
        Board board = new Board();
        for (int i = 4, j = 4; i >= 0; i--, j--) {
            board = board.placeStone(Board.Player.WHITE, i, j);
        }
        Check check = new Check(board, 0, 0);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkHorizontalWinInTheMiddle() {
        Board board = new Board();
        board = board.placeStone(Board.Player.WHITE, 0, 0);
        board = board.placeStone(Board.Player.WHITE, 1, 0);
        board = board.placeStone(Board.Player.WHITE, 3, 0);
        board = board.placeStone(Board.Player.WHITE, 4, 0);
        board = board.placeStone(Board.Player.WHITE, 2, 0);
        Check check = new Check(board, 2, 0);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkVerticalWinInTheMiddle() {
        Board board = new Board();
        board = board.placeStone(Board.Player.WHITE, 0, 0);
        board = board.placeStone(Board.Player.WHITE, 0, 1);
        board = board.placeStone(Board.Player.WHITE, 0, 3);
        board = board.placeStone(Board.Player.WHITE, 0, 4);
        board = board.placeStone(Board.Player.WHITE, 0, 2);
        Check check = new Check(board, 0, 2);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkInclineDiagonalWinInTheMiddle() {
        Board board = new Board();
        board = board.placeStone(Board.Player.WHITE, 0, 4);
        board = board.placeStone(Board.Player.WHITE, 1, 3);
        board = board.placeStone(Board.Player.WHITE, 3, 1);
        board = board.placeStone(Board.Player.WHITE, 4, 0);
        board = board.placeStone(Board.Player.WHITE, 2, 2);
        Check check = new Check(board, 2, 2);
        assertTrue(check.checkOverFiveEyes());
    }

    private void checkDeclineDiagonalWinInTheMiddle() {
        Board board = new Board();
        board = board.placeStone(Board.Player.WHITE, 0, 0);
        board = board.placeStone(Board.Player.WHITE, 1, 1);
        board = board.placeStone(Board.Player.WHITE, 3, 3);
        board = board.placeStone(Board.Player.WHITE, 4, 4);
        board = board.placeStone(Board.Player.WHITE, 2, 2);
        Check check = new Check(board, 2, 2);
        assertTrue(check.checkOverFiveEyes());
    }
}