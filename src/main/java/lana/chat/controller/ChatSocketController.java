package lana.chat.controller;

import lana.chat.model.Msg;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class ChatSocketController {
    @MessageMapping("/{groupId}")
    @SendTo("/group/{groupId}")
    public Msg sendMsg(
                       @DestinationVariable("groupId") String groupId,
                       @ModelAttribute Msg msg) {
        return new Msg(msg.getUsername(), msg.getContent());
    }
}
