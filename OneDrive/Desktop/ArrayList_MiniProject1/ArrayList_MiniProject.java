import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_MiniProject{
    public static void main(String[] args) {

        // Create an ArrayList to store student names
        ArrayList students = new ArrayList();

        // Adding 5 elements
        students.add("Cherinet");
        students.add("Abel");
        students.add("Sami");
        students.add("Marta");
        students.add("Yonatan");

        System.out.println("Initial Student List: " + students);
        System.out.println();

        // Using Iterator to print all names
        System.out.println("Printing names using Iterator:");
        Iterator it = students.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        // Get element by index
        System.out.println("Student at index 2: " + students.get(2));

        // Update element using set()
        students.set(1, "Bereket");
        System.out.println("After updating index 1: " + students);

        // Remove one name by value
        students.remove("Marta");
        System.out.println("After removing 'Marta': " + students);

        // NEW FEATURE: Insert name at a specific index
        students.add(1, "Hana");
        System.out.println("After inserting 'Hana' at index 1: " + students);

        // NEW FEATURE: Remove by index
        students.remove(2); // removes element at index 2
        System.out.println("After removing element at index 2: " + students);

        // Check if a student exists
        System.out.println("Is Sami in the list? " + students.contains("Sami"));

        // List size
        System.out.println("Total Students: " + students.size());

        // Clear the whole list
        students.clear();
        System.out.println("List after clear(): " + students);
    }
}
