package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxytest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();

        /*
        类加载器：真是对象.getClass().getClassLoader()
        接口数组：真是对象.getClass().getInterfaces()
        处理器：new InvocationHandler()
        */
        SaleComputer proxyLenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
            proxy:代理对象
            method：代理对象调用的方法，被封装为的对象
            args: 代理对象调用的方法时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("该方法执行了....");
//                System.out.println(method.getName());
//                System.out.println(args[0]);
                if (method.getName().equals("sale")){
                    double money = (double) args[0];
                    money = money * 0.85;
                    String obj = (String) method.invoke(lenovo, money);
                    return obj+"+鼠标垫";
                }else{
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

        String computer = proxyLenovo.sale(8000);
        System.out.println(computer);
    }
}
