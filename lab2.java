import java.util.*;

class lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int v = scanner.nextInt(); // input för Noder
        int e = scanner.nextInt(); // input för kanter
        int colors = scanner.nextInt(); // input för färger i vår coloring graph

        int[][] edgematrix = new int[e][2]; // skapa en e*2 matrix för att hålla alla kanter
        for (int i = 0; i < e; i++) { // input för att kanter som ska existera i grafen
            edgematrix[i][0] = scanner.nextInt();
            edgematrix[i][1] = scanner.nextInt();
        }

        // skapa instans av the casting problem
        // lägg till 1 buddy role/nod per nod (inklusive divor) för att säkerställa inga
        // monologer
        int roles = (v + 2) * 2; // så alla roller plus var sin diva får en buddy role var
        int scenes = (e + 2) * 2; // lägg till alla scener (noder) i vår nya instans
        int actors = colors + 3; // alla färger + 2 divor + buddy
        System.out.println(roles);
        System.out.println(scenes);
        System.out.println(actors);

        // skapa type 1 constraints (role constrains) alltså vilka skådespelare som kan
        // spela rollen
        for (int i = 1; i <= v; i++) {
            System.out.print(colors);
            for (int j = 3; j <= colors + 2; j++) {
                System.out.print(" " + j);
            }
            System.out.println();

        }
        // skapa type 1 constraint för buddy roles också inklusive diva
        for (int i = 1; i <= v + 2; i++) {
            System.out.println("1 " + (colors + 3));
        }
        System.out.println("1 1");
        System.out.println("1 2");

    }

}
