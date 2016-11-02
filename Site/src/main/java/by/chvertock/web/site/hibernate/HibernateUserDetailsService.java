package by.chvertock.web.site.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.chvertock.web.site.service.user.UserService;

@Service
public class HibernateUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        HibernateUserDetails userDetails;
        try {
            userDetails = new HibernateUserDetails(userService.findByName(username));
        } catch (NullPointerException ex) {
            throw new UsernameNotFoundException(ex.getMessage());
        }catch (Exception ex ) {
            throw new UsernameNotFoundException(ex.getMessage());
        }

        return userDetails;
    }
}
