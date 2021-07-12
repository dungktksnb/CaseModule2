import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private  String passWord;
    private  String userName;

    public TaiKhoan() {
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "DangNhap{" +
                "passWord='" + passWord + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
