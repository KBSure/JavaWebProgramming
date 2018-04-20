package examples.boot.simpleboard.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebApplicationSecurity  extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    SimpleBoardTokenRepositoryImpl simpleBoardTokenRepositoryImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //좁게 좁게 처리하고(디테일하게) 마지막에 넓게 막는 것

        //순서대로 체크하기 때문에 순서 중요
        //hasRole이 permitAll보다 먼저 와야 하는 경우 존재
        http
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/boards").and()
                .authorizeRequests()
                //Ant라는 빌드 도구의 path를 지정하는 문법 -> **는 경로 이하 모든 ~
                .requestMatchers(new AntPathRequestMatcher("/**.html")).permitAll()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/css/**").permitAll()
                //permitAll -> 어떤 권한이라도 받아들여라
                .antMatchers("/boards/writeform").hasRole("USER")
                .antMatchers("/boards/**").permitAll()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
//               여기부터
                .antMatchers("/h2-console/**").permitAll()
                //h2에 접근할 수 있는 웹페이지가 자동으로 제공이 된다.
                .anyRequest().fullyAuthenticated()
                // 설정 안한 경로에 대해서는 권한 처리
                .and()
                .csrf().ignoringAntMatchers("/**")
//                .ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().disable()
//                여기까지 h2 콘솔 관련 설정
                .and().formLogin()
//                .and().rememberMe().tokenRepository(simpleBoardTokenRepositoryImpl).rememberMeParameter("remember-me").tokenValiditySeconds(1209600)
                .and().logout().permitAll();
    }

}