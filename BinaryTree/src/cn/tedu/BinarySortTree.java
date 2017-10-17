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
    // �����ʱֵ����ʱ�Ľڵ�
    BTSNode pre = null;

    /**
      * @Method insert()
      * @TODO   ��һ��˳�������������ݻ��������,���ݲ����ظ�  TODO �����ֵ����
      * @return BTSNode
      * @throws Exception
     */
    public BTSNode insert(BTSNode node)
    {

        // ���ڵ�Ϊ��
        if (Utils.objectIsEmpty(root))
        {
            //������ڵ�Ϊ��,��ֵ�浽���ڵ�
            root = node;
            //��ʱ�ڵ㸳��ֵ
            pre = node;
            //System.out.println(root.getValue() + "���ڵ����");
        }
        else
        {
            while (true)
            {
                //�½ڵ����ʱ�ڵ��  ���� �ȸ��ڵ��
                if (Utils.compare(node.getValue(), root.getValue()))
                {
                    //�յĽڵ���ܲ���
                    if (Utils.objectIsEmpty(root.getRightNode()))
                    {
                        root.setRightNode(node);
                        //��ʱ�ڵ�=�½ڵ�
                        pre = node;
                        // System.out.println(pre.getValue() + "����������");
                        break;
                    } else
                    {
                        //����ڵ㲻�� , ����������һ���ڵ�
                        root = root.getRightNode();
                        //System.out.println(q.getValue() + "�����ҽڵ�");
                    }
                } else if ( Utils.compare(root.getValue(), node.getValue()))

                {
                    //�սڵ�
                    if (Utils.objectIsEmpty(root.getLeftNode()))
                    {
                        root.setLeftNode(node);
                        pre = node;
                        //System.out.println(pre.getValue() + "����������");
                        break;
                    } else
                    {
                        root = root.getLeftNode();
                    }
                } else if (root.getValue() == pre.getValue())
                {
                    System.out.println(pre.getValue() + "���ݲ����ظ�");
                    return pre;
                } else
                {

                    return root;
                }
            }
        }
        return root;
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
        BTSNode node = null;
        int[] num =
        {4, 2, 7, 1, 10, 6, 9, 3, 8, 11, 5};
        for (int i = 0; i < num.length; i++)
        {
            node = tree.insert(new BTSNode(num[i]));
        }

        preorder(node);

    }
    //���ʽڵ�
    public static void visit(BTNode p)
    {
        System.out.println(p.getKey() + " ");
    }

    // �ݹ�ʵ��ǰ�����  
    protected static void preorder(BTSNode p)
    {
        if (p != null)
        {
            visit(p);
            preorder(p.getLeftNode());
            preorder(p.getRightNode());
        }
    }
    //���ʽڵ�
    public static void visit(BTSNode p)
    {

        System.out.println(p.getValue());
    }
}
