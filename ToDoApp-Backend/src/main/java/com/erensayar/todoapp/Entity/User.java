package com.erensayar.todoapp.Entity;

import com.erensayar.todoapp.ViewModel.Views;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

/**
 * @author erensayar
 */
//@ToString(exclude = "note")
@Data
@Entity
@ApiModel(value = "User Model")
public class User implements UserDetails {

    //<============================================>
    @Id
    @GeneratedValue
    @JsonView(Views.Base.class)
    private Integer id;

    @NotNull(message = "{todoapp.constraint.username.NotNull.message}")
    @Size(min = 4, max = 255, message = "{todoapp.constraint.username.Size.message}")
    @Column(unique = true)
    @JsonView(Views.Base.class)
    private String username;

    @NotNull(message = "{todoapp.constraint.password.NotNull.message}")
    @Size(min = 8, max = 255, message = "{todoapp.constraint.password.Size.message}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{todoapp.constraint.password.Pattern.message}")
    @JsonView(Views.Sensitive.class)
    private String password;

    @JoinColumn(name = "note_user_id")
    @OneToMany()//fetch = FetchType.EAGER
    @JsonView(Views.Note.class)
    List<Note> note;

    //<============================================>

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_user");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    //<============================================>
}
