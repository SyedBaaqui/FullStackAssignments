/*Day-19: Task 1: 
Tower of Hanoi Solver
Create a program that solves the Tower of Hanoi puzzle for n disks.
The solution should use recursion to move disks between three
pegs (source, auxiliary, and destination) according to the game's rules.
The program should print out each move required to solve the puzzle.
*/
//Solution:

public class TowerOfHanoi {

    // Function to solve Tower of Hanoi puzzle
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    // Main method for testing
    public static void main(String[] args) {
        int n = 3; // Number of disks
        char source = 'A', auxiliary = 'B', destination = 'C'; // Pegs

        System.out.println("Tower of Hanoi solution with " + n + " disks:");
        towerOfHanoi(n, source, auxiliary, destination);
    }
}
