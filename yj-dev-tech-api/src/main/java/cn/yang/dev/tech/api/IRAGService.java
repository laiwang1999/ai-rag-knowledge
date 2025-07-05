package cn.yang.dev.tech.api;

import cn.yang.dev.tech.api.response.Response;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @version v1.0
 * @ClassName: cn.yang.dev.tech.api
 * @Description: TODO
 * @Author: YJ
 */
public interface IRAGService {
    Response<List<String>> queryRagTagList();
    Response<String> uploadFile(String ragTag,List<MultipartFile> files);
}
