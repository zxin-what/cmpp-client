/**
 * Project Name cmpp-client
 * File Name Test.java
 * Package Name com.lljqiu.tools.cmpp.client
 * Create Time 2018年8月30日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.cmpp.client;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lljqiu.tools.cmpp.client.utils.MsgCommand;

/** 
 * ClassName: Test.java <br>
 * Description: <br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2018年8月30日<br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {
	
	public static void main(String[] args) throws Exception {
		
//		MsgConnect connect = new MsgConnect();
//        connect.setTotalLength(12 + 6 + 16 + 1 + 4);//消息总长度，级总字节数:4+4+4(消息头)+6+16+1+4(消息主体)
//        connect.setCommandId(MsgCommand.CMPP_CONNECT);//标识创建连接
//        connect.setSequenceId(MsgUtils.getSequence());//序列，由我们指定
//        connect.setSourceAddr(Constants.ServerConfig.gatewayConfig.getSpId());//我们的企业代码
//        connect.setTimestamp(Integer.parseInt(MsgUtils.getTimestamp()));//时间戳(MMDDHHMMSS)
//        byte[] authenticatorSource = MsgUtils.getAuthenticatorSource(Constants.ServerConfig.gatewayConfig.getSpId(), Constants.ServerConfig.gatewayConfig.getSharedSecret(), connect.getTimestamp()+"");
//		connect.setAuthenticatorSource(authenticatorSource);//md5(企业代码+密匙+时间戳)
//		connect.setVersion((byte) 0x30);//版本号 高4bit为3，低4位为0
////        SocketClient.getInstance().sendMessage(connect.toByteArry());
//
//        byte[] shortMessage = MsgUtils.toShortMessage("测试信息", "15231046587", Constants.ServerConfig.gatewayConfig);
//        System.out.println(Arrays.toString(shortMessage));
//        SocketClient.getInstance().sendMessage(shortMessage);
//		int parseInt = Integer.parseInt(MsgUtils.getTimestamp());
//		System.out.println(parseInt);
//		ByteArrayOutputStream bous = new ByteArrayOutputStream();
//        DataOutputStream dous = new DataOutputStream(bous);
//        dous.write(parseInt);
        
	}
	@Test
	public void test(){
		System.out.println(MsgCommand.CMPP_CONNECT_RESP);;
	}

	@Test
	public void sendConnect(){
//		MsgConnect connect = new MsgConnect();
//        connect.setTotalLength(12 + 6 + 16 + 1 + 4);//消息总长度，级总字节数:4+4+4(消息头)+6+16+1+4(消息主体)
//        connect.setCommandId(MsgCommand.CMPP_CONNECT);//标识创建连接
//        connect.setSequenceId(MsgUtils.getSequence());//序列，由我们指定
//        connect.setSourceAddr(Constants.ServerConfig.gatewayConfig.getSpId());//我们的企业代码
//        byte[] authenticatorSource = MsgUtils.getAuthenticatorSource(Constants.ServerConfig.gatewayConfig.getSpId(), Constants.ServerConfig.gatewayConfig.getSharedSecret(), MsgUtils.getTimestamp());
//		connect.setAuthenticatorSource(authenticatorSource);//md5(企业代码+密匙+时间戳)
//        connect.setTimestamp(Integer.parseInt(MsgUtils.getTimestamp()));//时间戳(MMDDHHMMSS)
//        connect.setVersion((byte) 0x30);//版本号 高4bit为3，低4位为0
//        SocketClient.getInstance().sendMessage(connect.toByteArry());
//		byte[] shortMessage = MsgUtils.toShortMessage("ceshi测试测试信息dasdfasdsddddddddddddddddddddddddddddddddddddddddddddddddddddddd啊打发手动阀手动阀阿斯蒂芬阿斯蒂芬阿斯顿发射点发士大夫阿斯顿发送地方阿斯蒂芬啊士大夫阿斯蒂芬阿三地方阿斯蒂芬阿三打法士大夫阿斯顿发士大夫阿斯顿发士大夫阿斯顿发送地方阿斯蒂芬", "15231046587", Constants.ServerConfig.gatewayConfig);
//		System.out.println(Arrays.toString(shortMessage));
//		SocketClient.getInstance().sendMessage(shortMessage);
	}
	
	@Test
	public void sendActive(){
//		MsgHead head = new MsgHead();
//		head.setTotalLength(12);// 消息总长度，级总字节数:4+4+4(消息头)+6+16+1+4(消息主体)
//		head.setCommandId(MsgCommand.CMPP_ACTIVE_TEST);// 标识创建连接
//		head.setSequenceId(MsgUtils.getSequence());// 序列，由我们指定
//		SocketClient.getInstance().sendMessage(head.toByteArry());
	}
}
