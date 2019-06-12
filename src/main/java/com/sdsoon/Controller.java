package com.sdsoon;

import com.sdsoon.client.ClientHandler;
import com.sdsoon.client.RequestPacket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tio.core.Tio;

import java.io.UnsupportedEncodingException;

import static com.sdsoon.client.ClientStarter.clientChannelContext;

/**
 * Created By Chr on 2019/4/28.
 */
@RestController
@RequestMapping("/tio")
public class Controller {

    //心跳
    @RequestMapping(value = {"/heart"}, method = RequestMethod.GET)
    public String show2() throws UnsupportedEncodingException {
        RequestPacket requestPacket = new RequestPacket();
        String ss = "ABBA00000010506A1C00500300000118013701502493".trim();
        byte[] bytes = ClientHandler.hexToByteArray(ss);
        requestPacket.setBody(bytes);

        Tio.bindUser(clientChannelContext, "client-01");
        Tio.send(clientChannelContext, requestPacket);
        return "suc:heart";
    }

    //时间
    /**
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = {"/time"}, method = RequestMethod.GET)
    public String show1() throws UnsupportedEncodingException {
        RequestPacket requestPacket = new RequestPacket();

        String ss = "97790000000F501000000004082019061109280702";
        byte[] bytes = ClientHandler.hexToByteArray(ss);
        requestPacket.setBody(bytes);


//            Tio.bindUser(clientChannelContext, "tio-client-01");
        Tio.bindUser(clientChannelContext, "client-01");
        Tio.send(clientChannelContext, requestPacket);
        return "suc:time";

    }

    //###############控制
    //灯全开
    @RequestMapping(value = {"/1234"}, method = RequestMethod.GET)
    public String show5() throws UnsupportedEncodingException {
        RequestPacket requestPacket = new RequestPacket();
        String ss = "977900000009500F00100010020F00";
        byte[] bytes = ClientHandler.hexToByteArray(ss);
        requestPacket.setBody(bytes);
        Tio.bindUser(clientChannelContext, "client-01");
        Tio.send(clientChannelContext, requestPacket);
        return "suc:on";
    }

    //###############关闭
    @RequestMapping(value = {"/12", ""}, method = RequestMethod.GET)
    public String show3() throws UnsupportedEncodingException {
        RequestPacket requestPacket = new RequestPacket();
        String ss = "977900000009500F00100010020000";
        byte[] bytes = ClientHandler.hexToByteArray(ss);
        requestPacket.setBody(bytes);
        Tio.bindUser(clientChannelContext, "client-01");
        Tio.send(clientChannelContext, requestPacket);
        return "suc:1-";
    }


    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    /**
     * 当 ByteBuffer.remaining()  小于要读取或写入的长度时，再执行读取或写入操作都会产生异常；
     * <p>
     * 读取则产生 java.nio.BufferUnderflowException 异常，
     * <p>
     * 写入则产生 java.nio.BufferOverflowException 异常。
     * <p>
     * 当 ByteBuffer.remaining()  等于 0 时，不能再执行读取或写入操作，需要执行：clear() 操作，否则将产生异常。
     *
     * @param args
     */

    public static void main(String args[]) {
        String ss = "ABBA00000010506A1C00500300000118013701502493";
        byte[] bytes = ss.trim().replace(" ", "").getBytes();
//        System.out.println(bytes);

        //1
        String s = ClientHandler.byte2Hex(bytes);
//        System.out.println(s);


        //2
//        byte b = ClientHandler.hexToByte(ss);
//        System.out.println(b);

        //3
        byte[] bytes1 = ClientHandler.hexToByteArray(ss);
        for (byte b : bytes1) {
            System.out.print(b + " ");
        }

        System.out.println(bytes1);
    }


}
