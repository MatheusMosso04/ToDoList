package br.com.matheusmosso.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface IUserRepository extends JpaRepository<UserModel, UUID>{ 
    //Feito um repositório que representa uma classe, nesse caso o UserModel que seria nossa entidade, depois é passado o parâmetro que a entidade tem que seria o UUID
    
    UserModel findByUsername(String username);

}
