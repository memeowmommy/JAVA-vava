public class Main {
    public static void main(String[] args) {
        LabiOne();
   }
    static void LabiOne() {
        LabiOne tasks = new LabiOne();

        System.out.println(tasks.TaskOne());

        System.out.println(tasks.TaskTwo());

        System.out.println(tasks.TaskThree());

        System.out.println(tasks.TaskFour());

        System.out.println(tasks.TaskFive());

        tasks.in.close();
    }
}
