package Users;

public class Customer {

    private String email;
    private String f_name;
    private String l_name;
    private String phone;
    private String age;
    private String weight;
    private String height;
    private String sex;

    public Customer(String email, String f_name, String l_name, String phone, String age, String weight, String height, String sex) {
        this.email = email;
        this.f_name = f_name;
        this.l_name = l_name;
        this.phone = phone;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
