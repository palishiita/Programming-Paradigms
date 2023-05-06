package Lab7.Task6;

public class Author {

    private String name;
    private String email;
    private char gender;

    public Author(String author_name, String author_email, char author_gender) {
        name = author_name;
        email = author_email;
        gender = author_gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
