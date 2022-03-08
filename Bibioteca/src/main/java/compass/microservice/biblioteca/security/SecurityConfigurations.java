package compass.microservice.biblioteca.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import compass.microservice.biblioteca.repository.UsuarioRepository;

	@EnableWebSecurity
	@Configuration
	public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private AutenticacaoService autenticacaoService;
		
		@Autowired
		private TokenService tokenService;
		
		@Autowired
		private UsuarioRepository usuarioRepository;
		
		@Override
		@Bean
		protected AuthenticationManager authenticationManager() throws Exception {
			return super.authenticationManager();
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
		}
		
		public static void man(String[]args) {
			System.out.println(new BCryptPasswordEncoder().encode("121212"));
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/biblioteca").permitAll()
			.antMatchers(HttpMethod.GET, "/biblioteca/*").permitAll()
			.antMatchers(HttpMethod.GET,"/livros").permitAll()
			.antMatchers(HttpMethod.GET,"/livros/*").permitAll()
			.antMatchers(HttpMethod.POST, "/auth").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
		}
		
}