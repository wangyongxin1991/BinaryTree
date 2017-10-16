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

    private BTSNode root;
    //TODO ��������
    public void searchkey()
    {

    }


    //TODO �����ֵ����
    public BTSNode insert(int val)
    {
        //�����ʱֵ����ʱ�Ľڵ�
        BTSNode pre = new BTSNode();
        pre.setValue(val);
        // ���ڵ�Ϊ��
        if (Utils.objectIsEmpty(root))
            //������ڵ�Ϊ��,��ֵ�浽���ڵ�
            root = pre;
        else
        {
            BTSNode q = this.root;
            while (true)
            {
                if (Utils.compare(val, q.getValue()))
                {
                    //�ڵ��ǿյĽڵ���ܲ���
                    if (Utils.objectIsEmpty(q.getRightNode()))
                    {
                        q.setRightNode(pre);
                        visit(q);
                        break;
                    } else
                    {
                        //����ڵ㲻�� , ����������һ���ڵ�
                        q = q.getRightNode();
                    }
                } else if (Utils.compare(root.getValue(), val))
                {
                    //�սڵ�
                    if (Utils.objectIsEmpty(q.getLeftNode()))
                    {
                        q.setLeftNode(pre);
                        break;
                    } else
                    {
                        q = q.getLeftNode();
                    }
                } else
                {
                    System.out.println(pre.getValue() + "�ڵ����!");
                    break;
                }
            }
        }
        return pre;
    }
    //���ʽڵ�
    public static void visit(BTSNode p)
    {

        System.out.println(p.getValue() + "�ڵ����");
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
        {4, 7, 2, 1, 10, 6, 9, 3, 8, 11, 5};
        for (int i = 0; i < num.length; i++)
        {
            tree.insert(num[i]);

        }

    }

}
