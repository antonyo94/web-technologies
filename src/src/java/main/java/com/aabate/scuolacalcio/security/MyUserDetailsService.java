
package main.java.com.aabate.scuolacalcio.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import main.java.com.aabate.scuolacalcio.model.Ruolo;
import main.java.com.aabate.scuolacalcio.model.Utente;
import main.java.com.aabate.scuolacalcio.repository.UtenteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

    
    
@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	//get user from the database, via Hibernate
	@Autowired
	private UtenteDao userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
	
		Utente user = userDao.findByUsername(username);
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getRoles());

		return buildUserForAuthentication(user, authorities);
		
	}

        private List<GrantedAuthority> buildUserAuthority(List<Ruolo> roles) {
          Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (Ruolo userRole : roles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
        }

        private UserDetails buildUserForAuthentication(Utente user, List<GrantedAuthority> authorities) {
           return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
        }
    }