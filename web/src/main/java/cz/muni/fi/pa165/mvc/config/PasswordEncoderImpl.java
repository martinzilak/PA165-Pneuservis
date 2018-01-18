package cz.muni.fi.pa165.mvc.config;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */

@Component
public class PasswordEncoderImpl implements PasswordEncoder {
//
//    private static final PasswordEncryptor encryptor = new BasicPasswordEncryptor();

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
//        return encryptor.checkPassword(rawPassword.toString(), encodedPassword);
    }
}
