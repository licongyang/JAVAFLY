package com.legend.basic.newfeature;


import java.util.concurrent.*;

public class MyFunctionInterface {

    public static void main(String[] args) {

        // java7 只能通过匿名内部类进行编程
        final GreetingServiceFunctionInterface greetingServiceFunctionInterface = new GreetingServiceFunctionInterface() {

            @Override
            public void sayMessage(String message) {
                System.out.println("hello" + message);
            }
        };

        // java8可以采用lambda表达式进行编程,相当于匿名内部类
        GreetingServiceFunctionInterface greeetingService = message -> System.out.println("hello" + message);
        greeetingService.sayMessage("world");
        // Callable接口是非常典型的函数型接口
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Callable<Integer> callable = () -> {
            int n = 0;
            for (int i = 0; i < 100; i++) {
                n += i;
            }
            return n;
        };

        final Future<Integer> f = executorService.submit(callable);

        try {
            final Integer result = f.get(); // wait for a thread to complete
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }
}
