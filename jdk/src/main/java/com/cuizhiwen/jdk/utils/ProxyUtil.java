package com.cuizhiwen.jdk.utils;

public class ProxyUtil {
    /**
     * step1. 得到一个代理对象的java文件
     * step2. 编译成class文件
     * step3. classLoad加载磁盘上文件
     * step4. 通过反射获取代理对象
     * step5. 返回代理对象
     *
     */
    public static Object newProxyInstance(Object target){
          String content = "";
        Class targetInfo = target.getClass().getInterfaces()[0];
        String targetInfoName = targetInfo.getSimpleName();
        String packageContent = "package com.cuizhiwen.jdk";
        String importContent = "import "+targetInfo.getName()+";";
        String firstContent = "public class $proxy implements"+targetInfoName+"{";
        return  null;
    }
}
