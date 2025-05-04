public class PersonBuilder {
    //perché final?
    private final String firstName;
    private final String lastName;
    private String address;
    private int age;

    // Nome e cognome obbligatori, quindi dichiaro un costruttore che inizializza questi due campi
    public PersonBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //metodi per impostare singolarmente i valori dei campi opzionali,
    //ritornano tutti il riferimento allo stesso oggetto
    public PersonBuilder setAddress(String address){
        this.address = address;
        return this;
    }
    public PersonBuilder setAge(int age){
        this.age = age;
        return this;
    }

    // Getter necessari per Person
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public int getAge() { return age; }

    // Metodo per costruire Person, usa il costruttore parametrizzato Person(PersonBuilder)
    public Person build() {
        return new Person(this);
    }
}
