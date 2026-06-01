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

        // NO-instans
        if (colors == 0 && v > 0) {
            System.out.println(2);
            System.out.println(1);
            System.out.println(2);
            System.out.println("1 1");
            System.out.println("1 1");
            System.out.println("2 1 2");
            return;
        }

        // YES-instans
        if (colors == 0 && v == 0 || v < 2) {
            System.out.println(4);
            System.out.println(2);
            System.out.println(2);
            System.out.println("1 1");
            System.out.println("1 2");
            System.out.println("1 1");
            System.out.println("1 2");
            System.out.println("2 1 3");
            System.out.println("2 2 4");
            return;
        }

        // skapa instans av the casting problem
        // lägg till 1 buddy role/nod per nod (inklusive divor) för att säkerställa inga
        // monologer
        int roles = v + 2; // så alla roller plus var sin diva får en buddy role var
        int scenes = e + v + 2; // lägg till alla scener (kanter) så alla vanliga kanter + en extra för varje //
                                // nod + divorna får var sin
        int actors = colors + 2; // alla färger + 2 divor + buddy
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
        // type 1 constraint för divorna
        System.out.println("1 1");
        System.out.println("1 2");

        // skapa type 2 constraints
        // för type 2 constraints ska vi först skriva ut hur många ints det är sedan
        // vilka roller för vilka scener fram till scen s
        for (int i = 0; i < e; i++) {
            System.out.println("2 " + edgematrix[i][0] + " " + edgematrix[i][1]);
        }
        // Nod-roll + sin buddy
        for (int i = 1; i <= v; i++) {
            System.out.println("2 " + i + " " + (v + 2 + i));
        }
        // Diva 1 + sin buddy
        System.out.println("2 " + (v + 1) + " " + (2 * v + 3));
        // Diva 2 + sin buddy
        System.out.println("2 " + (v + 2) + " " + (2 * v + 4));
    }

}
