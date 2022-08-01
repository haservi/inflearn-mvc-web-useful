package hello.upload.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.core.io.Resource;

import java.util.List;

@Data
public class Item {

    private Long id;

    private String itemName;

    private UploadFile attachFile;

    private List<UploadFile> imageFiles;

    @JsonIgnore
    private List<String> imagePathList;

}
