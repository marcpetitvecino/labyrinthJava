import java.util.Scanner;

public class Player {

int lifes = 5;
int playerRow = 1;
int playerColumn = 1;
int picks = 0;

    public char[][] makeAMove(char[][]emptyLabyrinth, char[][] trueLabyrinth, String direction) {

        switch (direction.toUpperCase()) {

            case "UP":

                if (checkPosition(trueLabyrinth, playerRow-1, playerColumn)) {

                    emptyLabyrinth[playerRow-1][playerColumn] = 'P';
                    trueLabyrinth[playerRow-1][playerColumn] ='P';
                    emptyLabyrinth[playerRow][playerColumn] = '+';
                    trueLabyrinth[playerRow][playerColumn] ='+';

                    playerRow--;

                    return emptyLabyrinth;

                } else {

                    emptyLabyrinth[playerRow-1][playerColumn] = '#';
                    trueLabyrinth[playerRow-1][playerColumn] ='#';

                }

                break;

            case "DOWN":

                if (checkPosition(trueLabyrinth, playerRow+1, playerColumn)) {

                    emptyLabyrinth[playerRow+1][playerColumn] = 'P';
                    trueLabyrinth[playerRow+1][playerColumn] ='P';
                    emptyLabyrinth[playerRow][playerColumn] = '+';
                    trueLabyrinth[playerRow][playerColumn] ='+';
                    playerRow++;

                    return emptyLabyrinth;

                } else {

                    emptyLabyrinth[playerRow+1][playerColumn] = '#';
                    trueLabyrinth[playerRow+1][playerColumn] ='#';

                }

                break;

            case  "RIGHT":

                if (checkPosition(trueLabyrinth, playerRow, playerColumn+1)) {

                    emptyLabyrinth[playerRow][playerColumn+1] = 'P';
                    trueLabyrinth[playerRow][playerColumn+1] ='P';
                    emptyLabyrinth[playerRow][playerColumn] = '+';
                    trueLabyrinth[playerRow][playerColumn] ='+';

                    playerColumn++;

                    return emptyLabyrinth;

                } else {

                    emptyLabyrinth[playerRow][playerColumn+1] = '#';
                    trueLabyrinth[playerRow][playerColumn+1] ='#';

                }

                break;

            case "LEFT":

                if (checkPosition(trueLabyrinth, playerRow, playerColumn-1)) {

                    emptyLabyrinth[playerRow][playerColumn-1] = 'P';
                    trueLabyrinth[playerRow][playerColumn-1] ='P';
                    emptyLabyrinth[playerRow][playerColumn] = '+';
                    trueLabyrinth[playerRow][playerColumn] ='+';

                    playerColumn--;

                    return emptyLabyrinth;

                } else {

                    emptyLabyrinth[playerRow][playerColumn-1] = '#';
                    trueLabyrinth[playerRow][playerColumn-1] ='#';

                }

                break;

            case "HELP":

                help(trueLabyrinth, playerRow, playerColumn);
                break;

            default:

                System.out.println("Enter a valid direction");
        }

        return emptyLabyrinth;


    }

    private boolean checkPosition(char[][]labyrinth, int newRow, int newColumn) {

        boolean youCanPass = false;

            switch (labyrinth[newRow][newColumn]) {

                case '#':

                    System.out.println("There's a wall!");

                    if (picks > 0) {

                        youCanPass = breakWall();

                    } else {

                        youCanPass = false;

                    }

                    break;

                case 'X':

                    System.out.println("There's an UNBREAKABLE wall");
                    youCanPass = false;
                    break;

                case '?':

                    System.out.println("You got a pick!");
                    picks++;
                    youCanPass = true;

                    break;


                case '@':

                    System.out.println("BOOM! You've lost a life");
                    lifes--;

                    if (lifes == 0) {

                        endGame();

                    }

                    youCanPass = true;

                    break;

                case 'S':

                    System.out.println("You found the exit! You won!");
                    endGame();
                    break;

                case '-':

                case '+':

                    System.out.println("You advance without problems");
                    youCanPass = true;

                    break;

                default:
                    System.out.println("ERROR");

            }

            return youCanPass;

    }

    void endGame() {

        main.gameEnded = true;

    }

    private void help (char[][] laberint, int fila, int columna) {

        for (int i = 0; i < laberint[0].length; i++) {

            for (int j = 0; j < laberint[1].length; j++) {

                if (laberint[i][j] == 'S') {

                    if (fila < i && columna == j) {
                        System.out.println("The exit is down from your position");
                    } else if (fila > i && columna == j) {
                        System.out.println("The exit is up from your position");
                    } else if (fila == i && columna < j) {
                        System.out.println("The exit is right from your position");
                    } else if (fila == i && columna > j) {
                        System.out.println("The exit is left from your position");
                    } else if (fila < i && columna < j) {
                        System.out.println("The exit is down and right from your position");
                    } else if (fila < i && columna > j) {
                        System.out.println("The exit is down and left from your position");
                    } else if (fila > i && columna < j) {
                        System.out.println("The exit is up and right from your position");
                    } else if (fila > i && columna > j) {
                        System.out.println("The exit is up and left from your position");
                    }
                }
            }
        }
    }

    private boolean breakWall() {

        Scanner read = new Scanner(System.in);
        String answer;
        boolean retard = false;
        boolean youCanPass = false;

        while (!retard) {

            System.out.println("Do you want to spend a pick to break it?");
            answer = read.nextLine();

            if (answer.equalsIgnoreCase("Yes")) {

                youCanPass = true;
                retard = true;
                picks--;

            } else if(answer.equalsIgnoreCase("No")) {

                youCanPass = false;
                retard = true;

            } else {

                System.out.println("Please answer Yes or No");
                retard = false;
            }

        }

        return youCanPass;
    }

}
