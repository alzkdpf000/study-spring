package com.example.threetier.service;

import com.example.threetier.dto.MemberDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@Service
public class KaKaoService {

    public String getKakaoAccessToken(String code) {
        String accessToken = null;
        String requestURI = "https://kauth.kakao.com/oauth/token";

        URL url = null;
        try {
            url = new URL(requestURI);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            StringBuilder stringBuilder = new StringBuilder();
            BufferedWriter bufferedWriter = null;

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            stringBuilder.append("grant_type=authorization_code");
            stringBuilder.append("&client_id=3ebb02ebe2a0366ed7f138a9c5e23053");
            stringBuilder.append("&redirect_uri=http://localhost:10000/kakao/login");
            stringBuilder.append("&code=").append(code);

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();

            if(connection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                JsonElement jsonElement = JsonParser.parseString(result);
                accessToken = jsonElement.getAsJsonObject().get("access_token").getAsString();

                bufferedReader.close();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return accessToken;
    }

    public Optional<MemberDTO> getKakaoInfo(String token){
        String requestURI = "https://kapi.kakao.com/v2/user/me";
        MemberDTO memberDTO = null;

        try {
            URL url = new URL(requestURI);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            StringBuilder stringBuilder = new StringBuilder();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Bearer " + token);

            if(connection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                String result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                JsonElement jsonElement = JsonParser.parseString(result);
                JsonElement kakaoAccount = jsonElement.getAsJsonObject().get("kakao_account").getAsJsonObject();
                JsonElement profile = kakaoAccount.getAsJsonObject().get("profile");

                memberDTO = new MemberDTO();
                memberDTO.setKakaoEmail(kakaoAccount.getAsJsonObject().get("email").getAsString());
                memberDTO.setMemberName(profile.getAsJsonObject().get("nickname").getAsString());
//                썸네일: thumbnail_image_url
//                원본: profile_image_url
                memberDTO.setKakaoProfileUrl(profile.getAsJsonObject().get("thumbnail_image_url").getAsString());

                bufferedReader.close();
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(memberDTO);
    }
}











