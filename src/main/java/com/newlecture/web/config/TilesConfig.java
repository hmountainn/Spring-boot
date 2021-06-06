package com.newlecture.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

//Bean Container : IoC Container
@Configuration // 구성요소: 스프링 어플리케이션을 구성하는 객체
public class TilesConfig {
	
	@Bean //반환값을 Bean Container에 담아줌
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer conf = new TilesConfigurer();
		conf.setDefinitions(new String[] {
				"/WEB-INF/tiles.xml"
		});
		
		return conf;
	}
	
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
		
		TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(1);
		
		return resolver;
	}

}
