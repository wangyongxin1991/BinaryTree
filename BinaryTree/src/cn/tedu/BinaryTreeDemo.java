/**
 * 
 */
package cn.tedu;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName BinaryTreeDemo
 * @Describe TODO
 * @author  wyx
 * @date 2017��10��12�� ����11:30:51
 */
public class BinaryTreeDemo
{
    BTNode root;

    /**
     * @���췽��
     */
    public BinaryTreeDemo(BTNode root)
    {
        this.root = root;
    }

    public BTNode getRoot()
    {
        return root;
    }
    /**
      * @Method init()
      * @TODO   ��ʼ��������  
      * @return BTNode
      * @throws Exception
     */
    public static BTNode init()
    {
        BTNode i = new BTNode("I");
        BTNode c = new BTNode("C", i, null);
        BTNode a = new BTNode("A");
        BTNode b = new BTNode("B", null, a);
        BTNode d = new BTNode("D", b, c);
        BTNode e = new BTNode("E");
        BTNode j = new BTNode("J");
        BTNode f = new BTNode("F", j, e);
        BTNode g = new BTNode("G", null, f);
        BTNode h = new BTNode("H", d, g);

        return h;
    }

    //�������Ĳ�α���
    public static void eigodic(BTNode root)
    {

        if (Utils.objectIsEmpty(root))
            return;

        BTNode current = null;
        LinkedList<BTNode> list = new LinkedList<>();
        list.offer(root);
        while (Utils.objectIsNotEmpty(list))
        {
            current = list.poll();//ȡ����ͷԪ��
            if (Utils.objectIsEmpty(current))
                return;
            System.out.println(current.getKey() + "--");
            //�����ڵ㲻�� , ȡ����ڵ� ,�ŵ�����
            if (Utils.objectIsNotEmpty(current.getLeft()))
            {
                list.offer(current.getLeft());
            }
            if (Utils.objectIsNotEmpty(current.getRight()))
            {
                list.offer(current.getRight());
            }
        }

    }

    //���ʽڵ�
    public static void visit(BTNode p)
    {

        System.out.println(p.getKey() + " ");
    }

    // �ݹ�ʵ��ǰ�к������  
    protected static void preorder(BTNode p)
    {
        if (p != null)
        {

            preorder(p.getLeft());

            preorder(p.getRight());
            visit(p);
        }
    }


    // �ǵݹ�ʵ��ǰ�к������
    public static void unrecursion(BTNode p)
    {
        Stack<BTNode> stack = new Stack<>();
        if (p != null)
        {
            //ѹջ
            stack.push(p);
            while (!stack.empty())
            {
                //��ջ
                p = stack.pop();
                visit(p);
                if (Utils.objectIsNotEmpty(p))
                unrecursion(p.getLeft());
                if (Utils.objectIsNotEmpty(p))
                unrecursion(p.getRight());
            }

        }

    }

    public static void main(String[] args)
    {
        BinaryTreeDemo binary = new BinaryTreeDemo(init());

        System.out.print(" �ݹ�ʵ��ǰ�����:");
        //unrecursion(binary.getRoot());
        eigodic(binary.getRoot());
        System.out.println("\n");
    }

}

