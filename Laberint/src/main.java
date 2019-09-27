import java.util.Scanner;
public class main {

    static boolean gameEnded = false;
    private static char PLAY = 'P';
    private static char PICK = '?';
    private static char BOMB = '@';
    private static char WALL = '#';
    private static char PATH = '+';
    private static char EXIT = 'S';
    private static char VOID = '-';
    private static char DWAL = 'X';

    public static void main(String[] args) {

        char[][] emptyLabyrinth = { { DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL },
                                    { DWAL, PLAY, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL },
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL },
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL },
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL },
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                    { DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL } };

        Map map = new Map();
        Player player = new Player();
        String direction;
        Scanner read = new Scanner(System.in);
        char[][] trueLabyrinth = map.createMap();

        System.out.println("Welcome to the maze game");

        while (!gameEnded) {

            boolean checkDirection = false;

            for (int i = 0; i < emptyLabyrinth.length; i++) {

                for (int j = 0; j < emptyLabyrinth.length; j++) {

                    System.out.print(emptyLabyrinth[i][j]);
                    System.out.print(" ");

                }
                System.out.println("");
            }

             while (!checkDirection) {

                 System.out.println("In which direction do you want to move?");
                 direction = read.nextLine();

                 switch (direction.toUpperCase()) {

                     case "UP":

                         player.makeAMove(emptyLabyrinth, trueLabyrinth, "up");
                         checkDirection = true;
                         break;

                     case "DOWN":

                         player.makeAMove(emptyLabyrinth, trueLabyrinth, "down");
                         checkDirection = true;
                         break;

                     case "LEFT":

                         player.makeAMove(emptyLabyrinth, trueLabyrinth, "left");
                         checkDirection = true;
                         break;

                     case "RIGHT":

                         player.makeAMove(emptyLabyrinth, trueLabyrinth, "right");
                         checkDirection = true;
                         break;

                     case "HELP":

                         player.makeAMove(emptyLabyrinth, trueLabyrinth, "help");
                         checkDirection = true;
                         break;

                     default:

                         System.out.println("That's not a valid direction, please enter a valid one: ");
                         checkDirection = false;
                 }

             }
        }

    }

}
