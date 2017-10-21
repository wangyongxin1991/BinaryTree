/**
 * 
 */
package cn.tedu;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName BinaryTreeDemo
 * @Describe 
 * @author  wyx
 * @date 2017年10月12日 下午11:30:51
 */
public class BinaryTreeDemo
{
    BTNode root;

    /**
     * @构造方法
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
      * @TODO   初始化二叉树  
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

    //二叉树的层次遍历
    public static void eigodic(BTNode root)
    {

        if (Utils.objectIsEmpty(root))
            return;

        BTNode current = null;
        LinkedList<BTNode> list = new LinkedList<>();
        list.offer(root);
        while (Utils.objectIsNotEmpty(list))
        {
            current = list.poll();//取出队头元素
            if (Utils.objectIsEmpty(current))
                return;
            System.out.println(current.getKey() + "--");
            //如果左节点不空 , 取出左节点 ,放到队列
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

    //访问节点
    public static void visit(BTNode p)
    {

        System.out.println(p.getKey() + " ");
    }

    // 递归实现前中后序遍历  
    protected static void preorder(BTNode p)
    {
        if (p != null)
        {

            preorder(p.getLeft());

            preorder(p.getRight());
            visit(p);
        }
    }


    // 非递归实现前中后序遍历
    public static void unrecursion(BTNode p)
    {
        Stack<BTNode> stack = new Stack<>();
        if (p != null)
        {
            //压栈
            stack.push(p);
            while (!stack.empty())
            {
                //出栈
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

        System.out.print(" 递归实现前序遍历:");
        //unrecursion(binary.getRoot());
        eigodic(binary.getRoot());
        System.out.println("\n");
    }

}

