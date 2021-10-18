package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_Toe implements СheckWin, PrintField, InitField, HumanTurn, Validator, CompTurn, FullField {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][] table;

    public Tic_Tac_Toe(char[][] table) {
        this.table = table;
    }

    @Override
    public void init(char[][] field, char empt) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                field[row][col] = empt;
    }

    @Override
    public boolean valid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3|| y >= 3) {
            return false;
        }
        return true;
    }

    @Override
    public void humanTurn(char[][] field) {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!valid(x, y));
        field[y][x] = SIGN_X;
    }

    @Override
    public void compTurn(char[][] field) {
        int x, y;
        Random random = new Random();
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!valid(x, y));
        field[y][x] = SIGN_O;
    }

    @Override
    public void printField(char[][] tablePrint) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(tablePrint[row][col] + " ");
            System.out.println();
        }
    }

    @Override
    public boolean checkW(char vib) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == vib && table[i][1] == vib &&
                    table[i][2] == vib) ||
                    (table[0][i] == vib && table[1][i] == vib &&
                            table[2][i] == vib))
                return true;
        if ((table[0][0] == vib && table[1][1] == vib &&
                table[2][2] == vib) ||
                (table[2][0] == vib && table[1][1] == vib &&
                        table[0][2] == vib))
            return true;

        return false;
    }

    @Override
    public boolean isFullField(char[][] field) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (field[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }

    public static void main(String[] args) {
        Tic_Tac_Toe ticTacToe = new Tic_Tac_Toe(new char[3][3]);
        ticTacToe.init(ticTacToe.table, ticTacToe.SIGN_EMPTY);
        while (true) {
            ticTacToe.humanTurn(ticTacToe.table);
            if (ticTacToe.checkW(ticTacToe.SIGN_X)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (ticTacToe.isFullField(ticTacToe.table)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            ticTacToe.compTurn(ticTacToe.table);
            ticTacToe.printField(ticTacToe.table);
            if (ticTacToe.checkW(ticTacToe.SIGN_O)) {
                System.out.println("AI WIN!");
                break;
            }
            if (ticTacToe.isFullField(ticTacToe.table)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
        ticTacToe.printField(ticTacToe.table);

    }

}
