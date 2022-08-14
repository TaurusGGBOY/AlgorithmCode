import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int[][] g = new int[2][4];
            for (int j = 0; j < g.length; j++) {
                for (int i = 0; i < g[0].length; i++) {
                    g[j][i] = scanner.nextInt();
                }
            }
            boolean vfirst = false;
            if (g[0][3] > g[1][3]) vfirst = true;
            int round = 1;
            while (g[0][0] > 0 && g[1][0] > 0) {
//                for (int i = 0; i < g.length; i++) {
//                    System.out.println(Arrays.toString(g[i]));
//                }
                v2vPass(g);
                // 第一个攻击
                if (vfirst) {
                    v2vRound(g, round);
                    if (g[0][0] <= 0 || g[1][0] <= 0) break;
                    zedRound(g, round);
                } else {
                    zedRound(g, round);
                    if (g[0][0] <= 0 || g[1][0] <= 0) break;
                    v2vRound(g, round);
                }
                round++;
            }
//            for (int i = 0; i < g.length; i++) {
//                System.out.println(Arrays.toString(g[i]));
//            }
            if (g[0][0] <= 0) System.out.println("Kalpas yame te!");
            else System.out.println("I love V2V forever!");
//            System.out.println();
        }
    }

    static boolean v2vPassiveUsed = false;
    static boolean v2vOpUsed = false;
    static boolean zedOpUsed = false;

    static void v2vRound(int[][] g, int round) {
        if (round % 3 == 0) v2vOp(g);
        else v2vSimple(g);
    }

    static void zedRound(int[][] g, int round) {
        if(zedOpUsed){
            zedOpUsed = false;
            return;
        }
        int a = getZedAttack(g);
        if (round % 3 == 0) zedOp(g);
        else zedSimple(g, a);
    }

    static void v2vOp(int[][] g) {
        v2vSimple(g);
        v2vOpUsed = true;
    }

    static void zedOp(int[][] g) {
        int a = getZedAttack(g);
        if (g[1][0] < 11) {
            zedSimple(g, a);
            return;
        }
        zedOpUsed = true;
        g[1][0] -= 10;
        zedSimple(g, 45);
        if(g[0][0] <= 0 || g[0][1] <= 0) return;
        zedSpecial(g, 20);

    }

    static void v2vPass(int[][] g) {
        if (v2vPassiveUsed) return;
        if (g[0][0] >= 31) return;
        g[0][0] += 20;
        g[1][0] += 20;
        g[0][1] += 15;
    }

    static void zedPass(int[][] g) {
        return;
    }


    static void v2vSimple(int[][] g) {
        int a = getV2vAttack(g);
        g[1][0] -= Math.max(0, a-g[1][2]);
    }

    static void zedSimple(int[][] g, int damage) {
        if (v2vOpUsed) {
            v2vOpUsed = false;
            g[1][0] -= Math.max(0, damage - g[1][2]);
            return;
        }
        g[0][0] -= Math.max(0, damage - g[0][2]);
    }

    static int getV2vAttack(int[][] g) {
        return g[0][1];
    }

    static int getZedAttack(int[][] g) {
        return g[1][1] + (100 - g[1][0]) / 5;
    }


    static void v2vSpecial(int[][] g, int damage) {
        g[1][0] -= damage;
    }

    static void zedSpecial(int[][] g, int damage) {
        g[0][0] -= damage;
    }

}
