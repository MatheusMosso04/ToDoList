package br.com.matheusmosso.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Modificadores para classes
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    /**
     * String
     * Integer
     * Double
     * Float
     * Char 
     * Date
     * void - Utilizado quando não se tem retorno no método, apenas deseja que alguma lógica seja executada dentro do método
     */

    @Autowired //Notação para o spring gerenciar o ciclo de vida do Repository
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create (@RequestBody UserModel userModel){
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null){
            //Nesse caso, retorna uma mensagem que o mesmo já existe e seria necessário um status code de erro != 200
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário Existente");
        }

        var passwordHash = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());//12 é a força, necessário verificar em documentação
        //Criação da senha criptografada, é recuperado a senha com o get e utilizado a notação toCharArray para que seja transformado em um array de caracteres

        userModel.setPassword(passwordHash);//Senha é atualizada para a senha criptografada, utilizado o método set para tal

        var userCreated = this.userRepository.save(userModel); //Já aqui o status code é 200 pois é cadastrado o usuário 
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);

    }
}
