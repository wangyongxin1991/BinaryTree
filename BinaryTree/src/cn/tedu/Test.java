/**
 * 
 */
package cn.tedu;
/**
 * @ClassName Test
 * @Describe ����ִ��˳��       ��̬�������� ����ֵ> ʵ����������+��ֵ >��̬���� > ��̬�����  > main > �������� > ���췽��
 *   ��������:ÿnewһ�ζ���ͼ���һ��
 *   ��̬�����ᰴ��������˳������������������Ϊ�����͵�Ĭ��ֵ��������ֵΪ��ʼ����ֵ��
 *   ������Ϻ�,�ٰ�������˳����������Ϊ��ʼ����ֵ�����û�г�ʼ����ֵ��������
 *   ��ı����������ĳ�ʼ�����̡�
 * @author  wyx
 * @date 2017��10��26�� ����9:43:17
 */
public class Test
{
    //ע�⣺����һ����Ա������ֱ�ӳ�ʼ�����ھ�̬������н��г�ʼ���ǵȼ۵ģ���������������Դ�����ж����˳����еġ�
    public static int k = 0;
    public static Test t1 = new Test("t1");
    public static Test t2 = null;//new Test("t2");
    public static int n = 99;

    public static int i = print("i");
    //���ʵ������:ʵ�������ʱ��ʹ��ڵ���
    public int x = 2;
    public int j = print("j");

    {
        print("�����");
    }
    static
    {
        print("��̬��");
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