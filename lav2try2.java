import java.util.Scanner;

public class lav2try2 {
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
            System.out.println(3); // lägg till en tredje skådespelare
            System.out.println("1 1");
            System.out.println("1 2");
            System.out.println("1 3"); // roll 3: aktör 3
            System.out.println("1 3"); // roll 4: aktör 3
            System.out.println("2 1 3"); // aktör 1 och aktör 3 → OK
            System.out.println("2 2 4"); // aktör 2 och aktör 3 → OK
            return;
        }
        int roles = v + 2;
        int scenes = e + v + 1; // vi omvandlar alla kanter till scener + diva 1 ska ha en scen till alla noder
                                // + diva 2 ska ha en scen
        int actors = colors + 2;// vi lägger till alla färger som skådespelare + diva1 +diva 2
        System.out.println(roles);
        System.out.println(scenes);
        System.out.println(actors);
        // nu ska vi printa ut type 1 constraints, alltså vilka skådespelare är
        // tillängliga för vissa roller
        for (int i = 1; i <= v; i++) {
            System.out.print(colors);
            for (int j = 3; j <= colors + 2; j++) {
                System.out.print(" " + j);// vi visar att "alla" skådespelare är tillängliga för "alla" roller
            }
            System.out.println();
        }
        // ni ska vi printa att roll 1 bara kan vara diva 1 och roll 2 bara är diva 2
        System.out.println("1 1"); // diva 1
        System.out.println("1 2"); // diva 2

        // ni ska vi skriva ut type 2 constraintsen, printa ut edgematrix sen lägg till
        // diva 1's roll till varje nod

        for (int i = 0; i < e; i++) {
            System.out.println("2 " + edgematrix[i][0] + " " + edgematrix[i][1]); // skriv ut alla kanter som finns i
                                                                                  // grafen
        }
        // nu måste vi koppla så det inte finns monologer i format "2 role1 role2" så nu
        // kopplar vi diva 1 till alla andra roller förutom diva2's roll

        for (int i = 1; i <= v; i++) { // nu kopplar vi diva role 1 till alla noder i original grafen
            System.out.println("2 " + (v + 1) + " " + i);
        }
        // nu måste vi koppla diva 2 till någon roll i grafen
        System.out.println("2 " + (v + 2) + " " + "1");

    }
}
