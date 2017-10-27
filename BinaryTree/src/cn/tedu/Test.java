/**
 * 
 */
package cn.tedu;
/**
 * @ClassName Test
 * @Describe 程序执行顺序       静态变量声明 不赋值> 实例变量声明+赋值 >静态方法 > 静态代码块  > main > 构造代码块 > 构造方法
 *   构造代码块:每new一次对象就加载一次
 *   静态变量会按照声明的顺序先依次声明并设置为该类型的默认值，但不赋值为初始化的值。
 *   声明完毕后,再按声明的顺序依次设置为初始化的值，如果没有初始化的值就跳过。
 *   类的编译决定了类的初始化过程。
 * @author  wyx
 * @date 2017年10月26日 下午9:43:17
 */
public class Test
{
    //注意：定义一个成员变量并直接初始化与在静态代码块中进行初始化是等价的，都是依据它们在源代码中定义的顺序进行的。
    public static int k = 0;
    public static Test t1 = new Test("t1");
    public static Test t2 = null;//new Test("t2");
    public static int n = 99;

    public static int i = print("i");
    //类的实例变量:实例化类的时候就存在的类
    public int x = 2;
    public int j = print("j");

    {
        print("构造块");
    }
    static
    {
        print("静态块");
    }

    public Test(String str)
    {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;
    }

    public static int print(String str)
    {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String args[])
    {
        Test t = new Test("init");
    }
}