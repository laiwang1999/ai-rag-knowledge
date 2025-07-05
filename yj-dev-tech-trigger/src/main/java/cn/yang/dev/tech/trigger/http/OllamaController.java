package cn.yang.dev.tech.trigger.http;

import cn.yang.dev.tech.api.IAiService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/ollama")
@Slf4j
public class OllamaController implements IAiService {
    @Resource
    private OllamaChatClient ollamaChatClient;
    /**
     * 普通
     * <a href="http://localhost:8090/api/v1/ollama/generate?model=deepseek-r1:1.5b&message=hi">...</a>
     *
     * @param model 模型（deepseek-r1:1.5b）
     * @param message 信息
     * @return 返回结果
     */
    @Override
    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public ChatResponse generate(@RequestParam String model, @RequestParam String message) {
        return ollamaChatClient.call(new Prompt(message, OllamaOptions.create().withModel(model)));
    }

    /**
     * 流式
     * <a href="http://localhost:8090/api/v1/ollama/generateStream?model=deepseek-r1:1.5b&message=hi">...</a>
     *
     * @param model 模型（deepseek-r1:1.5b）
     * @param message 信息
     * @return 返回结果
     */
    @Override
    @RequestMapping(value = "/generate_stream", method = RequestMethod.GET)
    public Flux<ChatResponse> generateStream(@RequestParam String model, @RequestParam String message) {
        log.info("generateStream - 流式输出开始 model:{} message:{}",model,message);

        return ollamaChatClient.stream(new Prompt(message, OllamaOptions.create().withModel(model)));
    }
}
