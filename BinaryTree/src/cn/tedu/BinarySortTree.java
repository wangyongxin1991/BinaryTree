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
 */
public class BinarySortTree
{
    private BTSNode root;

    /**
      * @Method insert()
      * @TODO   ��һ��˳�������������ݻ��������,���ݲ����ظ�  TODO �����ֵ����
      * @return BTSNode
      * @throws Exception
     */
    public BTSNode insert(BTSNode node)
    {
        BTSNode nodeNow = root;
        // ���ڵ�Ϊ��
        if (Utils.objectIsEmpty(root))
        {
            //������ڵ�Ϊ��,��ֵ�浽���ڵ�
            root = node;
            //System.out.println(root.getValue() + "���ڵ����");
            return root;
        }

        while (Utils.objectIsNotEmpty(nodeNow))
            {
                //�½ڵ����ʱ�ڵ��  ���� �ȸ��ڵ��
            if (Utils.compare(node.getValue(), nodeNow.getValue()))
                {
                    //�յĽڵ���ܲ���
                if (Utils.objectIsEmpty(nodeNow.getRightNode()))
                    {
                    nodeNow.setRightNode(node);
                        // System.out.println(pre.getValue() + "����������");
                        break;
                    } else
                    {
                        //����ڵ㲻�� , ����������һ���ڵ�
                    nodeNow = nodeNow.getRightNode();
                        //System.out.println(q.getValue() + "�����ҽڵ�");
                    }
            } else if (Utils.compare(nodeNow.getValue(), node.getValue()))
                {
                    //�սڵ�
                if (Utils.objectIsEmpty(nodeNow.getLeftNode()))
                    {
                    nodeNow.setLeftNode(node);
                        //System.out.println(pre.getValue() + "����������");
                        break;
                    } else
                    {
                    nodeNow = nodeNow.getLeftNode();
                    }
            } else if (node.getValue() == nodeNow.getValue())
              {
                System.out.println(nodeNow.getValue() + "�����ظ�");
                break;
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
        System.out.println("����������:");
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
            preorder(p.getLeftNode());
            visit(p);
            preorder(p.getRightNode());
        }
    }
    //���ʽڵ�
    public static void visit(BTSNode p)
    {
        System.out.println(p.getValue());
    }
}
