package hello.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Controller
@RequestMapping("/spring")
public class SpringUploadController {

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/upload")
    public String newFile() {
        return "upload-form";
    }

    @PostMapping("/upload")
    public String saveFile(@RequestParam String itemName, @RequestParam MultipartFile file, HttpServletRequest request) throws IOException {

        log.info("request = {}", request);
        log.info("itemName = {}", itemName);
        log.info("multipartFile = {}", file);

        if (!file.isEmpty()) {

            // 폴더 없으면 생성
            Path uploadFolder = Paths.get(fileDir);
            if (!Files.exists(uploadFolder)) {
                Files.createDirectories(uploadFolder);
            }

            String fullPath = fileDir + File.separator + file.getOriginalFilename();
            // 절대 경로로 변경
            Path path = Paths.get(fullPath).toAbsolutePath();

            log.info("파일 저장 fullPath = {}", path);
            file.transferTo(path.toFile());
        }

        return "upload-form";
    }
}
