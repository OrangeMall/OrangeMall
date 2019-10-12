package com.orange.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101100660447";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCad5EYPBuOAYlT/G6Aa/Sa1SJelW70GBdjUS7iOybUCRw78EMsKV32f0JehiIK7zhfK4sjbbd655smaD/vD9fD4DveyGt1D+7XGGlF0a93LTbNIjJLX/HxSvBLyjILy2Rf55LxIqS5i4Bmq+0t7xh/+3JxHaRUU9dGXH5pSAxfWkUCkKGEtJosSI4CWIqvjngSA/9Q+wWbNdeaAfdDyj630IolCDUEk929zANj45aVvYRPBs0V4VvmYlzs8Mveks5+Oknit8EApmVG6KB0YBuLyW5OFzNmZ6dK7BkSeDAQMc+gHzkZFbyvCBnH+XySxGbk2ZuUSysCaZvhGMymGze1AgMBAAECggEAVhljhPCsI0Fz/J5uMaL7GvrGR5Zf3Cs5jiCIU43JHNNfK4HGz2zXdTiGFA4MF7Az6chpq/vSE+3ZK1VcnbJlAEeS16E7VGrnJHn04/f3KCTJsRnokt8OCwNMYdJ4ht5+On7oBwTacJnznkci00G8lEniBm8RU/fPvOZ9h82jJ9pZgO7kRbdllFU60FZTPwLDmJIsslCSdpcGezB86oiExeV2FZswa97IqnU5zq3zLJVizTKLCIVO+LAP9tONdV+tdddq+f2uFht7TuyloDcPqUWpG3Zbu5we4IsVV2iAa+K6WcgQurMV8MKMWRY/dfgx2Ki7/yNGemFxk904u2zqgQKBgQDHwyf06mBHmttzXGOxvt7ctQgFnnbNsZQjir9wZ4g0W/g9cUlepGoYbN8YHFdtIZ4WjwlBieMJWQFoWasfh4tXoalObYCTwiKLnKZnOyh5zns2n+gCQ0IMmsKQYGH7Jt0velhUjCGWoSbTdNrHt7P/GlXMrrkgRIKCTsruzGx/UQKBgQDF8/yW370DFf8nz+0OuUf4H/0hO5GgS3O5STkF9pVwlnGTz6uQvMHzj0+Wx0ahU+HgEslrHuQ25iJQWFMj9X+sMgPWLgY3/vEqB34cCVH7hdl2a+9eiPH6+PmZuLQOACsb4EwcMDKrQx90lGNBGNk2UrP9fIbNzZ119HrTSrWBJQKBgFJG5kEw+8DiXnrQVduS4xYCljBCSWqFNp/A+QKiEe6G5uLfszmA/JXc2bKDkdrIGuXtugE9er6R40uIizvsRw8r7aD45xl0v2fDeKJSMmShEAy6pgOwkhbA81wl5pVcN4Pjn1gLc5Yn/+beXXIfDssGnMo2ONe6gAqNy3W5ywJRAoGBALAWfCjR2lc2aAVIRv4D/2tPOWMolEBdHhJCeoE9em3uxhXQdDOKVZWNdCUSG1hDP/iNfbLWhff3+6oxB7RDHFFXJGaQBmQlWu4iQCI8gDsYM/vNw976PxccBxyhWznhGHfxrIKetVP3n7GaljhAHGjgZNAmx9um/l0BH4l5OcApAoGBALsgp2DOXtlCc2a+9PEPVyDQBmsZqGpgAppTri8VHeVGIVnwlJjkbTCJpROFmR5tHYCrZ08GYCRshPv7+VIkibn/KZKQoynMntdmzAgyJ5CSdrcD7V9ukAzjRJrtQ15p/dJLS9+dyaBkqEqzIN2OiTsrzZDOOfHFnDtT37cy0eeI";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtjViCLIZHf1fmk5fPAXA7GXwdz3a04Ciy0f7DDJY7NrUiv4ILtCDWQBcbX+qjf+qylzsvsBlXL9rnODG6WFYP1uX3nB9gijKqYmm6k8qxOmjEssmSg40JC0sMAflsFMlqRm+1q6mWxf4nbftzs5UDO2oJvuUREG936c3AV2lppOVxoDZBxKCM9QOVD6FG6Mdrcxl9VPBjqe3RmdQGRXsoWN1YNIN2/KkGlL7+1EZav/XgJPcWQdOLssF9GhKNMxuAiQlgGn5uUXjsXe1/LdwBFWHDsLATquuSRzVll7GJiPUN6fgmSROzsHluU+sUVjposWPnOdJ713m+dGaBsQQnwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/orange/notify_url";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/orange/return_url";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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

