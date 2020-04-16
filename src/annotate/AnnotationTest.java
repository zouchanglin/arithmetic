package annotate;

public class AnnotationTest {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        person.setName("AA");
        person.setAge(10);
        person.setId("001");

        String validateField = LengthValidator.validateField(person);
        if(validateField == null)
            System.out.println(person);
        else
            System.out.println(validateField);
    }
}
