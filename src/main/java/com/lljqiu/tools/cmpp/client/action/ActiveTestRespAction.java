package com.lljqiu.tools.cmpp.client.action;

import com.lljqiu.tools.cmpp.client.adaptor.CmppAdaptor;
import com.lljqiu.tools.cmpp.client.stack.MsgActiveTestResp;
import com.lljqiu.tools.cmpp.client.utils.Constants;
import com.lljqiu.tools.cmpp.client.utils.MsgCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author zhangxin
 * 2019/10/18
 */
public class ActiveTestRespAction extends ActionFactoy {

    private final static Logger logger = LoggerFactory.getLogger(ActiveTestRespAction.class);

    @Override
    protected void exec() throws Exception {

        logger.info("<响应服务端心跳>");
        MsgActiveTestResp active = new MsgActiveTestResp();
        active.setTotalLength(Constants.MessageTotalLength.ACTIVE_TEST);
        active.setCommandId(MsgCommand.CMPP_ACTIVE_TEST_RESP);
        active.setSequenceId(message.getSequenceId());
        active.setReserved((byte)0);
        //心跳包响应
        CmppAdaptor.getInstance(null).sendMessage(active.toByteArry());
    }

    @Override
    protected <T> T readMessage() throws Exception {
        return null;
    }

}
