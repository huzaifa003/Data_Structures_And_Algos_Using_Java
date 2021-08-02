package queueImplementation;

public class QueueImplementationGenericRunner {
    public static void main(String[] args) {
        QueueImplementationGeneric<Integer> queue1 = new QueueImplementationGeneric<>();

        queue1.enqueue(4);
        queue1.enqueue(5);
        queue1.enqueue(6);
        queue1.enqueue(7);
        queue1.enqueue(8);

        System.out.println(queue1.dequeue());
        System.out.println("LENGTH AFTER FIRST DEQUEUE IS = " +queue1.length );
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
        System.out.println(queue1.dequeue());
    }
}
