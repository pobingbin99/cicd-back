package web.mvc.cicd02_boot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
public class MainController {

    // 배포할 때마다 숫자를 올려서 바뀌었는지 확인
    private static final String VERSION = "v2";

    private static final String STARTED_AT =
            LocalDateTime.now(ZoneId.of("Asia/Seoul"))
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                  <meta charset="UTF-8">
                  <title>CI/CD TEST</title>
                  <style>
                    body {
                      margin: 0; height: 100vh;
                      display: flex; align-items: center; justify-content: center;
                      background: #fffbea;
                      font-family: -apple-system, "Apple SD Gothic Neo", sans-serif;
                      color: #3b3420;
                    }
                    .card {
                      text-align: center;
                      padding: 40px 56px;
                      background: #fff;
                      border: 3px solid #3b3420;
                      border-radius: 28px;
                      box-shadow: 6px 6px 0 #3b3420;
                    }
                    .chick { font-size: 72px; animation: bounce 1s infinite; }
                    @keyframes bounce {
                      0%%, 100%% { transform: translateY(0); }
                      50%% { transform: translateY(-12px); }
                    }
                    h1 { margin: 12px 0 8px; font-size: 26px; }
                    p { margin: 0; color: #8c8260; }
                    .badge {
                      display: inline-block; margin-top: 20px;
                      padding: 6px 16px;
                      background: #a8dbff;
                      border: 2px solid #3b3420;
                      border-radius: 999px;
                      font-weight: 700;
                    }
                    .time { margin-top: 12px; font-size: 13px; }
                  </style>
                </head>
                <body>
                  <div class="card">
                    <div class="chick">🐥</div>
                    <h1>자동 배포 성공!</h1>
                    <p>GitHub Actions가 올려줬어요</p>
                    <div class="badge">%s</div>
                    <p class="time">서버 시작: %s</p>
                  </div>
                </body>
                </html>
                """.formatted(VERSION, STARTED_AT);
    }
}