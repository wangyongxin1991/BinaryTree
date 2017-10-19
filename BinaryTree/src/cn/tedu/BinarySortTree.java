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
    private static BSTNode root;

    /**
      * @Method insert()
      * @TODO   按一定顺序批量插入数据或插入数据,数据不能重复  TODO 插入的值不对
      * @return BTSNode
      * @throws Exception
     */
    public BSTNode insert(BSTNode node)
    {
        BSTNode nodeNow = root;
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
      * @Method deleteNode()
      * @TODO  删除一个节点   TODO 未测试
      * @return void
      * @throws Exception
     */
    public static BSTNode deleteNode(BSTNode newNode)
    {
        BSTNode temp = new BSTNode();
        BSTNode parent = root;
        boolean isLeftNode = false;
        if (Utils.objectIsEmpty(root))
        {
            return root;
        }
        temp = root;
        while (Utils.objectIsNotEmpty(temp))
        {
            parent = temp;
            //比较当前节点,如果小于当前节点就遍历左子树
            if (Utils.compare(temp.getValue(), newNode.getValue()))
            {
                isLeftNode = true;
                temp = temp.getLeftNode();
                //比较当前节点,如果大于当前节点就遍历左子树
            } else if (Utils.compare(newNode.getValue(), temp.getValue()))
            {
                isLeftNode = false;
                temp = temp.getRightNode();
            } else if (newNode.getValue() == temp.getValue())
            {
                BSTNode LNode = null;
                if(Utils.objectIsNotEmpty(temp.getRightNode()))
                    LNode = temp.getRightNode();
                //判断当前节点是否是叶子节点
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
                    //如果当前节点不是叶子节点 ,遍历当前节点的左子树 ,如果左子树有右节点,让右节点代替删除的位置. 没有右节点,让当前节点的左子树的根节点代替删除的节点
                } else if (Utils.objectIsNotEmpty(temp.getLeftNode()) && Utils.objectIsNotEmpty(temp.getRightNode()))
                {
                    temp = temp.getRightNode();
                    parent.setLeftNode(temp);
                    temp.setRightNode(LNode);

                    break;

                    // 没有右节点,让当前节点的左子树的根节点代替删除的节点
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
        {4, 2, 7, 1, 10, 6, 9, 3, 8, 11, 5};
        for (int i = 0; i < num.length; i++)
        {
            node = tree.insert(new BSTNode(num[i]));
        }
        System.out.println("中序遍历结果:");
        //preorder(node);
        deleteNode(new BSTNode(11));
        eigodic(node);
    }

    //二叉树的层次遍历
    public static void eigodic(BSTNode root)
    {
        if (Utils.objectIsEmpty(root))
            return;

        BSTNode current = null;
        LinkedList<BSTNode> list = new LinkedList<>();
        list.offer(root);
        while (Utils.objectIsNotEmpty(list))
        {
            current = list.poll();//取出队头元素
            if (Utils.objectIsEmpty(current))
            {
                return;
            }
            System.out.println(current.getValue() + "--");
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
    protected static void preorder(BSTNode p)
    {
        if (p != null)
        {
            preorder(p.getLeftNode());
            visit(p);
            preorder(p.getRightNode());
        }
    }
    //访问节点
    public static void visit(BSTNode p)
    {
        System.out.println(p.getValue());
    }
}
