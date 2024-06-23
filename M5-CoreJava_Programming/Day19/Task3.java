/*Day 19 Task 3: 
Job Sequencing Problem
Define a class Job with properties int Id, int Deadline, and int Profit.
Then implement a function List<Job> JobSequencing(List<Job> jobs) that
takes a list of jobs and returns the maximum profit sequence of jobs 
that can be done before the deadlines. Use the greedy method to solve
this problem.
*/import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    // Function to find the maximum profit sequence of jobs that can be done before deadlines
    public static List<Job> jobSequencing(List<Job> jobs) {
        // Sort jobs based on profit in descending order
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        boolean[] slot = new boolean[maxDeadline + 1];
        List<Job> result = new ArrayList<>();

        // Assign jobs to slots starting from the highest deadline
        for (Job job : jobs) {
            for (int i = Math.min(maxDeadline, job.deadline); i > 0; i--) {
                if (!slot[i]) {
                    slot[i] = true;
                    result.add(job);
                    break;
                }
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 4, 20));
        jobs.add(new Job(2, 1, 10));
        jobs.add(new Job(3, 1, 40));
        jobs.add(new Job(4, 1, 30));

        List<Job> result = jobSequencing(jobs);
        System.out.println("Maximum profit sequence of jobs:");
        for (Job job : result) {
            System.out.println("Job ID: " + job.id + ", Deadline: " + job.deadline + ", Profit: " + job.profit);
        }
    }
}
