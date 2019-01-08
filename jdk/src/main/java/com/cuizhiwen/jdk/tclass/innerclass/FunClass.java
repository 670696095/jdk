package com.cuizhiwen.jdk.tclass.innerclass;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 13:28
 */
public class FunClass {
    /**
     * 方法内部类
     *         由于方法内部类不能在外部类的方法以外的地方使用，因此方法内部类不能使用访问控制符和 static 修饰符。
     */
    private int a = 99;

    public void show(){
        final int  a= 25;//常量
        int b = 13; //变量

        class mInner{
            int c = 2;
            public void test(){
                System.out.println("访问外部类方法中常量："+a);
                System.out.println("访问内部类中的变量"+c);
                System.out.println(FunClass.this.a);

            }
        }
        mInner m = new mInner();
        m.test();
    }

    public static void main(String[] args) {
        FunClass funClass = new FunClass();
        funClass.show();
    }
}
