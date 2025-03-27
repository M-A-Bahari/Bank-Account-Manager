/**
 * Represents a user profile in the banking system.
 * Stores personal details like name, date of birth, and a unique user ID.
 * 
 * @author Md Ataullah Bahari
 */
public class User {
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String dob;
    private final String userId;

    public User(String username, String firstName, String lastName, String dob, String userId) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getUserId() {
        return userId;
    }
}
