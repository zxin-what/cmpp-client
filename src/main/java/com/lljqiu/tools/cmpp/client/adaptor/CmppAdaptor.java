package com.lljqiu.tools.cmpp.client.adaptor;

import com.lljqiu.tools.cmpp.client.codec.MPCodecFactory;
import com.lljqiu.tools.cmpp.client.handler.ClientHandler;
import com.lljqiu.tools.cmpp.client.utils.GateWayConfig;
import com.lljqiu.tools.cmpp.client.utils.ReadPropertiesUtil;
import com.lljqiu.tools.cmpp.client.utils.SocketClient;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * @author zhangxin
 * 2019/10/16
 */
public class CmppAdaptor {

    public final static Logger log = LoggerFactory.getLogger(CmppAdaptor.class);


    private IoSession serverSession = null;
    private NioSocketConnector connector = null;

    private GateWayConfig gatewayConfig;

    private static volatile CmppAdaptor instance = null;

    public static CmppAdaptor getInstance(GateWayConfig gateWayConfig) {

        if(gateWayConfig != null){
            if(instance == null){
                synchronized ("lock"){
                    if(instance == null){
                        instance = new CmppAdaptor(gateWayConfig);
                    }
                }
            }
        }
        return instance;
    }

    private CmppAdaptor(GateWayConfig gateWayConfig) {
        if(gateWayConfig != null){
            this.gatewayConfig = gateWayConfig;
        }
        if (serverSession == null){
            connPushServer();
        }
    }

    public void connPushServer() {
        try {
            // 创建客户端连接器.
            connector = new NioSocketConnector();
            connector.getFilterChain().addLast("logger", new LoggingFilter());
            connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MPCodecFactory("UTF-8")));

            // 设置连接超时检查时间
            connector.setConnectTimeoutCheckInterval(30);
            connector.setHandler(new ClientHandler());

            // 建立连接
            log.info("connection server ip={},port{}", gatewayConfig.getSpIp(), gatewayConfig.getPort());
            log.info("connection server name={},port{}", gatewayConfig.getServiceId(), gatewayConfig.getSharedSecret());
            ConnectFuture cf = connector.connect(new InetSocketAddress(gatewayConfig.getSpIp(), gatewayConfig.getPort()));
            // 等待连接创建完成
            cf.awaitUninterruptibly();
            serverSession = cf.getSession();
        } catch (Exception e) {
            log.error("connection server error {}", e.getMessage());
            closeSession();
        }
    }

    public void closeSession(){
        serverSession.close(true);
        serverSession = null;
        connector.dispose(true);
    }

    public void sendMessage(byte[] data){
        try {
            if (serverSession == null) {
                connPushServer();
            }
            System.out.println("gatewayConfig==userName" + gatewayConfig.getSpId());
            System.out.println("gatewayConfig==pass" + gatewayConfig.getSharedSecret());
            WriteFuture write = serverSession.write(data);
            boolean done = write.isDone();
            if(done){
                System.out.println("wancheng\n");
            }
//			closeSession();
        } catch (Exception e) {
            log.error("sendMessage error {}", e.getMessage());
//			closeSession();
        }
    }
}
