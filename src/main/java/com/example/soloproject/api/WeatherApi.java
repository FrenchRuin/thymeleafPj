package com.example.soloproject.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WeatherApi {

    @Value("${spring.weather.encId}")
    private String encId;

    @Value("${spring.weather.url}")
    private String url;

    public Map<String, Object> search() throws IOException {

        /* Sysdate */
        SimpleDateFormat now = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        String sysdate = now.format(calendar.getTime());

        StringBuilder urlBuilder = new StringBuilder(url); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey",StandardCharsets.UTF_8) + "="+encId); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("10", StandardCharsets.UTF_8)); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("JSON", StandardCharsets.UTF_8)); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date", StandardCharsets.UTF_8) + "=" + URLEncoder.encode(sysdate, StandardCharsets.UTF_8)); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("0500", StandardCharsets.UTF_8)); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("126", StandardCharsets.UTF_8)); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("37", StandardCharsets.UTF_8)); /*예보지점의 Y 좌표값*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String,Object> map = mapper.readValue(sb.toString(), HashMap.class);

        Map<String, Object> response = (Map<String, Object>) map.get("response");

        return (Map<String, Object>) response.get("body");
    }
}
