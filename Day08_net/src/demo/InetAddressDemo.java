package demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 对ip地址的访问类
 */
public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); // 主机名+IP地址

        // 自己局域网内（同一网段内）的主机名才能拿到ip地址
        InetAddress inetAdd = InetAddress.getByName("LAPTOP-8VFER8KN");
        System.out.println(inetAdd);

        //拿到百度的ip地址
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);
        System.out.println(baidu.getHostAddress());
        System.out.println(baidu.getHostName());
    }

}
