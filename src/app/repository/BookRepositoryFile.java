package app.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import app.domain.Book;
import java.io.BufferedReader;
import java.io.FileReader;

@Primary
@Repository
public class BookRepositoryFile implements BookRepository{

    @Override
    public Book getById(Long id) {
        try(BufferedReader reader = new BufferedReader(new FileReader("database.txt"))){
            return reader.lines()
                    .filter(x -> x.split(";", 2)[0].equals(id.toString()))
                    .limit(1)
                    .map(x -> {
                        String[] values = x.split(";");
                        int year = Integer.parseInt(values[3]);
                        return new Book(id, values[1], values[2], year, values[4]);
                    })
                    .findFirst()
                    .orElse(null);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
