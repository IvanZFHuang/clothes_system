package org.javaboy.vhr.config;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description: @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/5 16:02
 * @Version 1.0
 */

@Configuration
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "vssbwe2999@sandbox.com";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY =
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBoM2z+QjFBaCLDeIzZr5C+GDq90+3QsfYM0mzry0y8x1cN3G5QblRvrxAcxSp0X0Emeyi46vaDLc7kM9ieOrXvJwAc03MUV1NXBmI+LBTUPHoDyMv/H/bqJXKM4IGyetKrvdPKJZ/J50JI7AHaTo6HEEivAgQFMW90MkzZ/9hl9JL6I+Mi366GoerBuY399iMc/VjJwvas2SCR/z0q6xqutEHfK+/jh2kTo/eYhzC25/Q2I2sXRxlr/G+wRG1HDtfOzRAYUUah2cGeCqSdQFJ+GqVtIxYhp+olzHG+yr8V0udsFTZsCi1D0NxuzkSkgfu0Z9iEhsZ6+fOotzkdvBRAgMBAAECggEAWXjXYriqb+sxY6lijx4Ehw8PPj8Te6eRbs3/uhFYfklF46e1TCxsMFsZbta/1XLt+qYPqmLA9FFAi9GpAwv49I2Pk9QCR9uFLec7DMqyUd+WCRmhrPZ4ffH/6b/hqLPoPvVDaBTYw81g27URRBxCf2ePId1tJ0RfNGQO6/eFUyNO0fzc36Yq5r8Y3+4E2ZXBgGh7GyZYtbyND84Nec9vuYyodUNSL/vyyDusOWVi8KpMQCgOd56qZXIo+CBYzVbNr/eKwlGzFWAoGJtlhaohhAeugH5Iqi6ZLPKC6fScduqNFHI6XUDthDekmwAp1G23SkIqRcU/8gurPRT2Gk4/UQKBgQC/UoHKRfWsofAd1zn6uizFRTjn+uOl2q3NxKxIclhTH3ghARVIIHf/PI8D99Z/0iU/PMtBJNaY6lzu4HNNM1yZQvlo7B27YlpPcQqUBcued3FHduSRDceQRA2PJA/lgP1fcC1cewrDtk/CtMrH0Y5ixKjDVhj/dB+PeAAs+kw/3QKBgQCtcyKx/F5VXPdZ8nUq4M+rkew0H/fnWXAWW0ydRFhU5wUrq6y6pGNwG6lb+4svy0e83M5+aC15pp1yMnqbXvOY29GK+7oCGUWg2infmBnkf9xhd9/lDznCFUfKK3yz3q2bb6IuuB/I2m5jfhxQhFtzizV+bL00nuEIs6Doui3lBQKBgQCUHpphMTx8RHsTfzdiB5T1vRvLbY+lLeH1NlhzViNPZ0OnuaDyUEDWl9nZJp0oJFe116k8a/rANGFyhs59bFA6T4GsW3DBS+nDKy8XXk1ACBTpUQCv1E02QZmFwlOUSQLgSoaz3IZ+8rxZb4K2pGRpzvshD50W2J4+gpcQO0+g+QKBgG7z/tbCbInIrYYBXkguhUnoT6PMa2W3xcbXYnwb0zGEkr8r05OVQvLdDwqDL7dEH0DGMuWTuLtgBMmfVuT66XL38uQoQQXEqtDJng2lG7Maw5wp9bRud/EacdD23o+lO4L591JRgCuY5xKIAo7TDDkubOrRnnsBw0wwtBcLuf4NAoGAJ+uIlUn/HWL7Lfdxtc/tLQbeP0sdUonZbu1DlGZ+IrCu8FPoWToe2aw3fY9nywtghI14nvlZGwgygUTns4u6tviIAfevyyyyZueBl8tizr5V521KfX3hEjVayBy3jGt8tnlBnQyLHDG5Rlr9g+0Ec86pfdWP0rlxps0GQd2gqSE=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoo5M9EnnDdUdCQxuBwKIgBP8+RNoadV4wcev5zJlz+J2keNHWKDg4GxKuy6q/kQbuWTXGlHV7WlM1E71wTjEE9Q0Zr9YUHkVG9E1wfurHqbAZvMskoMXhd48lXBtCpEeYEyrt4+3Cw3wrYcPqXDCne9SrTVFjivvw/g27TveMGxKdOhziFnVEJYtm9Y0mdeFAgQrNN4SuIZHG+yUzV0z3wj3Tyku8zCNLKJhNr2UWsTKGKVtNblHG6oZXtoXHSXbUxC+D3Sz1THfK2M0SZB06IHi1IzFOwZbh59NkIXZtUSkVJVbVb+OmNHXwTJjB2swsj0TiRK3qbxxSjBXpH6gnQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url =
            "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url =
            "http://ranran.free.idcfengye.com/alipay/static/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
