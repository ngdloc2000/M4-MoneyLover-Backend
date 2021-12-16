//package com.example.m4moneyloverbackend.service.jwt;
//
//import com.example.m4moneyloverbackend.model.UserPrinciple;
//import io.jsonwebtoken.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//
//// ----------- Lớp tạo ra TOKEN ----------------
//
//@Component
//@Service
//public class JwtService {
//    private static final String SECRET_KEY = "123456789"; // Dựa vào khóa này để mã hóa
//    private static final long EXPIRE_TIME = 10 * 60 * 1000;
//    private static final Logger logger = LoggerFactory.getLogger(JwtService.class.getName());
//
//    // Mã Token được tạo khi đăng nhập thành công
//    public String generateTokenLogin(Authentication authentication) {
//        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
//
//        return Jwts.builder()
//                .setSubject((userPrincipal.getUsername()))
//                .setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME * 1000))
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .compact();
//    }
//
//    // phương thức validateJwtToken được sử dụng để kiểm tra xem token có hợp lệ hay không
//    public boolean validateJwtToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
//            return true;
//        } catch (SignatureException e) {
//            logger.error("Invalid JWT signature -> Message: {} ", e);
//        } catch (MalformedJwtException e) {
//            logger.error("Invalid JWT token -> Message: {}", e);
//        } catch (ExpiredJwtException e) {
//            logger.error("Expired JWT token -> Message: {}", e);
//        } catch (UnsupportedJwtException e) {
//            logger.error("Unsupported JWT token -> Message: {}", e);
//        } catch (IllegalArgumentException e) {
//            logger.error("JWT claims string is empty -> Message: {}", e);
//        }
//        return false;
//    }
//
//    // phương thức getUserNameFromJwtToken được sử dụng để lấy ra username từ trong chuỗi token đã được mã hoá
//    public String getUserNameFromJwtToken(String token) {
//        String userName = Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody().getSubject();
//        return userName;
//    }
//}
