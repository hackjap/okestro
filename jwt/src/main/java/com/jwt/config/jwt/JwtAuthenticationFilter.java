package com.jwt.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwt.config.auth.PrincipalDetails;
import com.jwt.model.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;

// 스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있음
// /login 요청해서 username, password 전송하면 ( Post )
// UsernamePasswrodAUthenticationFilter 가 동작함
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;



    // /login 요청을 하면 로그인 시도를 위해서 실행되는 함수
    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthentiactinoFilter : 로그인 시도중");

        // 1. username, password 받아서

/*      자바를 통한 수동 파싱
        BufferedReader br = request.getReader();
        String input = null;
        while((input = br.readLine()) != null) {
            System.out.println("input = " + input);
        }
        System.out.println(request.getInputStream().toString());*/

        // 파싱
        ObjectMapper om = new ObjectMapper();
        User user = om.readValue(request.getInputStream(), User.class);
        System.out.println("user = " + user);

        // 토큰 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        // PrincipalDetailsService loadByUsername() 함수 실행된 후 정상이면 authenticatinon이 리턴됨
        // DB에 있는 username과 password가 일치한다.
        Authentication authentication =
                authenticationManager.authenticate(authenticationToken);

        //  => 로그인이 되었다는 뜻
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("로그인 완료  :  " + principalDetails.getUser().getUsername());
        // authentication 객체가 session 영역에 저장을 해야하고 그 방법이 return 해주면 됨.
        // 리턴의 이유는 권한 관리를 security가 대신 해주기 떄문에 편하려고 하는 것
        // 굳이 JWT 토큰을 사용하연서 세션을 만들 이유가 없음 근데 단지 권한 처리 떄문에 sesssion에 넣어준다.


        // authentication 객체가 session 영역에 저장됨.
        return authentication;
        //        return super.attemptAuthentication(request, response);
    }

    // attemptAuthentication 실행 후 인증이 정상적으로 되있으면 이 함수가 실행됨
    // JWT 토큰을 만들어서 request 요청한 사용자에게 JWT 토큰을 response 해주면 됨.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentication 실행됨 : 인증완료이 되었다는 뜻.");
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

        // RSA 방식이 아닌 Hash 암호 방식
        String jwtToken = JWT.create()
                .withSubject("cos token") // 토큰 명
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000 * 10))) // 만료시간 : 10분              .withClaim("id",principalDetails.getUser().getId())
                .withClaim("username", principalDetails.getUser().getId()) // 담고싶은 값 ( 필수는 아님 )
                .withClaim("username", principalDetails.getUser().getUsername())
                .sign(Algorithm.HMAC512("cos"));  // secret

        response.addHeader("Authorization","Bearer " + jwtToken);




    }
}


// 2. 정상인지 로그인 시도를 해봄.
// authenticationManger로 로그인 시도를 하면 PrincipalDetailsService가 호출 -> loadUserByUsernamer() 가 실행

// 3. PrincipalDetails를 세션에 담고(권한 관리를 위해서)

// 4. JWT 토큰을 만들어서 응답해주면 됨.