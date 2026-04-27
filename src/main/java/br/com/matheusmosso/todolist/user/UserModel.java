package br.com.matheusmosso.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data //Lib do Lombok que permite e cria os gets e sets para os atributos do model
@Entity (name = "tb_users") //Tabela de usuários
public class UserModel {
    
    @Id //ID Jakarta, anotation para ser chave primária
    @GeneratedValue(generator = "UUID") // Gerador do UUID, ID automático
    private UUID id; //UUID, ID de identificação única e é mais seguro que ID sequenciais

    private String username;
    private String name;
    private String password;

    @CreationTimestamp 
    private LocalDateTime createdAt; //Quando um dado for gerado de forma automática, será registrado quando o mesmo foi gerado
}
