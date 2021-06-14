package com.newlecture.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	//인증 필요한 경로
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/admin/notice/list").hasAnyRole("ADMIN")
				.antMatchers("/admin/notice/detail").hasAnyRole("ADMIN")
				.and() // 경로 설정 끝냄
			.formLogin() //권한x일때 로그인페이지로
				.loginPage("/member/login")
				.and()
			.csrf() //csrf설정
				.disable(); //끄겠다

	}
	
	//인증위해 사용될 데이터베이스정보
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			//사용자 정보를 가져오기
			.usersByUsernameQuery("select uid id, pwd password, 1 enabled from Member where uid=?")
			//그 사용자의 역할 정보를 가져오기
			//.authoritiesByUsernameQuery("select uid id, 'ROLE_ADMIN' roleId from Member where uid =?");
			.authoritiesByUsernameQuery("select m.uid id, r.name roleId "
					+ "from Member m "
					+ "join MemberRole mr on m.id= mr.memberId "
					+ "		join Role r on r.id = mr.roleId "
					+ "where m.uid=?");
			
		
		//데이터베이스 사용x 인증정보 직접기록
//		auth
//			.inMemoryAuthentication()
//			.withUser("newlec")
//				.password("{noop}111")
//				.roles("ADMIN","TEACHER")
//				.and()
//			.withUser("dragon")
//				.password("{noop}111")
//				.roles("STUDENT");
//				.and()
//			.passwordEncoder(new BCryptPasswordEncoder()); //패스워드 인코더
	}
}
