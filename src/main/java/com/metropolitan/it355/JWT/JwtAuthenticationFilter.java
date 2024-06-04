package com.metropolitan.it355.JWT;

import com.metropolitan.it355.auth.TokenBlackListService;
import com.metropolitan.it355.entity.User;
import com.metropolitan.it355.service.UserService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;
    private final TokenBlackListService tokenBlackListService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws JwtException, IOException, ServletException {
        try {
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                filterChain.doFilter(request, response);
                return;
            }

            String jwt = authHeader.split(" ")[1];
            if (tokenBlackListService.isTokenBlacklisted(jwt)) {
                extracted(response, "Please login - Token blacklisted");
                return;
            }

            String username = jwtService.extractUsername(jwt);
            User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authToken);
            filterChain.doFilter(request, response);
        } catch (JwtException e) {
            extracted(response, e.getMessage());
        }
    }

    private static void extracted(HttpServletResponse response, String s) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"" + s + "\"}");
        response.getWriter().flush();
        response.getWriter().close();
    }
}
