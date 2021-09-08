package com.mackenzie.SpringData.service;

import com.mackenzie.SpringData.dao.UsuarioDao;
import com.mackenzie.SpringData.domain.Rol;
import com.mackenzie.SpringData.domain.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = dao.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        var roles = new ArrayList<GrantedAuthority>();

        for (Rol rol: usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        }

        return new User(usuario.getName(), usuario.getPass(), roles);

    }
}
