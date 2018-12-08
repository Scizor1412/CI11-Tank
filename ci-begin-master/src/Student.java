import java.util.Date;

public class Student {
    //attribute
    String name;
    Date birthdate;
    String code;

    //method
    //1. constructor - ham tao
    public Student () {
        this.name = "Nguyen Van A";
        this.birthdate = new Date();
        this.code = "se111212";
    }
    //2. other methods

    public void print() {
        System.out.println(this.name);
        System.out.println(this.birthdate);
        System.out.println(this.code);
    }
}
