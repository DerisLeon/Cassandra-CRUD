package crud.cassandra;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import java.util.List;


public class App {
    
    public static void main(String[] args){
    
    Cluster cluster = null;
    
    
    //CONEXÃO
    try {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect("crud");
        MappingManager mappingManager = new MappingManager(session);
        
        Mapper<Pessoa> pessoaMapper = mappingManager.mapper(Pessoa.class);
        
        long tempoInicial = System.currentTimeMillis();
        //CREATE
        pessoaMapper.save(new Pessoa(4,"222.222.222-22", "José Barros", LocalDate.fromYearMonthDay(1973, 10 , 16), List.of("Java, HTML, CSS, JS, PostgresSQL, SpringBoot")));
        
        
        //READ
        System.out.println("\nPessoas Cadastradas: ");
        System.out.println(pessoaMapper.get(1));
        
        
        //UPDATE
        PreparedStatement preparedStatement = session.prepare("UPDATE pessoa SET nome = ? WHERE id = ?");
        BoundStatement boundStatement = preparedStatement.bind("Déris Leôn", 1);
        session.execute(boundStatement);
        System.out.println("\n\nPessoa Atualizada: " + pessoaMapper.get(1));
        
        
        
        //DELETE
        pessoaMapper.delete(4);
        System.out.println("Pessoa Deletada!");
        
        long tempoFinal = System.currentTimeMillis();
        System.out.printf("\nTempo de execução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);   
        
        
    }catch(Exception err){   
        err.printStackTrace();
    
    }finally{
        if(cluster != null) cluster.close();
    }
   
}
}
