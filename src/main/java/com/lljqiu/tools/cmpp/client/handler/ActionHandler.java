/**
 * Project Name cmpp-client
 * File Name package-info.java
 * Package Name com.lljqiu.tools.cmpp.client.handler
 * Create Time 2018年8月30日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.cmpp.client.handler;

import com.lljqiu.tools.cmpp.client.action.ActiveTestRespAction;
import com.lljqiu.tools.cmpp.client.utils.MsgCommand;
import org.apache.mina.core.session.IoSession;

import com.lljqiu.tools.cmpp.client.action.ActionService;
import com.lljqiu.tools.cmpp.client.stack.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 * ClassName: ActionHandler.java <br>
 * Description: 消息分发器<br>
 * @author name：liujie <br>email: liujie@lljqiu.com <br>
 * @date: 2018年3月15日<br>
 */
public class ActionHandler {

    private final static Logger logger = LoggerFactory.getLogger(ActionHandler.class);
    /** 
     * Description：消息处理-消息分发
     * @param session
     * @param command
     * @throws Exception
     * @return void
     * @author name：liujie <br>email: liujie@lljqiu.com
     **/
    public static void process(IoSession session, BaseMessage command) throws Exception {

        ActionService service = MessageFactory.createService(command.getMsgCommand());
        if(service != null){
            service.doProcess(session, command);
        }else{
            if(MsgCommand.CMPP_ACTIVE_TEST == command.getMsgCommand()){
                service = new ActiveTestRespAction();
                service.doProcess(session, command);
            }
        }
    }
}
