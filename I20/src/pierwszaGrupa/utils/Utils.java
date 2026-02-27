package pierwszaGrupa.utils;
public class Utils {
    public static void printMap(int[][] map) {
        System.out.println("\n-------------\n");
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
    }
}
