package com.example.soloproject.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class WeatherApiTest {

    @Value("${spring.weather.encId}")
    private String encId;

    @Value("${spring.weather.decId}")
    private String decId;

    @Value("${spring.weather.url}")
    private String url;

    @Autowired
    WeatherApi weatherApi;

    @DisplayName("1. Movie Api Test ")
    @Test
    void test_1() {

        URI uri = UriComponentsBuilder
                .fromUriString(url)
                .queryParam("serviceKey", encId)
                .queryParam("pageNo", "1")
                .queryParam("numOfRows", "10")
                .queryParam("dataType", "JSON")
                .queryParam("base_date", "20221017")
                .queryParam("base_time", "0600")
                .queryParam("nx", "123")
                .queryParam("ny", "23")
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .headers(headers)
                .build();

        ResponseEntity<String> response = restTemplate
                .exchange(req, String.class);

        log.info("Map : {} ", response);


    }

    @DisplayName("2. JSON")
    @Test
    void test_2() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey",StandardCharsets.UTF_8) + "="+encId); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8)); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("JSON", StandardCharsets.UTF_8)); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("20221017", StandardCharsets.UTF_8)); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("0500", StandardCharsets.UTF_8)); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("55", StandardCharsets.UTF_8)); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny",StandardCharsets.UTF_8) + "=" + URLEncoder.encode("127", StandardCharsets.UTF_8)); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
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
        Map<String, Object> body = (Map<String, Object>) response.get("body");
        Map<String,Object> items = (Map<String, Object>) body.get("items");
        List<Object> list = (List<Object>) items.get("item");

        for (int i = 0; i < list.size(); i++) {
            log.info("List : {}",list.get(i));
        }


    }

    @DisplayName("3. Sysdate")
    @Test
    void test_5(){

        SimpleDateFormat now = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();

        String strToday = now.format(c1.getTime());

    log.info(strToday);


    }



}