package com.example.demo.config;

import com.example.demo.dto.CustomUserDetails;
import com.example.demo.service.Impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer // mana shu qismlar bizga token berish uchun ishlatiladi
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;
    private final CustomUserDetailsService userDetailsService;

    public AuthorizationServerConfig(AuthenticationManager authenticationManager, BCryptPasswordEncoder passwordEncoder,
                                     CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Value("${spring.security.oauth2.resourceserve.jwt.signing-key}")
  private String jwtSigningKey;

    @Override // endpoint bu URL da bu o'shani configuratsiyasi
    //ya'ni kirib kelib tokenni  qana qilib olib ketish kerak,
    // tokenni olib ketilishiga nimalar nastroyka bo'lishi kerak
    //endpointga beriladigan to'rttta narsa bor 1(tokenstore)>>bu tiokenlarni saqlash joyi
    //Client boshqa User boshqa narsadir

    public void

    configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                 .accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("web")
                .secret(passwordEncoder.encode("Yy5jruBmmWTjDDj6"))
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("read", "write")
                .resourceIds("api");
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter()

    {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(jwtSigningKey);
        return converter;// java obyektni tokennga aylantiradigan konverter
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        return tokenServices;


    }


}
