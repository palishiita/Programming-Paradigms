package Lab7.Task5;

import java.util.Objects;

public class User {

    private final int id;
    private final String name;
    private final String email;
    private final String mobile;

    public User(int user_id, String user_name, String user_email, String user_mobile) {
        id = user_id;
        name = user_name;
        email = user_email;
        mobile = user_mobile;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User user)) return false;
        return getId() == user.getId()
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getEmail(), user.getEmail())
                && Objects.equals(getMobile(), user.getMobile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getMobile());
    }
}
