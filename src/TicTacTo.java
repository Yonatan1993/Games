import java.util.Random;
import java.util.Scanner;

public class TicTacTo {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        char [][] board =   {{' ',' ',' '},
                            {' ',' ',' '},
                            {' ',' ',' '}};
        while(true) {

            playerTurn(board,scanner);
            if(isGameFinisg(board))
                break;
            computerTurn(board);
            if(isGameFinisg(board))
                break;
            printBoard(board);

        }

    }

    private static boolean isGameFinisg(char[][] board)
    {
        if (hasWon(board,'X')) {
            printBoard(board);
            System.out.println("Player Wins!!");
            return true;
        }
        if (hasWon(board,'O')) {
            printBoard(board);
            System.out.println("Computer Wins!!");
            return true;
        }


        for(int i=0 ;i<board.length;i++)
        {
            for(int j=0; j<board[i].length;j++)
                if(board[i][j]==' ')
                    return false;
        }
        printBoard(board);
        System.out.println("The game is Tie!!");
        return true;
    }

    private static boolean hasWon(char[][] board, char sym) {
        if      ((board[0][0]==sym && board[0][1]==sym && board[0][2]==sym)||
                (board[1][0]==sym && board[1][1]==sym && board[1][2]==sym) ||
                (board[2][0]==sym && board[2][1]==sym && board[2][2]==sym)||

                (board[0][0]==sym && board[1][0]==sym && board[2][0]==sym)||
                (board[0][1]==sym && board[1][1]==sym && board[2][1]==sym)||
                (board[0][2]==sym && board[2][1]==sym && board[2][2]==sym)||

                (board[0][0]==sym && board[1][1]==sym && board[2][2]==sym)||
                (board[0][2]==sym && board[1][1]==sym && board[2][0]==sym))
        {

            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while(true) {
             computerMove = rand.nextInt(9) + 1;
            if(isValidMove(board,Integer.toString(computerMove)))
                break;
        }
        System.out.println("Computer chose: "+ computerMove);
        placeMove(board,Integer.toString(computerMove),'O');
    }

    private static boolean isValidMove(char[][] board, String pos)
        {
            switch(pos) {
                case "1":
                    return (board[0][0] == ' ');

                case "2":
                    return (board[0][1] == ' ');

                case "3":
                    return (board[0][2] == ' ');

                case "4":
                    return (board[1][0] == ' ');
                case "5":
                    return (board[1][1] == ' ');
                case "6":
                    return (board[1][2] == ' ');
                case "7":
                    return (board[2][0] == ' ');
                case "8":
                    return (board[2][1] == ' ');
                case "9":
                    return (board[2][2] == ' ');
                default:
                   return  false;

            }

        }

    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while(true) {
            System.out.println("Where you want to play? (1-9)");
             userInput = scanner.nextLine();
            System.out.println(userInput);
            if (isValidMove(board, userInput))
                break;
            else
                System.out.println(userInput+" Not a valid move");
        }
            placeMove(board, userInput, 'X');

    }

    private static void placeMove(char[][] board, String pos,char sym ) {
        switch(pos) {
            case "1":
                board[0][0] = sym;
                break;
            case "2":
                board[0][1] = sym;
                break;
            case "3":
                board[0][2] = sym;
                break;
            case "4":
                board[1][0] = sym;
                break;
            case "5":
                board[1][1] = sym;
                break;
            case "6":
                board[1][2] = sym;
                break;
            case "7":
                board[2][0] = sym;
                break;
            case "8":
                board[2][1] = sym;
                break;
            case "9":
                board[2][2] = sym;
                break;
            default:
                System.out.println(":(");

        }
    }


    private static void printBoard(char[][] board) {
        System.out.println(board[0][0]+"|"+ board[0][1]+"|"+ board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+"|"+ board[1][1]+"|"+ board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+"|"+ board[2][1]+"|"+ board[2][2]);
        System.out.println("-+-+-");
    }
}
