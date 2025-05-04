public class Person {
    private String firstName, lastName, address;
    private int age;



    //costruttore parametrizzato che assegna i valori ai campi con la classe builder
    public Person(PersonBuilder builder) {
        this.firstName=builder.getFirstName();
        this.lastName=builder.getLastName();
        this.address = builder.getAddress();
        this.age = builder.getAge();
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address='" + address + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
