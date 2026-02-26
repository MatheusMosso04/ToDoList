package br.com.matheusmosso.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/")
    public void create (@RequestBody UserModel UserModel){
        System.out.println(UserModel.getUsername());
    }
}
