package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebFilter("/*")
public class SensitiveFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")){
                    String value = (String) method.invoke(req, args);
                    if (value != null){
                        for (String str : list){
                            if (value.contains(str)){
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }

                if (method.getName().equals("getParameterMap")){
                    Map<String,String[]> map = (Map<String, String[]>) method.invoke(req, args);
                    Set<String> set = map.keySet();
                    if (map != null){
                        for (String key : set) {
                            for (String str : list) {
                                if(map.get(key)[0].contains(str)){
                                    map.get(key)[0] = map.get(key)[0].replace(str,"***");
                                }
                            }
                        }
                    }
                    return map;
                }

                return method.invoke(req,args);
            }
        });

        chain.doFilter(proxyReq, resp);
    }

    private List<String> list = new ArrayList<String>();
    public void init(FilterConfig config) throws ServletException {
        try {
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/sensitiveWord.txt");
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String line = null;
            while((line = br.readLine()) != null){
                list.add(line);
            }
            br.close();
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
