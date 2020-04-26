package lk.pathum.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JwtTokenEnhancer implements TokenEnhancer {


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Authentication authentication1 = authentication.getUserAuthentication();
        if (authentication1 != null){
            Object userPrincipal = authentication.getUserAuthentication().getPrincipal();
            if ( userPrincipal instanceof UserDetails){
                System.out.println(userPrincipal);
                Map<String, Object> additionalInfo = new HashMap<>();
                additionalInfo.put("user_role", ((UserDetails) userPrincipal).getAuthorities());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            }
        }

        return accessToken;
    }
}
