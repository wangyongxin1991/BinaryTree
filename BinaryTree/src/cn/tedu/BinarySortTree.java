/**
 * 
 */
package cn.tedu;

/**
 * @ClassName BinarySortTree
 * @author  wyx
 * @date 2017��10��15�� ����10:31:46
 * 
 * �����������ֳƶ��������
 * 1)����ʹһ�ſյ���
 * 2)������������,�������������нڵ�С�ڸ��ڵ�
 * 3)������������,�������������нڵ���ڸ��ڵ�
 * 4)��������Ҳ�Ƕ���������
 * 
 * 
 * 
 */
public class BinarySortTree
{

    private BTSNode root = null;

    public void insert(int value)
    {
        BTSNode p = root;
        //���ǰһ���Ľڵ�
        BTSNode pre = null;

        //����ڵ㲻Ϊ��,����������  TODO ������ѭ��
        while (Utils.objectIsNotEmpty(p))
        {
            pre = p;
            if (Utils.compare(value, p.getValue()))
            {
                p.getRightNode();
            } else if (Utils.compare(p.getValue(), value))
            {
                p.getLeftNode();
            } else
            {
                return;
            }

        }

        // ���ڵ�Ϊ��
        if (Utils.objectIsEmpty(p))
            //������ڵ�Ϊ��,��ֵ�浽���ڵ�
            root = new BTSNode(value);
        else if (Utils.compare(value, p.getValue()))
            //��������ֵ�ȸ��ڵ�� ,���½ڵ�ŵ�������
            pre.setRightNode(new BTSNode(value));
        else
            //��������ֵ�ȸ��ڵ�С , ���½ڵ�ŵ�������
            pre.setLeftNode(new BTSNode(value));
    }
    //���ʽڵ�
    public static void visit(BinarySortTree p)
    {

        System.out.println(p.toString() + " ");
    }
    /**
      * @Method main()
      * @TODO   
      * @return void
      * @throws Exception
      */
    public static void main(String[] args)
    {
        BinarySortTree tree = new BinarySortTree();
        int[] num =
        {4, 7, 2, 1, 10, 6, 9, 3, 8, 11, 2, 0, -2};
        for (int i = 0; i < num.length; i++)
        {
            tree.insert(num[i]);
            System.out.println(num[i]);
        }

    }

}
