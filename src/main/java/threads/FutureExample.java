package threads;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                // Simulate long-running task
                Thread.sleep(2000);
                
//                 Uncomment to simulate task failure
//                 throw new RuntimeException("Task failed!");
                
                return "Task completed successfully";
            }
        });

        try {
            // Try to get result with 1 second timeout
            String result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
            
        } catch (InterruptedException e) {
            System.out.println("Waiting thread was interrupted");
            Thread.currentThread().interrupt();
            
        } catch (ExecutionException e) {
            System.out.println("Task threw exception: " + e.getCause());
            
        } catch (TimeoutException e) {
            System.out.println("Task timed out");
            future.cancel(true); // Interrupt the running task
            
        } catch (CancellationException e) {
            System.out.println("Task was cancelled");
            
        } finally {
            executor.shutdown();
        }
    }
}