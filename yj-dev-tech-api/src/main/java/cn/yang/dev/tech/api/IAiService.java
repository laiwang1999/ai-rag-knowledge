package cn.yang.dev.tech.api;

import org.springframework.ai.chat.ChatResponse;
import reactor.core.publisher.Flux;

/**
 * @version v1.0
 * @ClassName: cn.yang.dev.tech.api
 * @Description: TODO
 * @Author: YJ
 */
public interface IAiService {
    ChatResponse generate(String model, String message);

    Flux<ChatResponse> generateStream(String model, String message);
}
