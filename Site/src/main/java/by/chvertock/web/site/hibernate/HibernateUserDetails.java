package by.chvertock.web.site.hibernate;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import by.chvertock.web.site.model.entities.Role;
import by.chvertock.web.site.model.entities.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HibernateUserDetails implements UserDetails {

    private static final long serialVersionUID = 6677433899531694797L;
    
    private User user;

    HibernateUserDetails(User user) throws NullPointerException {
        if (user == null) {
            throw new NullPointerException();
        }
        this.user = user;
    }  

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getType().name()));
        }
        return authorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "HibernateUserDetails{" +
                "user=" + user +
                '}';
    }
}
