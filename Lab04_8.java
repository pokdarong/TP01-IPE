//Create a model following class diagrams and objects
class IT_Student{
    String major = "IT student.";
    String subject = "Computer System And Network.";
    public String ITStudent(){
        return major;
    }
    public String Subject(){
        return subject;
    }
}
class Programming_student extends IT_Student{
    String Prostudent = "Programming student";
    public String Prostudents(){
        return Prostudent;
    }
}
class Telecom_student extends IT_Student{
    String Telstudent = "Telecom student";
    public String Telstudents(){
        return Telstudent;
    }
}
public class Lab04_8 {
    public static void main(String[] args) {
        Programming_student programming_student = new Programming_student();
        Telecom_student telecom_student = new Telecom_student();
        System.out.println(programming_student.Prostudents() + " is a " + programming_student.ITStudent());
        System.out.println("He is learning " + programming_student.Subject());
        System.out.println();
        System.out.println(telecom_student.Telstudents() + " is a " + telecom_student.ITStudent());
        System.out.println("She is learning " + telecom_student.Subject());
    }
}
