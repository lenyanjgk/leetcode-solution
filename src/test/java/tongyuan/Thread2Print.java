package tongyuan;

public class Thread2Print {
    private int currentNum = 0;
    private final Object lock = new Object();

    public static void main(String[] args) {
        Thread2Print printer = new Thread2Print();

        Thread threadA = new Thread(printer::printNum);
        Thread threadB = new Thread(printer::printNum);

        threadA.start();
        threadB.start();
    }

    public void printNum() {
        while (true) {
            synchronized (lock) {
                System.out.println(currentNum);
                currentNum++;

                if (currentNum > 200) break;

                lock.notify();
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}