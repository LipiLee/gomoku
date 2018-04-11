package com.lipisoft.gomoku;

class Board {
    public static final int row = 15;
    public static final int column = 15;

    private final Player[][] board;

    enum Player {
        NONE("none"),
        WHITE("White"),
        BLACK("Black");

        final String name;
        Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    Board() {
        board = new Player[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = Player.NONE;
            }
        }
    }

    private Board(Player[][] board) {
        this.board = new Player[row][column];
        System.arraycopy(board, 0, this.board, 0, board.length);
    }

    boolean placeable(int x, int y) {
        return board[x][y] == Player.NONE;
    }

    Board placeStone(Player player, int x, int y) {
        final Board newBoard = new Board(board);
        newBoard.board[x][y] = player;
        return newBoard;
    }

    boolean isFull() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == Player.NONE) {
                    return false;
                }
            }
        }
        System.out.println("Board is full.");
        return true;
    }

    Player getPlayer(final int x, final int y) {
        return board[x][y];
    }
}
