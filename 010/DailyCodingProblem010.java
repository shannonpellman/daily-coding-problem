public class DailyCodingProblem010 {

    public static void main(String[] args) {

        schedule(() -> System.out.println("Job 1"), 4000);
        schedule(() -> System.out.println("Job 2"), 2000);
        schedule(() -> System.out.println("Job 3"), 500);
        schedule(() -> System.out.println("Job 4"), 10000);
    }

    public static void schedule(final Runnable runnable, final long delay) {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        t.start();
    }
}
