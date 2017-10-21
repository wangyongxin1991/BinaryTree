/**
 * 
 */
package cn.tedu;

import java.util.LinkedList;

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
    private static BSTNode root;

    /**
      * @Method insert()
      * @TODO   ��һ��˳�������������ݻ��������,���ݲ����ظ�    TODO BUG�����������
      * @return BTSNode
      * @throws Exception
     */
    public BSTNode insert(BSTNode node)
    {
        BSTNode nodeNow = root;
        // ���ڵ�Ϊ��
        if (Utils.objectIsEmpty(root))
        {
            root = node;
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
      * @Method deleteNode()
      * @TODO  ɾ��һ���ڵ�   TODO δ����
      * @return void
      * @throws Exception
     */
    public static BSTNode deleteNode(BSTNode newNode)
    {
        BSTNode temp = new BSTNode();
        boolean isLeftNode = false;
        if (Utils.objectIsEmpty(root))
        {
            return root;
        }
        temp = root;
        BSTNode parent = new BSTNode();
        while (true)
        {
            //�Ƚϵ�ǰ�ڵ�,���С�ڵ�ǰ�ڵ�ͱ���������
            if (Utils.compare(temp.getValue(), newNode.getValue()))
            {
                isLeftNode = true;
                parent = temp;
                temp = temp.getLeftNode();
                //�Ƚϵ�ǰ�ڵ�,������ڵ�ǰ�ڵ�ͱ���������
            } else if (Utils.compare(newNode.getValue(), temp.getValue()))
            {
                isLeftNode = false;
                parent = temp;
                temp = temp.getRightNode();
            } else if (newNode.getValue() == temp.getValue())
            {
                BSTNode LNode = null;
                if(Utils.objectIsNotEmpty(temp.getRightNode()))
                    LNode = temp.getRightNode();
                //�жϵ�ǰ�ڵ��Ƿ���Ҷ�ӽڵ�
                if (Utils.objectIsEmpty(temp.getLeftNode()) && Utils.objectIsEmpty(temp.getRightNode()))
                {
                    if (isLeftNode == true)
                    {
                        parent.setLeftNode(null);
                    }
                    if (isLeftNode == false)
                    {
                        parent.setRightNode(null);
                    }
                    break;
                    //�����ǰ�ڵ㲻��Ҷ�ӽڵ� ,������ǰ�ڵ�������� ,������������ҽڵ�,���ҽڵ����ɾ����λ��. û���ҽڵ�,�õ�ǰ�ڵ���������ĸ��ڵ����ɾ���Ľڵ�
                } else if (Utils.objectIsNotEmpty(temp.getLeftNode()) && Utils.objectIsNotEmpty(temp.getRightNode()))
                {
                    BSTNode LParent = new BSTNode();

                    BSTNode RightTemp = null;
                    RightTemp = temp.getRightNode();

                    BSTNode LeftTemp = temp.getLeftNode();
                    while (Utils.objectIsNotEmpty(LeftTemp))
                    {
                        LParent = LeftTemp;
                        LeftTemp = LeftTemp.getRightNode();
                    }
                    parent.setLeftNode(LParent);

                    LParent.setRightNode(RightTemp);
                    break;

                    // û���ҽڵ�,�õ�ǰ�ڵ���������ĸ��ڵ����ɾ���Ľڵ�
                } else
                {
                    parent.setLeftNode(temp.getLeftNode());
                    break;
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
        BSTNode node = null;
        int[] num =
        {6, 11, 2, 7, 1, 10, 5, 9, 3, 8, 4};
        for (int i = 0; i < num.length; i++)
        {
            node = tree.insert(new BSTNode(num[i]));
        }
        System.out.println("����������:");
        preorder(node);
        // BSTNode deleteNode = deleteNode(new BSTNode(5));
        // preorder(deleteNode);
        //eigodic(node);
    }

    //�������Ĳ�α���
    public static void eigodic(BSTNode root)
    {
        if (Utils.objectIsEmpty(root))
            return;

        BSTNode current = null;
        LinkedList<BSTNode> list = new LinkedList<>();
        list.offer(root);
        while (Utils.objectIsNotEmpty(list))
        {
            current = list.poll();//ȡ����ͷԪ��
            if (Utils.objectIsEmpty(current))
            {
                return;
            }
            System.out.println(current.getValue() + "--");
            //�����ڵ㲻�� , ȡ����ڵ� ,�ŵ�����
            if (Utils.objectIsNotEmpty(current.getLeftNode()))
            {
                list.offer(current.getLeftNode());
            }
            if (Utils.objectIsNotEmpty(current.getRightNode()))
            {
                list.offer(current.getRightNode());
            }
        }
    }

    // �ݹ�ʵ��ǰ�����  
    protected static void preorder(BSTNode p)
    {
        if (p != null)
        {
            preorder(p.getLeftNode());
            visit(p);
            preorder(p.getRightNode());
        }
    }
    //���ʽڵ�
    public static void visit(BSTNode p)
    {
        System.out.println(p.getValue());
    }
}
