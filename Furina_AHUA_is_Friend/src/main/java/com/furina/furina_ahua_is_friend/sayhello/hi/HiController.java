package com.furina.furina_ahua_is_friend.sayhello.hi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    private static final String message = "在一个遥远的小村庄里，住着一位名叫小明的年轻人。小明是村里最勤奋的农民之一，每天都会在田地里辛勤劳作，种植各种农作物来维持他的生计。\n" +
            "\n" +
            "然而，尽管小明勤劳，但他的田地却始终收成不佳。每年的庄稼都生长缓慢，收成甚微，村里人都开始怀疑小明的农业技能。\n" +
            "\n" +
            "有一天，小明决定去寻求帮助。他听说村庄外有一位传说中的农业大师，据说他拥有着神秘的种植技巧，可以让庄稼长得更加茁壮。\n" +
            "\n" +
            "于是，小明踏上了寻找农业大师的旅程。在漫长而艰辛的旅途中，他经历了许多困难和挑战，但他心中的信念始终坚定。\n" +
            "\n" +
            "最终，小明来到了传说中的农业大师的家门前。农业大师是一位年迈的老人，他用和蔼的笑容迎接了小明，并且愿意传授他自己的种植技巧。\n" +
            "\n" +
            "在农业大师的指导下，小明学会了如何选择适合的种子、合理施肥、科学浇水等种植技巧。他将这些技巧带回到家乡，开始在自己的田地里实践。\n" +
            "\n" +
            "经过一番努力，小明的庄稼终于长势喜人，收成也比以往好了许多。村里的人们对小明的敬佩之情更加深厚，他成为了村中一个备受尊敬的人物。\n" +
            "\n" +
            "小明用他的勤劳和努力，改变了自己的命运，也为村庄带来了新的希望和活力。他的故事成为了村民们口口相传的传奇，激励着每一个人勇往直前，追求梦想。\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n";
    private static int currentIndex = 0;

    @GetMapping("/sayhi")
    public String hi() {
        // 返回一个空的HTML页面，用于显示对话框
        currentIndex = 0;
        return "<html><body><div id='dialog'></div><script>refreshDialog(); function refreshDialog() { setInterval(function() { fetch('/hi/refresh').then(response => response.text()).then(data => document.getElementById('dialog').innerHTML = data); }, 1000); }</script></body></html>";
    }

    @GetMapping("/hi/refresh")
    public String hirefresh() {
        // 每次发送一段字符串，扫描到换行符就发送一个substring
        int nextIndex = message.indexOf("\n", currentIndex);
        if (nextIndex != -1) {
            String subMessage = message.substring(currentIndex, nextIndex);
            currentIndex = nextIndex + 1; // 跳过换行符
            return subMessage;
        } else {


            return message.substring(currentIndex )+"/n 故事讲完了";
        }


    }
}

///**"""static {
//        // 从文件中读取消息内容
//        StringBuilder content = new StringBuilder();
//        try {
//            ClassPathResource resource = new ClassPathResource("book.txt");
//            BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                content.append(line);
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        message = content.toString();
//    }
//
//""*/
//*?
