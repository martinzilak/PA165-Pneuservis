package cz.muni.fi.pa165.mvc.config;

import dto.CustomerDTO;
import facade.CustomerFacade;
import facade.CustomerFacadeImpl;
import facade.OrderFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import services.CustomerService;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */


@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    
    private static final String CUSTOMER = "CUSTOMER";

    @Inject
    private CustomerFacade customerFacade;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
//            .antMatchers("WHERE").hasAnyRole(CUSTOMER)
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error=invalid_attempt")
            .usernameParameter("user_login").passwordParameter("user_password")
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/login?access_denied")
            .and()
            .csrf().disable();
    }

    @Inject
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new PasswordEncoderImpl();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Martin");
        customerDTO.setEmail("test@email.com");
        customerDTO.setCity("Brno");
        customerDTO.setCountry("CR");
        customerDTO.setOrders(new HashSet<>());
        customerDTO.setPhoneNumber("132456987");
        customerDTO.setSurname("Zilak");
        customerDTO.setZipCode("60200");
        customerDTO.setStreet("Ulicova");
        customerFacade.createCustomer(customerDTO);
        List<CustomerDTO> customers = customerFacade.findAllCustomers();
        for (CustomerDTO customer : customers) {
            auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                .withUser(customer.getEmail())
                .password("test")
                .roles(CUSTOMER);
        }
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        final Properties users = new Properties();
        users.put("user","pass,ROLE_USER,enabled"); //add whatever other user you need
        return new InMemoryUserDetailsManager(users);
    }
}
