package Users;

import java.util.Objects;

public class Admin {
    private String email;
    private String f_name;
    private String l_name;
    private String password;
    static int isAdmin;
    private String token;

    public Admin(String email, String f_name, String l_name, String password, String token, int isAdmin) {
        this.email = email;
        this.f_name = f_name;
        this.l_name = l_name;
        this.password = password;
        this.token = token;
        Admin.isAdmin = isAdmin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = "Admin123";
    }

    public static int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = 1;
    }
}
