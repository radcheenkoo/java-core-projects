package course.java_core.basics.mini_project3;

public class MultiplicationTableLauncher {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {

                System.out.printf(i + " * " + j + " = " + i * j + "\t");
            }
            System.out.println();
        }

    }
}
