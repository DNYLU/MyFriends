public class Friend {
    private String name;
    private int phone;
    private String email;

    public Friend(String name, int phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return this.name;
    }
}
