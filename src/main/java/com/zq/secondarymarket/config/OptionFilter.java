package com.zq.secondarymarket.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * optionFilter  跨域OPTION方法验证
 */
@WebFilter(filterName="optionFilter",urlPatterns="/*")
@Order(value = 1)
@Configuration
public class OptionFilter extends OncePerRequestFilter {
    private final static Logger logger = LoggerFactory.getLogger(OptionFilter.class);



    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String method = httpServletRequest.getMethod();

        //安全校验
        //safeCheck(httpServletRequest,httpServletResponse);

        //OPTION跨域
        if (HttpMethod.OPTIONS.matches(method)) {
            String origin = httpServletRequest.getHeader("Origin");

            httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
            httpServletResponse.setHeader("Access-Control-Allow-Headers","Origin,Content-Type,Accept,Authorization,X-Requested-With,userId");
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void safeCheck(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
    {
        //host攻击 ，跨域任意来源访问
        String requestOrigin = httpServletRequest.getHeader("Origin");
        String requestHost = httpServletRequest.getHeader("host");

        logger.info("requestHost: "+requestHost+"    requestOrigin: "+requestOrigin);
        //String hostWhiteList = paramConfig.getHostWhiteList();
        String method = httpServletRequest.getMethod();
        if (requestHost != null ) {
            if(StringUtils.isNotEmpty(requestHost) )
            {
                System.out.println("requestHost: "+requestHost);
                logger.error("requestHost: "+requestHost);
                httpServletResponse.setStatus(403);
                return;
            }
            if(StringUtils.isNotEmpty(requestOrigin) )
            {
                System.out.println("requestOrigin: "+requestOrigin);
                logger.error("requestOrigin: "+requestOrigin);
                httpServletResponse.setStatus(403);
                return;
            }
        }
    }

    private boolean ipHostCheck(String hostWhiteList,String requestHost)
    {
        String ips = hostWhiteList.split(";")[0];
        String ports = hostWhiteList.split(";")[1];
        String ip = requestHost.split(":")[0];
        String port = requestHost.split(":")[1];
        logger.info("ips: "+ips+"   ports: "+ports);
        logger.info("ip: "+ip+"   port: "+port);
        if(ips.indexOf(ip) == -1 || ports.indexOf(port) == -1)
        {
            return true;
        }
        return false;
    }
}
