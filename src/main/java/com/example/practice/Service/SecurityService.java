package com.example.practice.Service;

import com.example.practice.Repository.MemberRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;

@Service
public class SecurityService {
    private static final String SECRET_KEY = "fmsdaklfmklsadfmkldsafmkldsamfldksafmklsadfmlkadsmfklasdmfkal";

    private final MemberRepository memberRepository;

    @Autowired
    public SecurityService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String createToken(String subject, long expTime){
        if(expTime <= 0){
            throw new RuntimeException("Exptime is less then 0");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(subject)
                .signWith(signatureAlgorithm,signingKey)
                .setExpiration(new Date(System.currentTimeMillis() + expTime))
                .compact();
    }
}