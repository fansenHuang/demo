package com.druid.filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
 
import com.alibaba.druid.support.http.WebStatFilter;
 
/**
 * 配置StatView的Servlet
 * @author wendong
 *
 * 2019年3月1日
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
    initParams={
        @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
   }
)
public class DruidStatFilter extends WebStatFilter {
 
}
