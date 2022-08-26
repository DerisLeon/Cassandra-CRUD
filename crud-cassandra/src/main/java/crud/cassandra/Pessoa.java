package crud.cassandra;
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import java.util.List;


@Table(keyspace = "crud", name = "pessoa")
public class Pessoa {
    
    @PartitionKey
    private int id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private List<String> formacao;
    
    public Pessoa(){
    }

    public Pessoa(int id,String cpf, String nome, LocalDate nascimento, List<String> formacao) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.formacao = formacao;
    }
    
    @PartitionKey
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public List<String> getFormacao() {
        return formacao;
    }

    public void setFormacao(List<String> formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", nascimento=" + nascimento + ", formacao=" + formacao + '}';
    }

   
    
}
