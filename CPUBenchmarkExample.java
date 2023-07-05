import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;

public class CPUBenchmarkExample {

    public static void main(String[] args) {

        do {

            System.out.println("======================== System Inormation ======================================");
            System.out.println();
            OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
            RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
            String vmName = runtimeBean.getVmName();
            String vmVersion = runtimeBean.getVmVersion();
            int availableProcessors = osBean.getAvailableProcessors();
            String osArch = osBean.getArch();
            double systemLoadAverage = osBean.getSystemLoadAverage();
            System.out.println("Java Virtual Machine: " + vmName + " " + vmVersion);
            System.out.println("Available Processors: " + availableProcessors);
            System.out.println("Operating System Architecture: " + osArch);
            System.out.println("System Load Average: " + systemLoadAverage);
            /* Total amount of free memory available to the JVM */
            System.out.println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());
            /* This will return Long.MAX_VALUE if there is no preset limit */
            long maxMemory = Runtime.getRuntime().maxMemory();
            /* Maximum amount of memory the JVM will attempt to use */
            System.out.println("Maximum memory (bytes): " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));
             /* Total memory currently available to the JVM */
            System.out.println("Total memory available to JVM (bytes): " + Runtime.getRuntime().totalMemory());
            System.out.println();
            System.out.println("======================== Benchmark system ======================================");
            System.out.println();
            long number = 100000000; // Change this to the desired number
            long startTime = System.currentTimeMillis();
            long sum = 0;

            int total = 100; // Total number of iterations
            for (int progress = 0; progress <= total; progress++) {

                updateProgressBar(progress, total);
                for (long i = 1; i <= number; i++) {
                    sum += i;
                }
            }
            System.out.println();
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            //System.out.println("Sum: " + sum);
            long score = (100000 - elapsedTime)/100;
            System.out.println();
            System.out.println("Elapsed Time: " + elapsedTime + " milliseconds (hihger is worse)");
            System.out.println("System score: " + score + " (hihger is better)");
            System.out.println();

            System.out.println("Comparison with other systems:");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Intel Core i7-11800H @2.30GHz (16 cores) - System score: 952");
            System.out.println("Intel Core i5-1145G7 @2.60GHz (8 cores) -  System score: 962");
            System.out.println("Intel Core i7-10710U @1.10GHz (12 cores) - System score: 940");
            System.out.println("-------------------------------------------------------------");
            System.out.println();
            System.out.println("Next execution of the benchmark loop ...");
            System.out.println();
        } while (true);
    }

    private static void updateProgressBar(int progress, int total) {
        int barLength = 65; // Length of the progress bar
        float percent = (float) progress / total;
        int filledLength = (int) (barLength * percent);

        StringBuilder progressBar = new StringBuilder();
        progressBar.append("[");
        for (int i = 0; i < filledLength; i++) {
            progressBar.append("=");
        }
        for (int i = filledLength; i < barLength; i++) {
            progressBar.append(" ");
        }
        progressBar.append("] ");
        progressBar.append(String.format("%.2f", percent * 100));
        progressBar.append("%");

        System.out.print("\r" + progressBar.toString());
        System.out.flush();
    }
}
