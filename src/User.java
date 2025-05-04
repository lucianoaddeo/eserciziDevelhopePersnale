public class User {
    private String nome;
    private int età;

    //costruttore di default
    public User(){
        età = 0;
        nome = "Anonimo";
    }

    //getter e setter
    public int getEtà() {return età;}
    public void setEtà(int età) {this.età = età;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public void stampaDettagli(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "età=" + età +
                ", nome='" + nome + '\'' +
                '}';
    }
}
