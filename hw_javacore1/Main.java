import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        runTask1(scanner);
//        runTask2(scanner);
//        runTask3();
//        runTask4();
    }

    //task 1
    static void runTask1(Scanner scanner) {
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        task1 verify = new task1();
        boolean sorted = verify.sortedAscending(n, arr);
        System.out.println(sorted);
    }

    //task 2
    static void runTask2(Scanner scanner) {
        scanner.nextLine(); // consume leftover newline

        task2 reverse = new task2();
        String toReverse = scanner.nextLine();
        System.out.println("First method: using a for loop: ");
        System.out.println(reverse.reverseLoop(toReverse));

        System.out.println("\nSecond method: using StringBuilder: ");
        System.out.println(reverse.stringBuilder(toReverse));

        System.out.println("\nThird method: using a char array: ");
        System.out.println(reverse.reverseChars(toReverse));
    }

    //task 3
    static void runTask3() {
        Person p1 = new Person();
        p1.name = "John";
        p1.age = 25;

        Person p2 = new Person();
        p2.name = "Alice";
        p2.age = 30;

        System.out.println("Before:");
        System.out.println("First person: " + p1.name + " " + p1.age);
        System.out.println("Second persopn: " + p2.name + " " + p2.age);

        MakingChanges.changeIdentities(p1, p2);

        System.out.println("\nAfter:");
        System.out.println("First person: " + p1.name + " " + p1.age);
        System.out.println("Second persopn: " + p2.name + " " + p2.age);
    }


    // task 4
    static void runTask4() {
        User user1 = new User(10L, "John", "Smith");
        User user2 = new User(11L, "Alice", "Brown");
        User user3 = new User(12L, "Bob", "Johnson");

        Account account1 = new Account(1L, 500, user1);
        Account account2 = new Account(2L, 1500, user2);
        Account account3 = new Account(3L, 2500, user3);

        Account[] accounts = {account1, account2, account3};

        AccountService service = new AccountServiceImpl(accounts);

        // Test findAccountByOwnerId
        Account found = service.findAccountByOwnerId(12);

        if (found != null) {
            System.out.println("Found account:\n" + "Id: " + found.getId() + "\nOwner: " + found.getOwner().getFirstName() + " " + found.getOwner().getLastName());
        } else {
            System.out.println("Account not found");
        }

        // Test countAccountsWithBalanceGreaterThan
        long count = service.countAccountsWithBalanceGreaterThan(1000L);

        System.out.println("\nAccounts with balance > 1000: " + count);
    }
}
