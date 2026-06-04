import java.util.Scanner;

public class lab2try3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int v = scanner.nextInt();
        int e = scanner.nextInt();
        int colors = scanner.nextInt();
        int[][] edgematrix = new int[e][2];
        for (int i = 0; i < e; i++) {
            edgematrix[i][0] = scanner.nextInt();
            edgematrix[i][1] = scanner.nextInt();
        }

        if (colors == 0 && v > 0) {
            out.append("2\n1\n2\n1 1\n1 1\n2 1 2\n");
            System.out.print(out);
            return;
        }
        if ((colors == 0 && v == 0) || v < 2) {
            out.append("4\n2\n3\n1 1\n1 2\n1 3\n1 3\n2 1 3\n2 2 4\n");
            System.out.print(out);
            return;
        }

        colors = Math.min(colors, v);

        out.append(v + 2).append('\n');
        out.append(e + v + 1).append('\n');
        out.append(colors + 2).append('\n');

        for (int i = 0; i < v; i++) {
            out.append(colors);
            for (int j = 3; j <= colors + 2; j++) {
                out.append(' ').append(j);
            }
            out.append('\n');
        }

        out.append("1 1\n");
        out.append("1 2\n");

        for (int i = 0; i < e; i++) {
            out.append("2 ").append(edgematrix[i][0]).append(' ').append(edgematrix[i][1]).append('\n');
        }

        for (int i = 1; i <= v; i++) {
            out.append("2 ").append(v + 1).append(' ').append(i).append('\n');
        }

        out.append("2 ").append(v + 2).append(" 1\n");

        System.out.print(out);
    }
}
