package com.jwt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyFilter3 implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        // 토큰 : cos -> id,pw 정상적으로 들어와서 로그인이 완료되면 토큰을 만들어주고 그걸 응답해준다.
        // 요청할 떄마다 Header에 Authorization에 value 값으로 토큰을 가지고 옴
        // 그떄 토큰이 넘어오면 이 토큰이 내가 만든 토큰이 맞는지만 검증만 하면 됨. ( RSA , HS256 )

        if (req.getMethod().equals("POST")) {
            System.out.println("post 요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println("headerAUth = " + headerAuth);

            if (headerAuth.equals("cos")) {
                filterChain.doFilter(req, res);
            }else{
                System.out.println("필터 1");
                PrintWriter out = res.getWriter();
                out.println("인증안됨");
            }

        }


    }
}
