package com.lipisoft.gomoku;

public class Check {
    private final Board board;
    private final int x;
    private final int y;
    private final Board.Player player;

    public Check(final Board board, final int x, final int y) {
        this.board = board;
        this.x = x;
        this.y = y;
        player = board.getPlayer(x, y);
    }

    public boolean checkOverFiveEyes() {
        // check all 8 angles
        if (checkRightDirection())
            return true;
        if (checkLeftDirection())
            return true;
        if (checkUpDirection())
            return true;
        if (checkDownDirection())
            return true;
        if (checkUpRightDirection())
            return true;
        if (checkDownLeftDirection())
            return true;
        if (checkDownRightDirection())
            return true;
        if (checkDownRightDirection())
            return true;
        if (checkUpLeftDirection())
            return true;

        // check it in the middle
        if (inHorizontal())
            return moveHorizontal();
        if (inVertical())
            return moveVertical();
        if (inIncline())
            return moveIncline();
        if (inDecline())
            return moveDecline();

        return false;
    }

    private boolean checkRightDirection() {
        for (int i = x; i < Board.row && board.getPlayer(i, y) == player; i++) {
            if (i - x == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLeftDirection() {
        for (int i = x; i >= 0 && board.getPlayer(i, y) == player; i--) {
            if (x - i == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean checkUpDirection() {
        for (int i = y; i >= 0 && board.getPlayer(x, i) == player; i--) {
            if (y - i == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDownDirection() {
        for (int i = y; i < Board.column && board.getPlayer(x, i) == player; i++) {
            if (i - y == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean checkUpRightDirection() {
        for (int i = x, j = y; i < Board.row && j >= 0 && board.getPlayer(i, j) == player; i++, j--) {
            if (i - x == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDownLeftDirection() {
        for (int i = x, j = y; i >= 0 && j < Board.column && board.getPlayer(i, j) == player; i--, j++) {
            if (x - i == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDownRightDirection() {
        for (int i = x, j = y; i < Board.row && j < Board.column && board.getPlayer(i, j) == player; i++, j++) {
            if (i - x == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean checkUpLeftDirection() {
        for (int i = x, j = y; i >= 0 && j >= 0 && board.getPlayer(i, j) == player; i--, j--) {
            if (x - i == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean inHorizontal() {
        return x-1 >= 0 && x+1 < Board.row &&
                board.getPlayer(x-1, y) == player && board.getPlayer(x+1, y) == player;
    }

    private boolean moveHorizontal() {
        for (int i = x; i >= 0; i--) {
            if (board.getPlayer(i, y) != player) {
                Check newCheck = new Check(board, i+1, y);
                return newCheck.checkRightDirection();
            }
        }
        return false;
    }

    private boolean inVertical() {
        return y-1 >= 0 && y+1 < Board.column &&
            board.getPlayer(x, y-1) == player && board.getPlayer(x, y+1) == player;
    }

    private boolean moveVertical() {
        for (int i = y; i >= 0; i--) {
            if (board.getPlayer(x, i) != player) {
                Check newCheck = new Check(board, x, i+1);
                return newCheck.checkDownDirection();
            }
        }
        return false;
    }

    private boolean inIncline() {
        return x-1 >= 0 && y+1 < Board.column && x+1 < Board.row && y-1 >= 0 &&
            board.getPlayer(x-1, y+1) == player && board.getPlayer(x+1, y-1) == player;
    }

    private boolean moveIncline() {
        for (int i = x, j = y; i >= 0 && j < Board.column; i--, j++) {
            if (board.getPlayer(i, j) != player) {
                Check newCheck = new Check(board, i+1, j-1);
                return newCheck.checkUpRightDirection();
            }
        }
        return false;
    }

    private boolean inDecline() {
        return x-1 >= 0 && y-1 >= 0 && x+1 < Board.row && y+1 < Board.column &&
            board.getPlayer(x-1, y-1) == player && board.getPlayer(x+1, y+1) == player;
    }

    private boolean moveDecline() {
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (board.getPlayer(i, j) != player) {
                Check newCheck = new Check(board, i+1, j+1);
                return newCheck.checkDownRightDirection();
            }
        }
        return false;
    }
}
