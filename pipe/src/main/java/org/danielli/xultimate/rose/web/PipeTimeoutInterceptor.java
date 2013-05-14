package org.danielli.xultimate.rose.web;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.portal.Pipe;
import net.paoding.rose.web.portal.PortalUtils;

/**
 * Pipe中关于timeout的拦截器。
 * 
 * @author Daniel Li
 * @since 13 Jun 2013
 * @see net.paoding.rose.web.ControllerInterceptorAdapter
 */
@Component("pipeTimeoutInterceptor")
public class PipeTimeoutInterceptor extends ControllerInterceptorAdapter{
	
	private final Long PIPE_TIMEOUT_MILLIONSECONDS = 300L;
	
	public PipeTimeoutInterceptor() {
		 setPriority(9000);		// 设置优先级
	}
	
	@Override
	protected boolean isForAction(Method actionMethod, Class<?> controllerClazz) {
		// 判断方法参数中是否包含Pipe类型，如果包含，返回true，否则返回false。
        for (Class<?> paramType : actionMethod.getParameterTypes()) {
            if (paramType == Pipe.class) {
                return true;
            }
        }
        return false;
	}
	
	@Override
	protected Object before(Invocation inv) throws Exception {
		Pipe pipe = PortalUtils.getPipe(inv);
        if (pipe != null && pipe.getInvocation() == inv) {
        	// 修改默认响应时间，如果不设置，默认为无限长，会导致客户端无法接收到数据，此处设置默认时间为300毫秒。
        	if (pipe.getTimeout() <= 0) {
        		pipe.setTimeout(PIPE_TIMEOUT_MILLIONSECONDS);
        	}
        }
		return super.before(inv);
	}
}
