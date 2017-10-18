/**
 * 
 */
package cn.tedu;

import java.util.LinkedList;

/**
 * @ClassName BinarySortTree
 * @author  wyx
 * @date 2017年10月15日 下午10:31:46
 * 
 * 二叉排序树又称二叉查找树
 * 1)可以使一颗空的树
 * 2)若左子树不空,则左子树的所有节点小于根节点
 * 3)若右子树不空,则右子树的所有节点大于根节点
 * 4)左右子树也是二叉排序树
 */
public class BinarySortTree
{
    private BTSNode root;

    /**
      * @Method insert()
      * @TODO   按一定顺序批量插入数据或插入数据,数据不能重复  TODO 插入的值不对
      * @return BTSNode
      * @throws Exception
     */
    public BTSNode insert(BTSNode node)
    {
        BTSNode nodeNow = root;
        // 根节点为空
        if (Utils.objectIsEmpty(root))
        {
            //如果根节点为空,把值存到根节点
            root = node;
            //System.out.println(root.getValue() + "根节点插入");
            return root;
        }

        while (Utils.objectIsNotEmpty(nodeNow))
            {
                //新节点比临时节点大  并且 比根节点大
            if (Utils.compare(node.getValue(), nodeNow.getValue()))
                {
                    //空的节点才能插入
                if (Utils.objectIsEmpty(nodeNow.getRightNode()))
                    {
                    nodeNow.setRightNode(node);
                        // System.out.println(pre.getValue() + "插入右子树");
                        break;
                    } else
                    {
                        //如果节点不空 , 继续遍历下一个节点
                    nodeNow = nodeNow.getRightNode();
                        //System.out.println(q.getValue() + "遍历右节点");
                    }
            } else if (Utils.compare(nodeNow.getValue(), node.getValue()))
                {
                    //空节点
                if (Utils.objectIsEmpty(nodeNow.getLeftNode()))
                    {
                    nodeNow.setLeftNode(node);
                        //System.out.println(pre.getValue() + "插入左子树");
                        break;
                    } else
                    {
                    nodeNow = nodeNow.getLeftNode();
                    }
            } else if (node.getValue() == nodeNow.getValue())
              {
                System.out.println(nodeNow.getValue() + "数据重复");
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
        System.out.println("中序遍历结果:");
        //preorder(node);
        eigodic(node);
    }

    //二叉树的层次遍历
    public static void eigodic(BTSNode root)
    {
        if (Utils.objectIsEmpty(root))
            return;

        BTSNode current = null;
        LinkedList<BTSNode> list = new LinkedList<>();
        list.offer(root);
        while (Utils.objectIsNotEmpty(list))
        {
            current = list.poll();//取出队头元素
            if (Utils.objectIsEmpty(current))
            {
                return;
            }
            System.out.print(current.getValue() + "--");
            //如果左节点不空 , 取出左节点 ,放到队列
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

    // 递归实现前序遍历  
    protected static void preorder(BTSNode p)
    {
        if (p != null)
        {
            preorder(p.getLeftNode());
            visit(p);
            preorder(p.getRightNode());
        }
    }
    //访问节点
    public static void visit(BTSNode p)
    {
        System.out.println(p.getValue());
    }
}
