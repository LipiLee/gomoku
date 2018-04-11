package com.lipisoft.gomoku;

import java.util.Scanner;

enum Play {
    INSTANCE;
    Board board = new Board();

    void playGame() {
        do {
            if (playAndFinished(Board.Player.WHITE)) {
                break;
            }

            if (board.isFull()) {
                break;
            }

            if (playAndFinished(Board.Player.BLACK)) {
                break;
            }
        } while(board.isFull());

        System.out.println("Game over.");
    }

    private boolean playAndFinished(final Board.Player player) {
        if (play(player)) {
            System.out.println("The Winner is " + player.getName());
            return true;
        }
        return false;
    }

    private boolean play(final Board.Player player) {
        while (true) {
            System.out.println("Press x, y in range 0~14 for " + player.getName() + " stone");
            final Scanner scanner = new Scanner(System.in);
            final int x = scanner.nextInt();
            final int y = scanner.nextInt();

            if (x < 0 || y < 0) {
                System.exit(1);
            }

            if (board.placeable(x, y)) {
                board = board.placeStone(player, x, y);
                return finished(x, y);
            } else {
                System.out.println("You can't place it there. Try it again.");
            }
        }
    }

    private boolean finished(final int x, final int y) {

        return false;
    }
}
