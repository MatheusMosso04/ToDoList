package br.com.matheusmosso.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;;

@Component //Anotação necessária para que o springBoot gerencie essa classe
//Para realizar o método abaixo, clicar em cima do FilterTaskAuth e apertar Ctrl + . - Depois Enter, assim o método será implementado junto dos imports.
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            
            //Requisição de autenticação (usuário e senha)
            var authorization = request.getHeader("Authorization");

            var authEncoded = authorization.substring("Basic".length()).trim(); 
            //Substring é utilizado para separar a escrita Basic do base 64 que retornou da autenticação
            //length calcula a quantidade de caracteres da palavra em questão, e o trim retira os espaços em branco
            //Ex: Basic Zasdjflkajlkasj123= - Retira o Basic e o espaço, mantendo apenas o base 64 (Zasdjflkajlkasj123=) para depois ser realizado o decode


            byte[] authDecode = Base64.getDecoder().decode(authEncoded);//Decoder que realiza a conversão do base 64 

            var authString = new String(authDecode);//Converte o decode para uma string

            String[] credentials = authString.split(":"); //String[] - Vetor de string que irá armazenar as credenciais
            //Split é utilizado para realizar a separação do username e senha
            String username = credentials[0]; //Username ficará na posição 0 do vetor de string Credentials
            String password = credentials [1]; //Password na posição 1  

            System.out.println("Authorization");
            System.out.println(username);
            System.out.println(password);    


            //Validação do usuário

            //Validação da senha

            //Segue para as rotas



       
            filterChain.doFilter(request, response);
    }

}
