public class Map {

    private static char PLAY = 'P';
    private static char PICK = '?';
    private static char BOMB = '@';
    private static char WALL = '#';
    private static char PATH = '+';
    private static char EXIT = 'S';
    private static char VOID = '-';
    private static char DWAL = 'X';
    private static int HOWMANYBOMBS = 7;

    public char[][] createMap() {

        char[][] labyrinth = {  { DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL },
                                { DWAL, PLAY, WALL, VOID, VOID, VOID, VOID, VOID, WALL, VOID, VOID, VOID, WALL, WALL, VOID, VOID, VOID, VOID, VOID, DWAL },
                                { DWAL, VOID, WALL, VOID, VOID, VOID, WALL, VOID, WALL, VOID, WALL, VOID, WALL, WALL, VOID, VOID, VOID, VOID, VOID, DWAL },
                                { DWAL, VOID, WALL, VOID, VOID, VOID, WALL, VOID, WALL, VOID, WALL, VOID, WALL, WALL, VOID, VOID, VOID, VOID, VOID, DWAL },
                                { DWAL, VOID, WALL, VOID, VOID, VOID, WALL, VOID, WALL, VOID, WALL, VOID, WALL, EXIT, VOID, VOID, VOID, VOID, VOID, DWAL },
                                { DWAL, VOID, VOID, VOID, VOID, WALL, WALL, VOID, WALL, VOID, WALL, VOID, WALL, WALL, VOID, VOID, WALL, VOID, VOID, DWAL},
                                { DWAL, WALL, WALL, VOID, WALL, WALL, VOID, VOID, WALL, PICK, WALL, VOID, VOID, WALL, WALL, VOID, WALL, VOID, VOID, DWAL},
                                { DWAL, PICK, WALL, PICK, WALL, VOID, VOID, WALL, WALL, WALL, WALL, VOID, VOID, WALL, WALL, WALL, WALL, VOID, VOID, DWAL},
                                { DWAL, VOID, WALL, WALL, WALL, VOID, VOID, WALL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, WALL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, WALL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, WALL, WALL, WALL, WALL, WALL, VOID, WALL, VOID, VOID, VOID, WALL, WALL, VOID, WALL, WALL, VOID, VOID, VOID, DWAL},
                                { DWAL, VOID, VOID, PICK, WALL, VOID, VOID, VOID, VOID, VOID, WALL, WALL, WALL, VOID, WALL, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, VOID, WALL, WALL, WALL, VOID, VOID, VOID, VOID, VOID, WALL, PICK, WALL, VOID, WALL, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, VOID, WALL, WALL, WALL, VOID, VOID, VOID, VOID, WALL, WALL, VOID, WALL, PICK, WALL, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, VOID, WALL, VOID, WALL, VOID, VOID, VOID, VOID, WALL, VOID, VOID, WALL, WALL, WALL, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, WALL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, VOID, VOID, WALL, WALL, WALL, WALL, VOID, VOID, WALL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, VOID, VOID, VOID, VOID, PICK, WALL, VOID, VOID, WALL, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, VOID, DWAL},
                                { DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL, DWAL } };

        labyrinth = placeBombs(labyrinth);
        return labyrinth;

    }

    private char[][] placeBombs(char[][]labyrinth) {

        int rand1;
        int rand2;
        int totalBombs = 0;

        while (totalBombs != HOWMANYBOMBS) {

            rand1 = (int) Math.floor((Math.random() * 20) + 0);
            rand2 = (int) Math.floor((Math.random() * 20) + 0);

            if (labyrinth[rand1][rand2] == VOID) {

                labyrinth[rand1][rand2] = BOMB;
                totalBombs++;

            }

        }
        return labyrinth;
    }

}
